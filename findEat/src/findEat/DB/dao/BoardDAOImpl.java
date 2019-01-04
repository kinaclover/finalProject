package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import findEat.DB.bean.BoardVO;

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
	public List<BoardVO> NoticeList() throws Exception {
		List<BoardVO> list = sqlSession.selectList("board.notice");
		return list;
	}
	
	@Override
	public BoardVO ViewArticle(int idx) throws Exception {
		boardVO = sqlSession.selectOne("board.select",idx);
		return boardVO;
	}

	@Override
	public int InsertArticle(BoardVO boardVO) throws Exception {
		int check = sqlSession.insert("board.insert",boardVO);
		return check;
	}

	@Override
	public int UpdateArticle(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteArticle(int idx, String pw) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
