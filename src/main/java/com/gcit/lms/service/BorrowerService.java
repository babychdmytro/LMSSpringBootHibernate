/**
 * 
 */
package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.repository.BookCopiesRepository;
import com.gcit.lms.repository.BookLoansRepository;
import com.gcit.lms.repository.BookRepository;
import com.gcit.lms.repository.BorrowerRepository;
import com.gcit.lms.repository.BranchRepository;

/**
 * @author babyc
 *
 */

@RestController
public class BorrowerService extends BaseController {

	@Autowired
	BorrowerRepository borrowerRepository;

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookLoansRepository bookLoansRepository;

	@Autowired
	BookCopiesRepository bookCopiesRepository;

	
	@RequestMapping(value = "borrower/readBorrowers", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readAllBorrowers() {
		return borrowerRepository.findAll();
	}

	@RequestMapping(value = "borrower/readBranches", method = RequestMethod.GET, produces = "application/json")
	public List<Branch> readBranches() throws SQLException {
		return branchRepository.findAll();

	}

	@RequestMapping(value = "borrower/readBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBooks() {

		return bookRepository.findAll();
	}

	@RequestMapping(value = "borrower/readBookLoans", method = RequestMethod.GET, produces = "application/json")
	public List<BookLoan> readBookLoans() throws SQLException {

		return bookLoansRepository.findAll();

	}

	@RequestMapping(value = "borrower/readBookLoansByCardNo/{cardNo}", method = RequestMethod.GET, produces = "application/json")
	public List<BookLoan> readBookLoansByCardNo(@PathVariable("cardNo") Integer cardNo) throws SQLException {

		return bookLoansRepository.findBookLoansByCardNo(cardNo);

	}

	@RequestMapping(value = "borrower/updateBookLoan", method = RequestMethod.POST, consumes = "application/json")
	public void updateBookLoan(@RequestBody BookLoan bookLoan) throws SQLException {
		bookLoansRepository.save(bookLoan);
	}

	@RequestMapping(value = "borrower/updateBookCopies", method = RequestMethod.POST, consumes = "application/json")
	public void updateBookCopies(@RequestBody BookCopies bookCopies) throws SQLException {
		bookCopiesRepository.save(bookCopies);
	}

}
