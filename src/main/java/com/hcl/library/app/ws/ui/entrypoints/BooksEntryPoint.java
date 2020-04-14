package com.hcl.library.app.ws.ui.entrypoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> showAllBooks() {
		
		List<Book> listOfBooks = new ImplBookDao().findAll();
		
		return listOfBooks;
	}
	
	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookRestModel findBook(@PathParam("isbn") String isbn) {
		
		Book book = new ImplBookDao().findById(isbn);
		
		BookRestModel restBook = new BookRestModel();
		BeanUtils.copyProperties(book, restBook);
		
		return restBook;
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BookRestModel newBook(CreateBookRequestModel requestBook) {
		
		Author newAuthor = new Author();
		Book newBook = new Book();
		BeanUtils.copyProperties(requestBook, newAuthor);
		BeanUtils.copyProperties(requestBook, newBook);
		newBook.setAuthor(newAuthor);
		
		ImplBookDao bookCrud = new ImplBookDao();
		bookCrud.add(newBook);
		
		BookRestModel restBook = new BookRestModel();
		BeanUtils.copyProperties(requestBook, restBook);
		
		return restBook;
	}
}
