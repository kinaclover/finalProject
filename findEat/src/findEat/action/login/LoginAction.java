package findEat.action.login;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.LoginVO;
import findEat.DB.dao.LoginDAOImpl;

@Controller
public class LoginAction {
	/***********************************************************************************************************************/
	/*
	 * 	*** 로그인 프로세스
	 * 
	 * 	Login Action class
	 * 	- 로그인/로그아웃, 회원가입/탈퇴
	 * 	- 비밀번호 찾기 기능
	 * 	- OAuth2 를 활용한 로그인 작업(Naver, Google)
	 * 	- 각 작업 후 status값과 함께 status페이지로 이동
	 * 
	 *	로그인 관련 각 기능별 status value
	 *	- login			: 1
	 *	- update		: 2
	 *	- join			: 3
	 *	- delete		: 4
	 *	- findPassword	: 5
	 *
	/***********************************************************************************************************************/
	@Autowired
	private LoginDAOImpl loginDAO = null;
	
	@Autowired
	private LoginVO loginVO = null;

	//로그인 화면
	@RequestMapping("login.do")
	public String login(HttpServletRequest request) {
		String cont	= request.getContextPath();
		String path	= request.getHeader("referer");
		path	= path.substring(path.indexOf(cont));		//직전 페이지 주소
		request.getSession().setAttribute("path", path);	//로그인 후 로그인 페이지 직전에 있었던 페이지로 이동하기 위한 값 전송
	
		return "/login/login";
	}
	//로그인 로직
	@RequestMapping("loginPro.do")
	public String loginPro(String id, String pw, HttpServletRequest request) throws Exception {
		int idCheck	= (Integer)loginDAO.IdCheck(id);				//DB에 id가 있는지 여부 확인
		int check	= 0;											//로그인 성공여부 확인 값
		int status	= 1;
		int mdCheck	= 0;
		
		if(idCheck==1) check = (Integer)loginDAO.LoginPro(id, pw);	//DB에 id가 있다면 비밀번호와 함께 로그인 시도
		if(check==1) {												//로그인 성공시에만 실행
			request.getSession().setAttribute("id", id);
			mdCheck	= (Integer)loginDAO.ResetCheck(id);				//비밀번호 찾기를 통해 임시 비밀번호를 받았는지 여부 확인
		}
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.getSession().setAttribute("mdCheck", mdCheck);
		return "/login/status";
	}
	//로그아웃 로직
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();							//모든 세션값 삭제
		return "redirect:index.do";
	}
	
	//가입 페이지
	@RequestMapping("join.do")
	public String join(@ModelAttribute("loginVO") LoginVO loginVO) {
		return "/login/join";
	}
	//id중복검사 - ajax
	@ResponseBody
	@RequestMapping("idCheck.do")
	public String idCheck(@RequestBody String id) throws Exception{
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	//가입 로직
	@RequestMapping("joinPro.do")
	public String joinPro(LoginVO loginVO, HttpServletRequest request) throws Exception {
		loginVO.setReset(0);
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}
	
	//개인정보 수정 페이지
	@RequestMapping("modify.do")
	public String modify(HttpServletRequest request) throws Exception {
		String id	= (String)request.getSession().getAttribute("id");
		loginVO		= loginDAO.SelectPro(id);
		request.setAttribute("loginVO", loginVO);
		return "/login/modify";
	}
	//개인정보 수정 로직
	@RequestMapping("modifyPro.do")
	public String modifyPro(LoginVO loginVO, HttpServletRequest request) throws Exception {
		int mdCheck	= (Integer)request.getSession().getAttribute("mdCheck");		//비밀번호 찾기를 통해 임시 비밀번호를 받았는지 여부 확인
		if(mdCheck==1) {					//임시 비밀번호값이 있다면 초기화
			loginVO.setReset(0);
			request.getSession().removeAttribute("mdCheck");
		}
		int check	= (Integer)loginDAO.UpdatePro(loginVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}
	
	//회원 탈퇴 로직 - 수정 페이지의 버튼을 통해 바로 접근
	@RequestMapping("deletePro.do")
	public String deletePro(HttpServletRequest request) throws Exception {
		String id	= (String)request.getSession().getAttribute("id");
		int check	= (Integer)loginDAO.DeletePro(id);
		int temp	= 0;
		/*	calendar database delete - 해당 id의 모든 정보 삭제	*/
		if(check==1) {
			temp = (Integer)loginDAO.DeleteCalCheck(id);
			if(temp!=0) {
				check += (Integer)loginDAO.DeleteCal(id);
			}
			else {
				check+=1;
			}
		}
		int status	= 4;
		if(check>=2) request.getSession().invalidate();		//삭제 로직 완료 후 세션 초기화
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}
	
	//임시 비밀번호 발급 페이지
	@RequestMapping("findPassword.do")
	public String findPassword() {
		return "/login/findPw";
	}
	//입력한 이메일 값 확인(임시 비밀번호 발급 페이지) - ajax
	@ResponseBody
	@RequestMapping("emailCheck.do")
	public String emailCheck(@RequestParam(value="id")String id,@RequestParam(value="email")String email) throws Exception {
		int check		= loginDAO.EmailCheck(id, email);
		return String.valueOf(check);
	}
	//임시 비밀번호 발급 - 메일 전송
	@RequestMapping("findPasswordPro.do")
	public String findPwPro(String id, String email, HttpServletRequest request) throws Exception{
		String pw			= "";
		Random rd = new Random();
		for(int i=0;i<8;i++) {			//랜덤 값을 이용하여 임시 비밀번호 생성
			pw += rd.nextInt(10);
		}
		loginVO.setId(id);
		loginVO.setEmail(email);
		loginVO.setPw(pw);				//해당 id DB에 임시비밀번호로 비밀번호 재설정
		loginVO.setReset(1);
		int status	= 5;
		int check	= loginDAO.UpdatePro(loginVO);
		if(check==1) {
			try {
				final String hostId		= "gihd3project@gmail.com";			//이메일 전송할 메일 계정
				final String hostPw		= "success100";
				String host				= "smtp.gmail.com";
				String subject			= "FindEat 비밀번호 전송 메일입니다.";
				String msg				= "<!DOCTYPE html>\n" + 			//메일의 내용
						"<html>\n" + 
						"<head>\n" + 
						"<meta charset=\"UTF-8\">\n" + 
						"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n" + 
						"</head>\n" + 
						"<body>\n" + 
						"<div class=\"mt-5 mb5 d-block\" style=\"width:60%; margin:0 auto\">\n" + 
						"	<p class=\"mt-3 mb-3\">요청하신 임시 비밀번호는 "+pw+"입니다.</p>\n<br/><br/>" + 
						"	<button class=\"btn-outline-primary btn-sm\"" + 
						" onclick=\"window.location='http://localhost:8080/findEat/index.do'\">FindEat 페이지로 이동</button>\n" + 
						"</div>\n" + 
						"</body>\n" + 
						"</html>";
				//메일 서비스 설정 값
				Properties p = System.getProperties();
				p.put("mail.smtp.host",host);
				p.put("mail.smtp.auth","true");
				//p.put("mail.smtp.ssl.starttls.enable", "true");
				p.put("mail.smtp.port","465");
				p.put("mail.smtp.ssl.enable","true");
				p.put("mail.smtp.ssl.trust", host);
				Session se	= Session.getDefaultInstance(p, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(hostId,hostPw);
					}
				});
				
				Message mm	= new MimeMessage(se);
				
				mm.setFrom(new InternetAddress("FindEat"));								//보내는 사람 
				mm.setRecipient(Message.RecipientType.TO, new InternetAddress(email));	//받는 사람
				mm.setSubject(subject);						//제목
				mm.setText(msg);							//내용
				mm.setHeader("content-Type", "text/html");	//헤더 타입
				javax.mail.Transport.send(mm);				//메일 송신
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("status", status);
		request.setAttribute("check", check);
		return "/login/status";
	}
	
	@RequestMapping("naverLoginCallback.do")
	public String naverLoginCallback() {
		return "/login/naverLoginCallback";
	}
	
	@RequestMapping("naverLoginPro.do")
	public @ResponseBody String naverLoginPro(String id, HttpServletRequest request) throws Exception {
		int idCheck	= 1;
		int check	= 1;
		int status	= 1;
		int mdCheck	= 0;
				
		request.getSession().setAttribute("id", id);
		mdCheck	= (Integer)loginDAO.ResetCheck(id);
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.getSession().setAttribute("mdCheck", mdCheck);
		return "loginOk";
	}
	
	@RequestMapping("naverJoinPro.do")
	public @ResponseBody String naverJoinPro(LoginVO loginVO, HttpServletRequest request) throws Exception {
		loginVO.setReset(0);
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "joinOK"; 
	} 
	
	@RequestMapping("naverIdCheck.do")
	public @ResponseBody String naverIdCheck(@RequestBody String id) throws Exception{
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	
	@RequestMapping("googleLoginPro.do")
	public @ResponseBody String googleLoginPro(String id, HttpServletRequest request) throws Exception{
		int idCheck	= 1;
		int check	= 1;
		int status	= 1;
		int mdCheck	= 0;
		
		request.getSession().setAttribute("id", id);
		mdCheck	= (Integer)loginDAO.ResetCheck(id);
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.getSession().setAttribute("mdCheck", mdCheck);
		return "loginOk";
	}
	
	@RequestMapping("googleJoinPro.do")
	public @ResponseBody String googleJoinPro(LoginVO loginVO, HttpServletRequest request) throws Exception{
		loginVO.setReset(0);
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "joinOK"; 
	}
	
	@RequestMapping("googleIdCheck.do")
	public @ResponseBody String googleIdCheck(@RequestBody String id) throws Exception{
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	
	@RequestMapping("kakaoLoginPro.do")
	public @ResponseBody String kakaoLoginPro(String id, HttpServletRequest request) throws Exception{
		int idCheck	= 1;
		System.out.println("googleLoginPro "+id);
		int check	= 1;
		int status	= 1;
		int mdCheck	= 0;
		
		request.getSession().setAttribute("id", id);
		mdCheck	= (Integer)loginDAO.ResetCheck(id);
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.getSession().setAttribute("mdCheck", mdCheck);
		return "loginOk";
	}
	
	@RequestMapping("kakaoJoinPro.do")
	public @ResponseBody String kakaoJoinPro(LoginVO loginVO, HttpServletRequest request) throws Exception{
		loginVO.setReset(0);
		System.out.println("googleJoinPro "+loginVO.getId());
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "joinOK"; 
	}
	
	@RequestMapping("kakaoIdCheck.do")
	public @ResponseBody String kakaoIdCheck(@RequestBody String id) throws Exception{
		System.out.println("googleIdCheck "+id);
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	
	
	
}
