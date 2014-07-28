package com.fylaw.vsis.controller;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;

public class YearController extends Controller {
	
	private Logger logger = Logger.getLogger(getClass());
	
	private static String yearContent = null;

	public void index() {
		setAttr("yearContent", this.yearContent);
		
		render("year.html");
	}
	
	public void edit() {
		String yearContent = getPara("yearContent");
		this.yearContent = yearContent;
		logger.debug(yearContent);
	}
}
