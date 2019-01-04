package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.BoardVO;

public interface BoardDAO {
	public List<BoardVO> ListUp(int start,int end) throws Exception;
	public List<BoardVO> NoticeList() throws Exception;
	public BoardVO ViewArticle(int idx) throws Exception;
	public int InsertArticle(BoardVO boardVO) throws Exception;
	public int UpdateArticle(BoardVO boardVO) throws Exception;
	public int DeleteArticle(int idx,String pw) throws Exception;
}
