package com.hcl.library.app.ws.entrypoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

import com.hcl.library.app.ws.dto.BookDTO;
import com.hcl.library.app.ws.model.request.CreateBookRequestModel;
import com.hcl.library.app.ws.model.response.BookRestModel;
import com.hcl.library.app.ws.service.BookService;
import com.hcl.library.app.ws.service.impl.BookServiceImpl;
import com.hcl.library.dao.ImplBookDao;
import com.hcl.library.model.Book;

@Path("/books")
public class BooksEntryPoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAllBooks() {
		
		List<Book> listOfBooks = new ImplBookDao().findAll();
		
		return Response.status(200).entity(listOfBooks).build();
	}
	
	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBook(@PathParam("isbn") String isbn) {
		
		Book book = new ImplBookDao().findById(isbn);
		
		BookRestModel restBook = new BookRestModel();
		BeanUtils.copyProperties(book, restBook);
		
		return Response.status(200).entity(restBook).build();
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newBook(CreateBookRequestModel requestBook) {
		
		BookDTO bookDto = new BookDTO();
		BeanUtils.copyProperties(requestBook, bookDto);
		
		BookService bookService = new BookServiceImpl();
		BookDTO createdBook = bookService.ceateBook(bookDto);
		
		
		return null;
		//return Response.status(200).entity(createdBook).build();
	}
}
