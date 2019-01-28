package findEat.action.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.BoardVO;
import findEat.DB.dao.BoardDAOImpl;

@Controller
public class MainAction {

	/***********************************************************************************************************************/
	/*
	 * 	*** FindEat 첫 화면
	 * 
	 *	Main Action class
	 *	- 첫 화면 구성
	 *	- 상단 고정 menu와 클릭 이벤트 modal은 코드분리 후 별도로 로드
	 *
	/***********************************************************************************************************************/
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	//첫 페이지
	@RequestMapping("index.do")
	public String index(HttpServletRequest request) throws Exception {
		return "/main/index";
	}
	
	//상단 고정 메뉴 - 대부분의 페이지에 포함되어 있음
	@RequestMapping("menu.do")
	public String menu(HttpServletRequest request) throws Exception {
		List<BoardVO> noticeList = boardDAO.NoticeList();
		request.setAttribute("noticeList", noticeList);
		return "/menu/menu";
	}
	
	//index 페이지의 클릭 이벤트용 modal 코드 분리
	@RequestMapping("indexModal.do")
	public String indexModal() {
		return "/main/indexModal";
	}
}
