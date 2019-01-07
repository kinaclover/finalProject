package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;

public interface BoardDAO {
	public List<BoardVO> ListUp(int start,int end) throws Exception;
	public List<BoardVO> NoticeList() throws Exception;
	public BoardVO ViewArticle(int idx) throws Exception;
	public int PasswordCheck(String idx, String pw) throws Exception;
	public int InsertArticle(BoardVO boardVO) throws Exception;
	public int UpdateArticle(BoardVO boardVO) throws Exception;
	public int DeleteArticle(int idx,String pw) throws Exception;
	//comments action
	public List<CommentsVO> CommentsList(int idx) throws Exception;
	public int InsertComment(CommentsVO commentsVO) throws Exception;
	public int UpdateComment(CommentsVO commentsVO) throws Exception;
	public int DeleteComment(CommentsVO commentsVO) throws Exception;
}
