package org.jesus.meslap.board.controller;

import java.util.List;

import org.jesus.meslap.annotation.AdminAuth;
import org.jesus.meslap.board.service.BoardService;
import org.jesus.meslap.entity.BoardAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boardAdmin")
public class BoardAdminController {

private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardService bService;
	
	@AdminAuth
	@RequestMapping("/list")
	public ModelAndView list(){
		log.debug("[BoardAdmin Controller - list] start");
		List<BoardAdmin> boardAdmins = bService.getBoardAdminList();
		ModelAndView mav = new ModelAndView("/boardAdmin/list");
		mav.addObject("boardAdmins", boardAdmins);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(){
		log.debug("[BoardAdmin Controller - create] start");
		return new ModelAndView("/boardAdmin/create");
	}
	
	@AdminAuth
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createLogic(@ModelAttribute("boardAdmin") BoardAdmin boardAdmin){
		log.debug("[BoardAdmin Controller - createLogic] start");
		boolean result = bService.createBoard(boardAdmin);
		if(result){
			return new ModelAndView("redirect:/boardAdmin/view.do", "boardCode", boardAdmin.getBoardCode());
		}
		return new ModelAndView("/boardAdmin/create");
	}
	
	@AdminAuth
	@RequestMapping(value="/view")
	public ModelAndView view(@RequestParam String boardCode){
		log.debug("[BoardAdmin Controller - createLogic] start");
		BoardAdmin boardAdmin = bService.getBoardAdmin(boardCode);
		return new ModelAndView("/boardAdmin/view","boardAdmin",boardAdmin);
	}
}
