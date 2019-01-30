package findEat.action.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;
import findEat.DB.dao.BoardDAOImpl;

@Controller
public class Board {

	/***********************************************************************************************************************/
	/*
	 * 	*** 게시판
	 * 	
	 * 	Board Action class
	 * 	- 게시글의 작성,수정,삭제 로직 수행 후 status값과 함께 status페이지로 일괄 이동
	 * 	- 댓글 페이지 로드 / 댓글의 작성,수정,삭제 로직 포
	 * 
	 * 	글 관련 각 기능별 status value
	 * 	- insert : 1
	 * 	- update : 2
	 * 	- delete : 3
	/***********************************************************************************************************************/
	
	@Autowired
	private BoardVO boardVO = null;
	
	@Autowired
	private CommentsVO commentsVO = null;
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	//글 목록
	@RequestMapping("list.do")
	public String list(HttpServletRequest request) throws Exception {
		int check		= 0;							//db데이터 여부 확인
		int total		= 0;							//총 일반 글의 수
		int count		= 0;							//현재 페이지에 표시될 글의 수
		int pageNum		= 1;							//현재 페이지
		if(request.getParameter("pageNum")!=null)
			pageNum		= Integer.parseInt(request.getParameter("pageNum"));
		
		int pageSize	= 7;							//한 페이지에 표시될 최대 글 수
		int start		= (pageNum-1) * pageSize + 1;	//현재 페이지 값을 이용하여 시작 글 지정
		int end			= pageNum * pageSize;			//현재 페이지 값을 이용하여 마지막 글 지정
		int startPage	= 0;							//페이지 목록 시작
		int endPage		= 0;							//페이지 목록 끝
		int endNum		= 0;							//페이지 목록 끝 값 계산참조 변수
		
		List<BoardVO> normalList = boardDAO.ListUp(start,end);		//일반 글 목록
		List<BoardVO> noticeList = boardDAO.NoticeList();			//공지사항 목록
		total	= boardDAO.TotalNormal();							//전체 일반 글 수
		//페이지 값 계산
		if(total!=0) {
			check	= 1;
			count	= total - ((pageNum-1) * pageSize);
			//set startPage
			startPage = (((pageNum-1)/pageSize)*pageSize)+1;
			//set endPage
			endNum = ((total-1)/pageSize)+ 1;
			if((endNum-startPage) >= 10) endPage = startPage + 9;
			else endPage = endNum;
		}
		
		request.setAttribute("normalList", normalList);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("check", check);
		request.setAttribute("total", total);
		request.setAttribute("count", count);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("endNum", endNum);
		request.setAttribute("pageNum", pageNum);
		return "/board/list";
	}
	
	//글 작성 페이지 로드
	@RequestMapping("insert.do")
	public String insert() {
		return "/board/insert";
	}
	//글 작성 로직
	@RequestMapping("insertPro.do")
	public String insertPro(BoardVO boardVO, HttpServletRequest request) throws Exception {
		int check	= boardDAO.InsertArticle(boardVO);
		int status	= 1;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/board/status";
	}
	//글 조회 페이지 - 
	@RequestMapping("article.do")
	public String article(HttpServletRequest request) throws Exception {
		int idx	= Integer.parseInt(request.getParameter("idx"));
		boardVO	= boardDAO.ViewArticle(idx);
		String contents	= boardVO.getContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br/>");
		request.setAttribute("contents",contents);
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("idx", idx);
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		return "/board/article";
	}
	//글 수정 비밀번호 조회 - ajax
	@ResponseBody
	@RequestMapping("articleCheck.do")
	public String articleCheck(@RequestBody Map<String,String> data) throws Exception{
		String idx	= data.get("idx");
		String pw	= data.get("pw");
		int check = boardDAO.PasswordCheck(idx, pw);
		return String.valueOf(check);
	}
	//글 수정 로직
	@RequestMapping("boardModifyPro.do")
	public String modifyPro(BoardVO boardVO, HttpServletRequest request) throws Exception{
		int check	= boardDAO.UpdateArticle(boardVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.setAttribute("idx", boardVO.getIdx());
		return "/board/status";
	}
	//글 삭제 로직
	@RequestMapping("deleteArticle.do")
	public String deleteArticle(int idx, HttpServletRequest request) throws Exception {
		int check	= boardDAO.DeleteArticle(idx);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/board/status";
	}
	//댓글 페이지 로드 - 글 조회 페이지에 include 되어있음
	@RequestMapping("comments.do")
	public String comments(int idx, HttpServletRequest request) throws Exception {
		List<CommentsVO> list = boardDAO.CommentsList(idx);
		request.setAttribute("commentsList", list);
		return "/board/comment";
	}
	//댓글 입력 로직 - ajax
	@ResponseBody
	@RequestMapping("insertComm.do")
	public String insertComm(@RequestBody CommentsVO commentsVO) throws Exception {
		int check = boardDAO.InsertComment(commentsVO);
		boardDAO.UpdateCommentsCount(commentsVO.getIdx());
		return String.valueOf(check);
	}
	//댓글 수정 로직 - ajax
	@ResponseBody
	@RequestMapping("modifyComm.do")
	public String modifyComm(@RequestBody Map<String,String> data) throws Exception {
		commentsVO.setContent(data.get("comm"));
		commentsVO.setNum(Integer.parseInt(data.get("num")));
		int check	= boardDAO.UpdateComment(commentsVO);
		return String.valueOf(check);
	}
	//댓글 삭제 로직 - ajax
	@ResponseBody
	@RequestMapping("deleteComm.do")
	public String deleteComm(@RequestBody Map<String,String> data) throws Exception {
		int num		= Integer.parseInt(data.get("num"));
		int idx		= Integer.parseInt(data.get("idx"));
		int check	= boardDAO.DeleteComment(num);
		boardDAO.DeleteCommentsCount(idx);
		return String.valueOf(check);
	}
}
