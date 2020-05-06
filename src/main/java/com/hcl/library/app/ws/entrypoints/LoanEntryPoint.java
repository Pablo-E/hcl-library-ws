package com.hcl.library.app.ws.entrypoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.library.app.ws.model.request.CreateLoanRequestModel;
import com.hcl.library.app.ws.model.response.LoanRestModel;
import com.hcl.library.dao.ImplBookDao;
import com.hcl.library.dao.ImplLoanDao;
import com.hcl.library.dao.ImplUserDao;
import com.hcl.library.model.Book;
import com.hcl.library.model.Loan;
import com.hcl.library.model.User;

@Path("/loans")
public class LoanEntryPoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAllLoans() {
		
		String listOfLoans = new ImplLoanDao().findAll().toString();
		
		return Response.status(200).entity(listOfLoans).build();
	
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response findLoan(@PathParam("id") int id) throws JsonProcessingException {

		Loan loan = new ImplLoanDao().findById(id);

		if (loan != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			String loanMapper = mapper.writeValueAsString(loan);
			
			//LoanRestModel restLoan = new LoanRestModel();
			//BeanUtils.copyProperties(loan, restLoan, "loans");
			return Response.status(200).entity(loanMapper).build();
			
		} else {
			
			return Response.status(404).build();
			
		}
	}

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newLoan(CreateLoanRequestModel requestLoan) {

		User staff = new ImplUserDao().findById(requestLoan.getIdStaff());
		User client = new ImplUserDao().findById(requestLoan.getIdUser());
		Book book = new ImplBookDao().findById(requestLoan.getIsbnBook());
		Loan newLoan = new Loan(staff, client, book);

		ImplLoanDao addLoan = new ImplLoanDao();
		addLoan.add(newLoan);
		
		return Response.status(200).build();
	}
}
