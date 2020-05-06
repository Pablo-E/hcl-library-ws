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

import com.hcl.library.app.ws.model.request.CreateBookRequestModel;
import com.hcl.library.app.ws.model.response.BookRestModel;
import com.hcl.library.app.ws.model.response.UserRestModel;
import com.hcl.library.dao.ImplBookDao;
import com.hcl.library.dao.ImplUserDao;
import com.hcl.library.model.Author;
import com.hcl.library.model.Book;
import com.hcl.library.model.User;

@Path("/clients")
public class UserEntryPoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response showAllClients() {

		String listOfUsers = new ImplUserDao().findAllClients().toString();

		return Response.status(200).entity(listOfUsers).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUser(@PathParam("id") int id) {

		User user = new ImplUserDao().findById(id);

		UserRestModel restUser = new UserRestModel();
		BeanUtils.copyProperties(user, restUser);

		return Response.status(200).entity(restUser).build();
	}

	@POST

	@Path("/new")

	@Consumes(MediaType.APPLICATION_JSON)

	@Produces(MediaType.APPLICATION_JSON)
	public Response newBook(CreateBookRequestModel requestBook) {

		Author newAuthor = new Author();
		Book newBook = new Book();
		BeanUtils.copyProperties(requestBook, newAuthor);
		BeanUtils.copyProperties(requestBook, newBook);
		newBook.setAuthor(newAuthor);

		ImplBookDao bookCrud = new ImplBookDao();
		bookCrud.add(newBook);

		BookRestModel restBook = new BookRestModel();
		BeanUtils.copyProperties(requestBook, restBook);

		return Response.status(200).entity(restBook).build();
	}

}
