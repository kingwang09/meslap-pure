package org.jesus.meslap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jesus.meslap.entity.Worship;
import org.jesus.meslap.worship.service.WorshipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	WorshipService wService;
	
	@RequestMapping(value="/index.do")
	public ModelAndView indexView(HttpServletRequest req,HttpServletResponse resp){
		log.debug("MainController - Main Method!!");
		ModelAndView mav = new ModelAndView();
		Integer recentWorshipId = wService.getRecentWorshipId();
		if(recentWorshipId!=null){
			Worship worship = wService.getWorship(recentWorshipId);
			mav.addObject("recentWorship", worship);
		}
		mav.setViewName("/main");
		return mav;
	}
	
	@RequestMapping(value="/news.do")
	public ModelAndView newsView(HttpServletRequest req,HttpServletResponse resp){
		log.debug("MainController - news Method!!");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/news");
		return mav;
	}
}
