package com.hcl.library.app.ws.service.impl;

import com.hcl.library.app.ws.dto.BookDTO;
import com.hcl.library.app.ws.service.BookService;
import com.hcl.library.app.ws.utils.BookUtils;

public class BookServiceImpl implements BookService {

	@Override
	public BookDTO ceateBook(BookDTO book) {
		
		BookUtils bookUtils = new BookUtils();
		
		BookDTO returnValue = new BookDTO();
		
		//Validate requeried fields
		bookUtils.validateRequiredFields(book);
		
		//Check if book already exist
		
		//Create Entity Object
		
		//Generate ISBN
		
		//Record Data in DB
		
		//Return back the book created
		
		return returnValue;
		
	}

}
