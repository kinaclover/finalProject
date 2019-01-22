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
	
	/*
	 *	login 'status'
	 *	1 == login
	 *	2 == update
	 *	3 == join
	 *	4 == delete 
	 *	5 == findPassword
	 */
	
	@Autowired
	private LoginDAOImpl loginDAO = null;
	
	@Autowired
	private LoginVO loginVO = null;

	@RequestMapping("login.do")
	public String login(HttpServletRequest request) {
		String cont	= request.getContextPath();
		String path	= request.getHeader("referer");
		path	= path.substring(path.indexOf(cont));	//직전 페이지 주소
		request.getSession().setAttribute("path", path);
	
		return "/login/login";
	}
	
	@RequestMapping("loginPro.do")
	public String loginPro(String id, String pw, HttpServletRequest request) throws Exception {
		int idCheck	= (Integer)loginDAO.IdCheck(id);					//check id
		int check	= 0;
		int status	= 1;
		int mdCheck	= 0;
		
		if(idCheck==1) check = (Integer)loginDAO.LoginPro(id, pw);		//check password
		if(check==1) {
			request.getSession().setAttribute("id", id);				//if correct
			mdCheck	= (Integer)loginDAO.ResetCheck(id);
		}
		
		request.setAttribute("idCheck", idCheck);
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.getSession().setAttribute("mdCheck", mdCheck);
		return "/login/status";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:index.do";
	}
	@RequestMapping("join.do")
	public String join(@ModelAttribute("loginVO") LoginVO loginVO) {
		return "/login/join";
	}
	
	@ResponseBody
	@RequestMapping("idCheck.do")
	public String idCheck(@RequestBody String id) throws Exception{
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	
	@RequestMapping("joinPro.do")
	public String joinPro(LoginVO loginVO, HttpServletRequest request) throws Exception {
		loginVO.setReset(0);
		System.out.println(loginVO.getId());
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}
	
	@RequestMapping("modify.do")
	public String modify(HttpServletRequest request) throws Exception {
		String id	= (String)request.getSession().getAttribute("id");
		loginVO		= loginDAO.SelectPro(id);
		request.setAttribute("loginVO", loginVO);
		return "/login/modify";
	}
	
	@RequestMapping("modifyPro.do")
	public String modifyPro(LoginVO loginVO, HttpServletRequest request) throws Exception {
		int mdCheck	= (Integer)request.getSession().getAttribute("mdCheck");
		if(mdCheck==1) {
			loginVO.setReset(0);
			request.getSession().removeAttribute("mdCheck");
		}
		int check	= (Integer)loginDAO.UpdatePro(loginVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}

	@RequestMapping("delete.do")
	public String delete() {
		return "/login/delete";
	}
	
	@RequestMapping("deletePro.do")
	public String deletePro(String pw, HttpServletRequest request) throws Exception {
		String id	= (String)request.getSession().getAttribute("id");
		int check	= (Integer)loginDAO.DeletePro(id, pw);
		int temp	= 0;
		/*	calendar database delete	*/
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
		if(check>=2) request.getSession().invalidate();
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/login/status";
	}
	
	@RequestMapping("findPassword.do")
	public String findPassword() {
		return "/login/findPw";
	}
	
	@ResponseBody
	@RequestMapping("emailCheck.do")
	public String emailCheck(@RequestParam(value="id")String id,@RequestParam(value="email")String email) throws Exception {
		int check		= loginDAO.EmailCheck(id, email);
		return String.valueOf(check);
	}
	
	@RequestMapping("findPasswordPro.do")
	public String findPwPro(String id, String email, HttpServletRequest request) throws Exception{
		String pw			= "";
		Random rd = new Random();
		for(int i=0;i<8;i++) {
			pw += rd.nextInt(10);
		}
		loginVO.setId(id);
		loginVO.setEmail(email);
		loginVO.setPw(pw);
		loginVO.setReset(1);
		int status	= 5;
		int check	= loginDAO.UpdatePro(loginVO);
		if(check==1) {
			try {
				final String hostId		= "gihd3project@gmail.com";
				final String hostPw		= "success100";
				String host				= "smtp.gmail.com";
				String subject			= "FindEat 비밀번호 전송 메일입니다.";
				String msg				= "<!DOCTYPE html>\n" + 
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
				
				mm.setFrom(new InternetAddress("FindEat"));
				mm.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mm.setSubject(subject);
				mm.setText(msg);
				mm.setHeader("content-Type", "text/html");
				javax.mail.Transport.send(mm);
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
		System.out.println("naverLoginPro "+id);
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
		System.out.println("naverJoinPro "+loginVO.getId());
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "joinOK"; 
	} 
	
	@RequestMapping("naverIdCheck.do")
	public @ResponseBody String naverIdCheck(@RequestBody String id) throws Exception{
		System.out.println("naverIdCheck "+id);
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	@RequestMapping("googleLoginPro.do")
	public String googleLoginPro(String id, HttpServletRequest request) throws Exception{
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
	
	@RequestMapping("googleJoinPro.do")
	public String googleJoinPro(LoginVO loginVO, HttpServletRequest request) throws Exception{
		loginVO.setReset(0);
		System.out.println("googleJoinPro "+loginVO.getId());
		int check	= (Integer)loginDAO.JoinPro(loginVO);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "joinOK"; 
	}
	@RequestMapping("googleIdCheck.do")
	public @ResponseBody String googleIdCheck(@RequestBody String id) throws Exception{
		System.out.println("googleIdCheck "+id);
		int count = (Integer)loginDAO.IdCheck(id);
		return String.valueOf(count);
	}
	
}
