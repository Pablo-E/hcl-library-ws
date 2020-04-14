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

import com.hcl.library.app.ws.ui.model.request.CreateLoanRequestModel;
import com.hcl.library.app.ws.ui.model.response.LoanRestModel;
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
	public List<Loan> showAllLoans() {
		List<Loan> listOfLoans = new ImplLoanDao().findAll();		
		return listOfLoans;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoanRestModel findLoan(@PathParam("id") int id) {

		Loan loan = new ImplLoanDao().findById(id);
		LoanRestModel restLoan = new LoanRestModel();
		BeanUtils.copyProperties(loan, restLoan);
		
		return restLoan;
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void newLoan(CreateLoanRequestModel requestLoan) {
		
		User staff = new ImplUserDao().findById(requestLoan.getIdStaff());
		User client = new ImplUserDao().findById(requestLoan.getIdUser());
		Book book = new ImplBookDao().findById(requestLoan.getIsbnBook());
		Loan newLoan = new Loan(staff, client, book);
		
		ImplLoanDao addLoan = new ImplLoanDao();
		addLoan.add(newLoan);
	}
}
