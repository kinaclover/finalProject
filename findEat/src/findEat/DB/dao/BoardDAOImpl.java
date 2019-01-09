package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession sqlSession	= null;
	private BoardVO boardVO			= null;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void BoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	@Override
	public List<BoardVO> ListUp(int start,int end) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list = sqlSession.selectList("board.normal", map);
		return list;
	}
	
	@Override
	public int TotalNormal() throws Exception {
		int total = sqlSession.selectOne("board.total");
		return total;
	}
	
	@Override
	public List<BoardVO> NoticeList() throws Exception {
		List<BoardVO> list = sqlSession.selectList("board.notice");
		return list;
	}
	
	@Override
	public BoardVO ViewArticle(int idx) throws Exception {
		sqlSession.update("board.countUp",idx);
		boardVO = sqlSession.selectOne("board.select",idx);
		return boardVO;
	}
	
	@Override
	public int PasswordCheck(String idx, String pw) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("pw", pw);
		int check = sqlSession.selectOne("board.pwCheck",map);
		return check;
	}

	@Override
	public int InsertArticle(BoardVO boardVO) throws Exception {
		int check = sqlSession.insert("board.insert",boardVO);
		return check;
	}

	@Override
	public int UpdateArticle(BoardVO boardVO) throws Exception {
		int check	= sqlSession.update("board.update",boardVO);
		return check;
	}

	@Override
	public int DeleteArticle(int idx) throws Exception {
		sqlSession.delete("board.deleteComments",idx);			//comment delete
		int check	= sqlSession.delete("board.delete",idx);
		return check;
	}
	
	//comments action
	@Override
	public List<CommentsVO> CommentsList(int idx) throws Exception {
		List<CommentsVO> list = sqlSession.selectList("board.commentsList",idx);
		return list;
	}
	@Override
	public int InsertComment(CommentsVO commentsVO) throws Exception {
		int check	= sqlSession.insert("board.commentInsert",commentsVO);
		return check;
	}
	@Override
	public int UpdateComment(CommentsVO commentsVO) throws Exception {
		int check	= sqlSession.update("board.commentUpdate",commentsVO);
		return check;
	}
	@Override
	public int DeleteComment(int num) throws Exception {
		int check	= sqlSession.delete("board.commentDelete",num);
		return check;
	}
	
}
