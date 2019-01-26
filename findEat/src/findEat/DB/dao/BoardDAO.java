package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CommentsVO;

public interface BoardDAO {
	/*
	 * 	Board DAO
	 * 	- 글/댓글 관련 DB호출 메서드
	 */
	
	//board action
	public List<BoardVO> ListUp(int start,int end) throws Exception;		//현재 페이지의 글 호출
	public int TotalNormal() throws Exception;								//일반 글 전체 수 호출
	public List<BoardVO> NoticeList() throws Exception;						//전체 공지사항 호출
	public BoardVO ViewArticle(int idx) throws Exception;					//선택한 글 보기
	public int PasswordCheck(String idx, String pw) throws Exception;		//수정 전 비밀번호 확인
	public int InsertArticle(BoardVO boardVO) throws Exception;				//DB에 글 입력
	public int UpdateArticle(BoardVO boardVO) throws Exception;				//글 수정
	public int DeleteArticle(int idx) throws Exception;						//글 삭제
	//comments action
	public List<CommentsVO> CommentsList(int idx) throws Exception;			//해당 글의 모든 댓글 호출
	public int InsertComment(CommentsVO commentsVO) throws Exception;		//DB에 댓글 입력
	public void UpdateCommentsCount(int idx) throws Exception;				//해당 글의 댓글 수 증가
	public int UpdateComment(CommentsVO commentsVO) throws Exception;		//댓글 수정
	public int DeleteComment(int num) throws Exception;						//댓글 삭제
	public void DeleteCommentsCount(int idx) throws Exception;				//해당 글의 댓글 수 감소
}
