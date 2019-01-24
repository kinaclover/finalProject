package findEat.action.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.BoardVO;
import findEat.DB.dao.BoardDAOImpl;

@Controller
public class MainAction {
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	@RequestMapping("index.do")
	public String index(Model model,HttpServletRequest request) throws Exception {
		return "/main/index";
	}
	
	//fixed menu bar
	@RequestMapping("menu.do")
	public String menu(HttpServletRequest request) throws Exception {
		List<BoardVO> noticeList = boardDAO.NoticeList();
		request.setAttribute("noticeList", noticeList);
		return "/menu/menu";
	}
	
	//index modals
	@RequestMapping("indexModal.do")
	public String indexModal() {
		return "/main/indexModal";
	}
}
