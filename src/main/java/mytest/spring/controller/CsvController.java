package mytest.spring.controller;

import javax.servlet.http.HttpServletResponse;

import mytest.spring.biz.exception.BusinessException;
import mytest.spring.model.Place;
import mytest.spring.service.PlaceService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanWriter;
import org.supercsv.io.dozer.ICsvDozerBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class CsvController {

	private static final String CSV_MIME = "text/csv";

	private static final String CSV_FILE_NAME = "result.csv";
	
	private static final Logger logger = Logger.getLogger(CsvController.class);


	@Autowired
	PlaceService placeService;
	

	@RequestMapping(value = "/csv/{text}", method = RequestMethod.GET)
	public void getFile(@PathVariable("text") String text, HttpServletResponse response) {
		try{
			logger.debug("Getting csv file. Text : " + text);
			
			// prepare response
			response.setContentType(CSV_MIME);
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", CSV_FILE_NAME);
			response.setHeader(headerKey, headerValue);
	
			// using SuperCSV API to generate CSV from model 
			ICsvDozerBeanWriter  csvWriter = new CsvDozerBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			csvWriter.configureBeanMapping(Place.class, Place.FIELDS_MAPPING);
			csvWriter.writeHeader(Place.HEADERS);			
	
			for (Place place : placeService.findPlace(text)) {
				csvWriter.write(place, getCellProcessor(Place.HEADERS.length));
			}
	
			csvWriter.close();
			
			throw new BusinessException("ciao");
			
		}catch(BusinessException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			throw new BusinessException(e);
		}
	}
	
	
	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleCustomException(BusinessException ex) {
		return new ModelAndView("error-tiles");
	}
	
	
	private CellProcessor[] getCellProcessor(int len){		
		CellProcessor[] cellProcessor = new CellProcessor[len];
		for (int i = 0; i < len; i++) {
			cellProcessor[i] = new Optional();
		}
		return cellProcessor;
	}

}
