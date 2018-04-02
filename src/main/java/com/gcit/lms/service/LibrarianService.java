package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.repository.BookCopiesRepository;
import com.gcit.lms.repository.BranchRepository;

@RestController
public class LibrarianService extends BaseController{
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	BookCopiesRepository bookCopiesRepository;
	
	@RequestMapping(value = "librarian/readBranches", method = RequestMethod.GET, produces = "application/json")
	public List<Branch> readBranches() throws SQLException {
		return branchRepository.findAll();
	}
	
	@RequestMapping(value = "librarian/updateBranch", method = RequestMethod.POST, consumes = "application/json")
	public void updateBranch(@RequestBody Branch branch) throws SQLException {
		branchRepository.save(branch);
	}
	
	@RequestMapping(value = "librarian/updateBookCopies", method = RequestMethod.POST, consumes = "application/json")
	public void updateBookCopies(@RequestBody BookCopies bookCopies) throws SQLException {
		bookCopiesRepository.save(bookCopies);
	}
}
