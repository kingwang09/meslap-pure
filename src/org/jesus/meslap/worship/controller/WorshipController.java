package org.jesus.meslap.worship.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jesus.meslap.annotation.AdminAuth;
import org.jesus.meslap.entity.Worship;
import org.jesus.meslap.util.MeslapUtils;
import org.jesus.meslap.util.PagingUtil;
import org.jesus.meslap.worship.service.WorshipService;
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
@RequestMapping(value="/worship")
public class WorshipController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public static final Integer WORSHIP_PAGE_SIZE = 5;
	
	@Autowired
	private WorshipService wService;
	@Autowired
	private MeslapUtils meslapUtils;
	@Autowired
	private PagingUtil pUtil;
	
	
	@AdminAuth
	@RequestMapping(value="/admin/list.do", method=RequestMethod.GET)
	public ModelAndView adminList(HttpServletRequest req,HttpServletResponse resp, @RequestParam(required=false) Integer cPage){
		ModelAndView mav = new ModelAndView();
		
		Integer total = wService.getWorshipCount();
		Map pMap = pUtil.getCurrentPaging(WORSHIP_PAGE_SIZE, total, cPage);
		
		List<Worship> worships = wService.getWorships((Integer)pMap.get("fRow"), WORSHIP_PAGE_SIZE);
		mav.addObject("worships",worships);
		mav.addObject("pMap",pMap);
		mav.setViewName("/worship/list");
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/write.do", method=RequestMethod.GET)
	public ModelAndView adminWrite(HttpServletRequest req,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		List<String> categorys = wService.getCateogrys();
		mav.setViewName("/worship/write");
		mav.addObject("categorys", categorys);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/write.do", method=RequestMethod.POST)
	public ModelAndView adminWriteLogic(HttpServletRequest request, @ModelAttribute("worship") Worship worship){
		String path = meslapUtils.getPath(request, Worship.WORSHIP_FOLDER);
		wService.write(path, worship);
		return new ModelAndView("redirect:/worship/admin/list.do");
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/update.do", method=RequestMethod.GET)
	public ModelAndView adminUpdate(HttpServletRequest req,HttpServletResponse resp, @RequestParam Integer id){
		ModelAndView mav = new ModelAndView();
		Worship worship = wService.getWorship(id);
		List<String> categorys = wService.getCateogrys();
		mav.setViewName("/worship/update");
		mav.addObject("worship",worship);
		mav.addObject("categorys", categorys);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/update.do", method=RequestMethod.POST)
	public ModelAndView adminUpdateLogic(HttpServletRequest request, @ModelAttribute("worship") Worship worship){
		String path = meslapUtils.getPath(request, Worship.WORSHIP_FOLDER);
		wService.update(path, worship);
		return new ModelAndView("redirect:/worship/admin/list.do");
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/delete.do", method=RequestMethod.GET)
	public ModelAndView adminDelete(HttpServletRequest req,HttpServletResponse resp, @RequestParam Integer id){
		String path = meslapUtils.getPath(req, Worship.WORSHIP_FOLDER);
		wService.delete(path, id);
		return new ModelAndView("redirect:/worship/admin/list.do");
	}
	
	
	
	@RequestMapping("/download.do")
	public ModelAndView download(HttpServletRequest request, @RequestParam String fileName){
		String path = meslapUtils.getPath(request, Worship.WORSHIP_FOLDER);
		
		File downFile = new File(path+File.separator+fileName);
		ModelAndView mav = new ModelAndView("download");
		mav.addObject("downloadFile", downFile);
		return mav;
	}
	
	@RequestMapping(value="/view.do", method=RequestMethod.GET)
	public ModelAndView view(HttpServletRequest req,HttpServletResponse resp, @RequestParam(required=false) Integer id, @RequestParam(required=false) Integer cPage){
		ModelAndView mav = new ModelAndView();
		Integer recentWorshipId = wService.getRecentWorshipId(); 
		if(id==null)
			id = recentWorshipId;
		
		if(id!=null){
			Worship worship = wService.getWorship(id);
			mav.addObject("worship", worship);
		}
		
		Integer total = wService.getWorshipCount();
		Map pMap = pUtil.getCurrentPaging(WORSHIP_PAGE_SIZE, total, cPage);
		
		List<Worship> worships = wService.getWorships((Integer)pMap.get("fRow"), WORSHIP_PAGE_SIZE);
		List<String> categorys = wService.getCateogrys();
		mav.addObject("worships", worships);
		mav.addObject("pMap", pMap);
		mav.addObject("categorys", categorys);
		
		//mav.setViewName("/worship/view");
		mav.setViewName("/worship/font/view");
		mav.addObject("recentWorshipId", recentWorshipId);
		mav.addObject("cPage", cPage);
		return mav;
	}
	
	@RequestMapping(value="/insideView.do", method=RequestMethod.GET)
	public ModelAndView insideView(HttpServletRequest req,HttpServletResponse resp, @RequestParam(required=false) Integer cPage){
		ModelAndView mav = new ModelAndView();
		
		Integer total = wService.getWorshipCount();
		Map pMap = pUtil.getCurrentPaging(WORSHIP_PAGE_SIZE, total, cPage);
		
		List<Worship> worships = wService.getWorships((Integer)pMap.get("fRow"), WORSHIP_PAGE_SIZE);
		List<String> categorys = wService.getCateogrys();
		mav.setViewName("/worship/insideView");
		mav.addObject("worships", worships);
		mav.addObject("pMap", pMap);
		mav.addObject("categorys", categorys);
		return mav;
	}
	
	@AdminAuth
	@RequestMapping(value="/admin/import.do", method=RequestMethod.GET)
	public ModelAndView importWorships(HttpServletRequest request,HttpServletResponse resp){
		ModelAndView mav = new ModelAndView();
		String path = meslapUtils.getPath(request, Worship.WORSHIP_IMPORT_FOLDER);
		wService.importExcelToDB(path, "worships.xls");
		mav.setViewName("redirect:/worship/admin/list.do");
		return mav;
	}
}
