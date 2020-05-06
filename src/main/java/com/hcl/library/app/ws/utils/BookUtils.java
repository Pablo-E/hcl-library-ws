package com.hcl.library.app.ws.utils;

import com.hcl.library.app.ws.dto.BookDTO;
import com.hcl.library.app.ws.exceptions.MissingRequiredFieldException;
import com.hcl.library.app.ws.model.response.ErrorMessages;

public class BookUtils {

	public void validateRequiredFields (BookDTO bookDto) throws MissingRequiredFieldException {
		
		if (bookDto.getIsbn() == null ||
				bookDto.getIsbn().isEmpty() ||
				bookDto.getTitle() == null ||
				bookDto.getTitle().isEmpty() ||
				bookDto.getPages() == 0 ||
				bookDto.getPublisher() == null ||
				bookDto.getPublisher().isEmpty() ||
				bookDto.getGenre() == null ||
				bookDto.getGenre().isEmpty() ||
				bookDto.getNameAuthor() == null ||
				bookDto.getNameAuthor().isEmpty() ||
				bookDto.getLastNameAuthor() == null ||
				bookDto.getLastNameAuthor().isEmpty() ||
				bookDto.getNationality() == null ||
				bookDto.getNationality().isEmpty()
				) {
			throw new MissingRequiredFieldException (
					ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
				}
	}
}
