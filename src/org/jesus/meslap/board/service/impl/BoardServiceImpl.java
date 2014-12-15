package org.jesus.meslap.board.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jesus.meslap.board.dao.BoardDAO;
import org.jesus.meslap.board.service.BoardService;
import org.jesus.meslap.entity.Board;
import org.jesus.meslap.entity.BoardAdmin;
import org.jesus.meslap.entity.BoardFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardServiceImpl implements BoardService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardDAO boardDao;
	
	@Transactional(value="transactionManager")
	public List<Board> getBoardList(String boardCode, Integer fRow, Integer pageSize) {
		return boardDao.getBoardList(boardCode, fRow, pageSize);
	}
	
	@Transactional(value="transactionManager")
	public void saveBoard(Board board, String filePath){
		FileOutputStream fos =  null;
		try {
			board.setWdate(new Date());
			MultipartFile logicalFiles = board.getLogicalFiles();
			if(logicalFiles!=null && logicalFiles.getSize()>0){
				log.debug("FileName = "+logicalFiles.getName());
				log.debug("OriginalFileName = "+logicalFiles.getOriginalFilename());
				log.debug("\n");
				board.setFilePath(filePath);
				board.setFileName(logicalFiles.getOriginalFilename());
				
				File f = new File(filePath);
				if(!f.exists())
					f.mkdir();
				logicalFiles.transferTo(new File(filePath+File.separator+logicalFiles.getOriginalFilename()));
			}
			
			boardDao.saveBoard(board);//board 저장 후에 첨부파일 저장 수행해야함.
			
//			MultipartFile[] logicalFiles = board.getLogicalFiles();
//			for(int i=0; i<logicalFiles.length;i++){
//				MultipartFile tempFile = logicalFiles[i];
//				log.debug("FileName = "+tempFile.getName());
//				log.debug("OriginalFileName = "+tempFile.getOriginalFilename());
//				log.debug("\n");
//				Set<BoardFile> files = new HashSet<BoardFile>();
//				BoardFile boardFile = new BoardFile(filePath, tempFile.getOriginalFilename(), board);
//				boardDao.saveBoardFile(boardFile);
//				files.add(boardFile);
//				board.setFiles(files);
//				
//				
//				File f = new File(filePath);
//				if(!f.exists())
//					f.mkdir();
//				tempFile.transferTo(new File(filePath+File.separator+tempFile.getOriginalFilename()));
				
//				byte[] temp = tempFile.getBytes();
//				fos = new FileOutputStream(filePath+File.separator+tempFile.getOriginalFilename());
//				fos.write(temp);
//			}//for
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fos!=null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Transactional(value="transactionManager")
	public void updateBoard(Board board){
		board.setMdate(new Date());
		boardDao.saveBoard(board);
	}

	@Transactional(value="transactionManager")
	public Board getBoard(Integer boardId) {
		return boardDao.getBoard(boardId);
	}

	@Transactional(value="transactionManager")
	public void deleteBoard(Integer boardId) {
		boardDao.deleteBoard(boardId);
	}
	
	@Transactional(value="transactionManager")
	public List<BoardAdmin> getBoardAdminList() {
		return boardDao.getBoardAdminList();
	}

	@Transactional(value="transactionManager")
	public boolean createBoard(BoardAdmin boardAdmin) {
		// TODO Auto-generated method stub
		boolean isExist = boardDao.getCheckBoardAdmin(boardAdmin);
		if(isExist){
			boardAdmin.setErrorMessage("이미 존재하는 boardCode 입니다.");
			return false;
		}
		boardDao.createBoard(boardAdmin);
		return true;
	}
	
	@Transactional(value="transactionManager")
	public BoardAdmin getBoardAdmin(String boardCode) {
		return boardDao.getBoardAdmin(boardCode);
	}

	@Transactional(value="transactionManager")
	public Integer getBoardCount(String boardCode) {
		return boardDao.getBoardCount(boardCode);
	}
	
	@Transactional(value="transactionManager")
	public List<String> getCategorys() {
		return boardDao.getCategorys();
	}

}
