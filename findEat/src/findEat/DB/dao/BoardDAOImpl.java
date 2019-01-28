package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;

public class BoardDAOImpl implements BoardDAO {
	
	/*
	 *	Board DAO 구현 클래스
	 *	- BoardDAO.java 인터페이스 구현
	 *	- 글/댓글 관련 DB호출 클래스
	 */
	
	private SqlSession sqlSession	= null;
	private BoardVO boardVO			= null;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void BoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	/*
	 *	Board action 
	 */
	
	//현재 페이지의 글 호출
	//컨트롤러에서 해당 페이지의 시작,끝 값을 계산 후 넘겨줌
	@Override
	public List<BoardVO> ListUp(int start,int end) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list = sqlSession.selectList("board.normal", map);
		return list;
	}
	
	//일반 글 전체 수 호출
	@Override
	public int TotalNormal() throws Exception {
		int total = sqlSession.selectOne("board.total");
		return total;
	}
	
	//전체 공지사항 호출
	@Override
	public List<BoardVO> NoticeList() throws Exception {
		List<BoardVO> list = sqlSession.selectList("board.notice");
		return list;
	}
	
	//선택한 글 보기
	@Override
	public BoardVO ViewArticle(int idx) throws Exception {
		sqlSession.update("board.countUp",idx);
		boardVO = sqlSession.selectOne("board.select",idx);
		return boardVO;
	}
	
	//수정 전 비밀번호 확인
	@Override
	public int PasswordCheck(String idx, String pw) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("idx", idx);
		map.put("pw", pw);
		int check = sqlSession.selectOne("board.pwCheck",map);
		return check;
	}

	//DB에 글 입력
	@Override
	public int InsertArticle(BoardVO boardVO) throws Exception {
		int check = sqlSession.insert("board.insert",boardVO);
		return check;
	}

	//글 수정
	@Override
	public int UpdateArticle(BoardVO boardVO) throws Exception {
		int check	= sqlSession.update("board.update",boardVO);
		return check;
	}

	//글 삭제
	@Override
	public int DeleteArticle(int idx) throws Exception {
		sqlSession.delete("board.deleteComments",idx);			//comment delete
		int check	= sqlSession.delete("board.delete",idx);
		return check;
	}
	
	/*
	 *	Comments action
	 */
	
	//해당 글의 모든 댓글 호출
	@Override
	public List<CommentsVO> CommentsList(int idx) throws Exception {
		List<CommentsVO> list = sqlSession.selectList("board.commentsList",idx);
		return list;
	}
	//DB에 댓글 입력
	@Override
	public int InsertComment(CommentsVO commentsVO) throws Exception {
		int check	= sqlSession.insert("board.commentInsert",commentsVO);
		return check;
	}
	//댓글 수정
	@Override
	public int UpdateComment(CommentsVO commentsVO) throws Exception {
		int check	= sqlSession.update("board.commentUpdate",commentsVO);
		return check;
	}
	//댓글 삭제
	@Override
	public int DeleteComment(int num) throws Exception {
		int check	= sqlSession.delete("board.commentDelete",num);
		return check;
	}
	//해당 글의 댓글 수 증가
	@Override
	public void UpdateCommentsCount(int idx) throws Exception {
		sqlSession.update("board.articleCommentUp",idx);
	}
	//해당 글의 댓글 수 감소
	@Override
	public void DeleteCommentsCount(int idx) throws Exception {
		sqlSession.update("board.articleCommentDown",idx);
	}
	
}
