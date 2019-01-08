package findEat.action.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;
import findEat.DB.dao.BoardDAOImpl;

@Controller
public class Board {
	
	@Autowired
	private BoardVO boardVO = null;
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	/*
	 * 	status value
	 * 	- insert : 1
	 * 	- update : 2
	 * 	- delete : 3
	 */
	
	@RequestMapping("list.do")
	public String list(HttpServletRequest request) throws Exception {
		int check		= 0;							//db데이터 여부 확인
		int total		= 0;							//총 일반 글의 수
		int count		= 0;							//현재 페이지에 표시될 글의 수
		int pageNum		= 1;							//현재 페이지
		if(request.getParameter("pageNum")!=null)
			pageNum		= Integer.parseInt(request.getParameter("pageNum"));
		
		int pageSize	= 10;							//한 페이지에 표시될 최대 글 수
		int start		= (pageNum-1) * pageSize + 1;
		int end			= pageNum * pageSize;
		int startPage	= 0;
		int endPage		= 0;
		int endNum		= 0;
		
		List<BoardVO> normalList = boardDAO.ListUp(start,end);
		List<BoardVO> noticeList = boardDAO.NoticeList();
		total	= normalList.size();
		if(total!=0) {
			check	= 1;
			count	= total - ((pageNum-1) * pageSize);
			//set startPage
			startPage = (((pageNum-1)/10)*10)+1;
			//set endPage
			endNum = ((total-1)/10)+ 1;
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
		return "/board/list";
	}
	
	@RequestMapping("insert.do")
	public String insert() {
		return "/board/insert";
	}
	
	@RequestMapping("insertPro.do")
	public String insertPro(BoardVO boardVO, HttpServletRequest request) throws Exception {
		int check	= boardDAO.InsertArticle(boardVO);
		int status	= 1;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/board/status";
	}
	
	@RequestMapping("article.do")
	public String article(HttpServletRequest request) throws Exception {
		int idx	= Integer.parseInt(request.getParameter("idx"));
		boardVO	= boardDAO.ViewArticle(idx);
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("idx", idx);
		return "/board/article";
	}
	
	@ResponseBody
	@RequestMapping("articleCheck.do")
	public String articleCheck(@RequestBody Map<String,String> data) throws Exception{
		String idx	= data.get("idx");
		String pw	= data.get("pw");
		int check = boardDAO.PasswordCheck(idx, pw);
		return String.valueOf(check);
	}
	
	@RequestMapping("boardModifyPro.do")
	public String modifyPro(BoardVO boardVO, HttpServletRequest request) throws Exception{
		int check	= boardDAO.UpdateArticle(boardVO);
		int status	= 2;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		request.setAttribute("idx", boardVO.getIdx());
		return "/board/status";
	}
	
	@RequestMapping("deleteArticle.do")
	public String deleteArticle(int idx, HttpServletRequest request) throws Exception {
		int check	= boardDAO.DeleteArticle(idx);
		int status	= 3;
		request.setAttribute("check", check);
		request.setAttribute("status", status);
		return "/board/status";
	}
	
	@RequestMapping("comments.do")
	public String comments(int idx, HttpServletRequest request) throws Exception {
		List<CommentsVO> list = boardDAO.CommentsList(idx);
		request.setAttribute("commentsList", list);
		return "/board/comment";
	}
	
	@ResponseBody
	@RequestMapping("insertComm.do")
	public String insertComm(@RequestBody CommentsVO commentsVO) throws Exception {
		int check = boardDAO.InsertComment(commentsVO);
		return String.valueOf(check);
	}
	
	@ResponseBody
	@RequestMapping("deleteComm.do")
	public String deleteComm(@RequestBody int num) throws Exception {
		int check	= boardDAO.DeleteComment(num);
		return String.valueOf(check);
	}
}
