package org.jesus.meslap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/mission")
public class MissionController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/intro.do")
	public ModelAndView indexView(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mission/intro");
		mav.addObject("overMenu","intro");
		return mav;
	}
	
	@RequestMapping(value="/gallery.do")
	public ModelAndView galleryView(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mission/gallery");
		mav.addObject("overMenu","gallery");
		return mav;
	}
	
}
