package com.hcl.library.app.ws.ui.entrypoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;

import com.hcl.library.app.ws.ui.model.request.CreateBookRequestModel;
import com.hcl.library.app.ws.ui.model.response.BookRestModel;
import com.hcl.library.dao.ImplBookDao;
import com.hcl.library.model.Author;
import com.hcl.library.model.Book;

@Path("/books")
public class BooksEntryPoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BookRestModel createBook(CreateBookRequestModel requestBook) {
		
		Author newAuthor = new Author();
		Book newBook = new Book();
		BeanUtils.copyProperties(requestBook, newAuthor);
		BeanUtils.copyProperties(requestBook, newBook);
		newBook.setAuthor(newAuthor);
		
		ImplBookDao bookCrud = new ImplBookDao();
		bookCrud.add(newBook);
		
		BookRestModel returnValue = new BookRestModel();
		BeanUtils.copyProperties(requestBook, returnValue);
		
		return returnValue;
	}

}
