package org.jesus.meslap.board.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jesus.meslap.annotation.AdminAuth;
import org.jesus.meslap.board.service.BoardService;
import org.jesus.meslap.entity.Board;
import org.jesus.meslap.util.MeslapUtils;
import org.jesus.meslap.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService bService;
	@Autowired
	private MeslapUtils meslapUtils;
	@Autowired
	private PagingUtil pUtil;
	@Autowired
	private HttpServletRequest request;
	
	private static final Integer BOARD_PAGE_SIZE = 10;
	
	private ModelAndView getDefaultMav(String viewName, String boardCode){
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("boardCode",boardCode);
		return mav;
	}
	
	@RequestMapping("/{boardCode}/list")
	public ModelAndView list(@PathVariable String boardCode, @RequestParam(required=false) Integer cPage){
		log.debug("[Board Controller - list] start");
		log.debug("	boardCode = "+boardCode);
		
		Integer total = bService.getBoardCount(boardCode);
		Map pMap = pUtil.getCurrentPaging(BOARD_PAGE_SIZE, total, cPage);
		
		List<Board> boards = bService.getBoardList(boardCode, (Integer)pMap.get("fRow"), BOARD_PAGE_SIZE);
		ModelAndView mav = getDefaultMav("board/"+boardCode+"/list", boardCode);
		mav.addObject("boards", boards);
		mav.addObject("pMap",pMap);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/{boardCode}/admin/write",method=RequestMethod.GET)
	public ModelAndView write(@PathVariable String boardCode){
		log.debug("[Board Controller - write(GET)] start");
		log.debug("	boardCode = "+boardCode);
		return getDefaultMav("board/write", boardCode);
	}
	@AdminAuth
	@RequestMapping(value="/{boardCode}/admin/write",method=RequestMethod.POST)
	public ModelAndView writeLogic(@ModelAttribute("board") Board board){
		log.debug("[Board Controller - write(POST)] start");
		log.debug("	board = "+board);
		
		String path = meslapUtils.getPath(request, Board.BOARD_FOLDER);
		log.debug("	path = "+path);
		bService.saveBoard(board, path);
		//return getDefaultMav("redirect:/board/"+board.getBoardCode()+"/list.do", board.getBoardCode());
		return getDefaultMav("redirect:/board/"+board.getBoardCode()+"/list.do", board.getBoardCode());
	}
	
	@AdminAuth
	@RequestMapping(value="/{boardCode}/{boardId}/admin/update",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable String boardCode, @PathVariable Integer boardId){
		log.debug("[Board Controller - update(GET)] start");
		log.debug("	boardCode = "+boardCode);
		log.debug("	boardId = "+boardId);
		Board board = bService.getBoard(boardId);
		ModelAndView mav = getDefaultMav("board/update", boardCode);
		mav.addObject("board",board);
		return mav; 
	}
	
	@AdminAuth
	@RequestMapping(value="/{boardCode}/{boardId}/admin/update",method=RequestMethod.POST)
	public ModelAndView updateLogic(@ModelAttribute("board") Board board){
		log.debug("[Board Controller - update(POST)] start");
		log.debug("	board = "+board);
		bService.updateBoard(board);
		ModelAndView mav = getDefaultMav("redirect:/board/"+board.getBoardCode()+"/"+board.getId()+"/view.do", board.getBoardCode());
		//ModelAndView mav = getDefaultMav("redirect:/board/"+board.getBoardAdmin().getBoardCode()+"/"+board.getId()+"/view.do", board.getBoardAdmin().getBoardCode());
		return mav;
	}
	
	@RequestMapping("/{boardCode}/{boardId}/view")
	public ModelAndView view(@PathVariable String boardCode, @PathVariable Integer boardId){
		log.debug("[Board Controller - view] start");
		log.debug("	boardCode = "+boardCode);
		log.debug("	boardId = "+boardId);
		Board viewBoard = bService.getBoard(boardId);
		ModelAndView mav = getDefaultMav("board/view", boardCode);
		mav.addObject("board",viewBoard);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping("/{boardCode}/{boardId}/admin/delete")
	public ModelAndView delete(@PathVariable String boardCode, @PathVariable Integer boardId){
		log.debug("[Board Controller - delete] start");
		log.debug("	boardCode = "+boardCode);
		log.debug("	boardId = "+boardId);
		bService.deleteBoard(boardId);
		
		return getDefaultMav("redirect:/board/"+boardCode+"/list.do", boardCode);
	}
	
	@RequestMapping("/{boardCode}/{boardId}/download")
	public ModelAndView download(@PathVariable String boardCode, @PathVariable Integer boardId, @RequestParam String filePath, @RequestParam String fileName){
		log.debug("[Board Controller - download] start");
		log.debug("	boardCode = "+boardCode);
		log.debug("	boardId = "+boardId);
		log.debug("	filePath = "+filePath);
		log.debug("	fileName = "+fileName);
		
		File downFile = new File(filePath+File.separator+fileName);
		ModelAndView mav = getDefaultMav("download", boardCode);
		mav.addObject("downloadFile", downFile);
		return mav;
	}
}
