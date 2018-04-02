package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.repository.AuthorRepository;
import com.gcit.lms.repository.BookLoansRepository;
import com.gcit.lms.repository.BookRepository;
import com.gcit.lms.repository.BorrowerRepository;
import com.gcit.lms.repository.BranchRepository;
import com.gcit.lms.repository.PublisherRepository;

@RestController
public class AdminService extends BaseController{

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	BranchRepository branchRepository;	
	
	@Autowired
	BorrowerRepository borrowerRepository;	
	
	@Autowired
	BookLoansRepository bookLoansRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	
	@RequestMapping(value="admin/readAuthors", method=RequestMethod.GET, produces="application/json")
	public List<Author> readAllAuthors(){
		return authorRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updateAuthor", method = RequestMethod.POST, consumes = "application/json")
	public void updateAuthor(@RequestBody Author author) throws SQLException {
		authorRepository.save(author);
	}
	
	@RequestMapping(value = "admin/deleteAuthor", method = RequestMethod.POST, consumes = "application/json")
	public void deleteAuthor(@RequestBody Author author) throws SQLException {
		authorRepository.delete(author);
	}
	
	
	@RequestMapping(value="admin/readPublishers", method=RequestMethod.GET, produces="application/json")
	public List<Publisher> readAllPublishers(){
		return publisherRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updatePublisher", method = RequestMethod.POST, consumes = "application/json")
	public void updatePublisher(@RequestBody Publisher publisher) throws SQLException {
		publisherRepository.save(publisher);
	}
	
	@RequestMapping(value = "admin/deletePublisher", method = RequestMethod.POST, consumes = "application/json")
	public void deletePublishers(@RequestBody Publisher publisher) throws SQLException {
		publisherRepository.delete(publisher);
	}
	
	
	@RequestMapping(value="admin/readBranches", method=RequestMethod.GET, produces="application/json")
	public List<Branch> readBranches(){
		return branchRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updateBranch", method = RequestMethod.POST, consumes = "application/json")
	public void updateBranch(@RequestBody Branch branch) throws SQLException {
		branchRepository.save(branch);
	}
	
	@RequestMapping(value = "admin/deleteBranch", method = RequestMethod.POST, consumes = "application/json")
	public void deleteBranch(@RequestBody Branch branch) throws SQLException {
		branchRepository.delete(branch);
	
	}
	
	
	@RequestMapping(value="admin/readBorrowers", method=RequestMethod.GET, produces="application/json")
	public List<Borrower> readBorrowers(){
		return borrowerRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updateBorrower", method = RequestMethod.POST, consumes = "application/json")
	public void updateBorrower(@RequestBody Borrower borrower) throws SQLException {
		borrowerRepository.save(borrower);
	}
	
	@RequestMapping(value = "admin/deleteBorrower", method = RequestMethod.POST, consumes = "application/json")
	public void deleteBorrower(@RequestBody Borrower borrower) throws SQLException {
		borrowerRepository.delete(borrower);
	
	}
	
	@RequestMapping(value = "admin/updateBookLoanDueDate", method = RequestMethod.POST, consumes = "application/json")
	public void updateBookLoanDueDate(@RequestBody BookLoan bookLoan) throws SQLException {
		bookLoansRepository.save(bookLoan);
	}
	
	
	
	@RequestMapping(value="admin/readBookAndAuthor", method=RequestMethod.GET, produces="application/json")
	public List<Book> readBookAndAuthor(){
		return bookRepository.findAll();
	}

}
