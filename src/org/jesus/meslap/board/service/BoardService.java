package org.jesus.meslap.board.service;

import java.util.List;

import org.jesus.meslap.entity.Board;
import org.jesus.meslap.entity.BoardAdmin;

public interface BoardService {
	
	
	public List<Board> getBoardList(String boardCode, Integer fRow, Integer pageSize);
	public void saveBoard(Board board, String filePath);
	public void updateBoard(Board board);
	public Board getBoard(Integer boardId);
	public void deleteBoard(Integer boardId);
	public Integer getBoardCount(String boardCode);
	
	public List<BoardAdmin> getBoardAdminList();
	public boolean createBoard(BoardAdmin boardAdmin);
	public BoardAdmin getBoardAdmin(String boardCode);
	public List<String> getCategorys();
	
}
