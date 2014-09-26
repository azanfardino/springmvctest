package mytest.spring.controller;

import javax.validation.Valid;

import mytest.spring.biz.exception.BusinessException;
import mytest.spring.model.SearchForm;
import mytest.spring.service.PlaceService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlaceSearchController {

	
	@Autowired
	PlaceService placeService;
	
	private static final Logger logger = Logger.getLogger(PlaceSearchController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("searchForm", new SearchForm());
		return "home-tiles";
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public ModelAndView find(@Valid SearchForm searchForm,
			BindingResult result, Model m) {
		
		
		String text = processText(searchForm.getTextToSearch());
		
		logger.debug("Searching for : " + text);

		ModelAndView modelAndView = null;

		try {
			modelAndView = new ModelAndView("result-tiles");
			modelAndView.addObject("text", text);
			modelAndView.addObject("placeList", placeService.findPlace(text));

		} catch (BusinessException e) {
			modelAndView = new ModelAndView("error-tiles");
		}

		return modelAndView;
	}

	
	private String processText(String textToSearch) {
		return textToSearch.replaceAll("\\s", "").replaceAll("\\W", "");
	}
	
	
	

}
