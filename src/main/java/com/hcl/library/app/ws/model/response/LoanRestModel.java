package com.hcl.library.app.ws.model.response;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcl.library.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRestModel {

	private int idLoan;
	private Date loanDate;
	//private String staffName;
	/*
	@JsonProperty("staff")
	private void unpackNested(Map<String,Object> staff) {
        this.staffName = (String)staff.get("name");
        //Map<String,String> owner = (Map<String,String>)brand.get("owner");
        //this.ownerName = owner.get("name");
    }
	*/
	
}
