package findEat.action.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Board {
	
	@RequestMapping("list.do")
	public String list() throws Exception {
		
		return "/board/list";
	}
}
