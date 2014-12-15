package org.jesus.meslap.board.dao;

import java.util.List;

import org.jesus.meslap.entity.Board;
import org.jesus.meslap.entity.BoardAdmin;
import org.jesus.meslap.entity.BoardFile;

public interface BoardDAO {
	
	public List<Board> getBoardList(String boardCode, Integer fRow, Integer pageSize);
	public void saveBoard(Board board);
	public Board getBoard(Integer boardId);
	public void deleteBoard(Integer boardId);
	public void saveBoardFile(BoardFile boardFile);
	public Integer getBoardCount(String boardCode);
	
	public List<BoardAdmin> getBoardAdminList();
	public boolean getCheckBoardAdmin(BoardAdmin boardAdmin);
	public void createBoard(BoardAdmin boardAdmin);
	public BoardAdmin getBoardAdmin(String boardCode);
	public List<String> getCategorys();
}
