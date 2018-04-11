package com.gcit.lms.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookAuthors;
import com.gcit.lms.entity.BookGenres;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.repository.AuthorRepository;
import com.gcit.lms.repository.BookAuthorsRepository;
import com.gcit.lms.repository.BookGenresRepository;
import com.gcit.lms.repository.BookLoansRepository;
import com.gcit.lms.repository.BookRepository;
import com.gcit.lms.repository.BorrowerRepository;
import com.gcit.lms.repository.BranchRepository;
import com.gcit.lms.repository.GenreRepository;
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
	
	@Autowired
	BookAuthorsRepository bookAuthorsRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	BookGenresRepository bookGenresRepository;
	
	
	@RequestMapping(value="initAuthor", method=RequestMethod.GET, produces="application/json")
	public Author initAuthor(){
		return new Author();
	}
	
	@RequestMapping(value="initBook", method=RequestMethod.GET, produces="application/json")
	public Book initBook(){
		return new Book();
	}
	
	@RequestMapping(value="admin/initPublisher", method=RequestMethod.GET, produces="application/json")
	public Publisher initPublisher(){
		return new Publisher();
	}
	
	//Authors
	
	@RequestMapping(value="admin/readAuthors", method=RequestMethod.GET, produces="application/json")
	public List<Author> readAllAuthors(){
		return authorRepository.findAll();
	}
	
	@RequestMapping(value = "admin/getAuthorByPk/{authorId}", method = RequestMethod.GET, produces = "application/json")
	public Author getAuthorByPk(@PathVariable("authorId") Integer authorId) throws SQLException {
		return authorRepository.findByAuthorId(authorId);
	}
	
	@RequestMapping(value = "admin/searchAuthors/{authorName}", method = RequestMethod.GET, produces = "application/json")
	public List<Author> getAuthorByPk(@PathVariable("authorName") String authorName) throws SQLException {
		return authorRepository.findAllByAuthorName(authorName);
	}
	
	@RequestMapping(value = "admin/updateAuthor", method = RequestMethod.POST, consumes = "application/json")
	public void updateAuthor(@RequestBody Author author) throws SQLException {
		authorRepository.save(author);
	}
	
	@RequestMapping(value = "admin/deleteAuthor", method = RequestMethod.POST, consumes = "application/json")
	public void deleteAuthor(@RequestBody Author author) throws SQLException {
		authorRepository.delete(author);
	}
	
	
	//Publishers
	
	@RequestMapping(value="admin/readPublishers", method=RequestMethod.GET, produces="application/json")
	public List<Publisher> readAllPublishers(){
		return publisherRepository.findAll();
	}
	
	@RequestMapping(value = "admin/getPublisherByPk/{publisherId}", method = RequestMethod.GET, produces = "application/json")
	public Publisher getPublisherByPk(@PathVariable("publisherId") Integer publisherId) throws SQLException {
		return publisherRepository.findByPublisherId(publisherId);
	}
	
	@RequestMapping(value = "admin/updatePublisher", method = RequestMethod.POST, consumes = "application/json")
	public void updatePublisher(@RequestBody Publisher publisher) throws SQLException {
		publisherRepository.save(publisher);
	}
	
	@RequestMapping(value = "admin/deletePublisher", method = RequestMethod.POST, consumes = "application/json")
	public void deletePublishers(@RequestBody Publisher publisher) throws SQLException {
		publisherRepository.delete(publisher);
	}
	
	
	//Branches
	
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
	
	//Genres 
	
	@RequestMapping(value="admin/readGenres", method=RequestMethod.GET, produces="application/json")
	public List<Genre> readGenres(){
		return genreRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updateGenre", method = RequestMethod.POST, consumes = "application/json")
	public void updateGenre(@RequestBody Genre genre) throws SQLException {
		genreRepository.save(genre);
	}
	
	@RequestMapping(value = "admin/deleteGenre", method = RequestMethod.POST, consumes = "application/json")
	public void deleteGenre(@RequestBody Genre genre) throws SQLException {
		genreRepository.delete(genre);
	
	}
	
//	@RequestMapping(value = "admin/getGenreByPk/{genre_id}", method = RequestMethod.GET, produces = "application/json")
//	public Genre getGenreByPk(@PathVariable("genre_id") Integer genre_id) throws SQLException {
//		return genreRepository.findGenreByGenreId(genre_id);
//	}
	
	@RequestMapping(value = "admin/saveBookGenres/{bookId}/{genre_id}", method = RequestMethod.POST)
	public void saveBookGenres(@PathVariable("bookId") Integer bookId, @PathVariable("genre_id") Integer genre_id) throws SQLException {
		
		BookGenres bg = new BookGenres();
		bg.setBookId(bookId);
		bg.setGenre_id(genre_id);
		
		bookGenresRepository.save(bg);
		
	}
	
	//borrowers
	
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
	
	
	//books
	
	@RequestMapping(value="admin/readBooks", method=RequestMethod.GET, produces="application/json")
	public List<Book> readBooks(){
		return bookRepository.findAll();
	}
	
	@RequestMapping(value = "admin/updateBook", method = RequestMethod.POST, consumes = "application/json")
	public void updateBook(@RequestBody Book book) throws SQLException {
		bookRepository.save(book);
	}
	
	@RequestMapping(value = "admin/deleteBook", method = RequestMethod.POST, consumes = "application/json")
	public void deleteBook(@RequestBody Book book) throws SQLException {
		bookRepository.delete(book);
	
	}
	
	@RequestMapping(value = "admin/saveBookWithPk", method = RequestMethod.POST, consumes = "application/json")
	public Integer saveBook(@RequestBody Book book) throws SQLException {
		
		bookRepository.save(book);
		Integer id = book.getBookId();
		return id;
		
	}
	
	@RequestMapping(value = "admin/getBookByPk/{bookId}", method = RequestMethod.GET, produces = "application/json")
	public Book getBookByPk(@PathVariable("bookId") Integer bookId) throws SQLException {
		return bookRepository.findByBookId(bookId);
	}
	
	@RequestMapping(value = "admin/saveBookAuthors/{bookId}/{authorId}", method = RequestMethod.POST)
	public void saveBookAuthors(@PathVariable("bookId") Integer bookId, @PathVariable("authorId") Integer authorId) throws SQLException {
		
		BookAuthors ba = new BookAuthors();
		ba.setBookId(bookId);
		ba.setAuthorId(authorId);
		
		bookAuthorsRepository.save(ba);
		
	}
	
	
	//BookLoans
	
//	@RequestMapping(value = "borrower/readBookLoansByDetails/{branchId}/{cardNo}/{bookId}/{dateOut}", method = RequestMethod.GET, produces = "application/json")
//	public BookLoan readBookLoansByDetails(@PathVariable("branchId") Integer branchId, @PathVariable("cardNo") Integer cardNo,
//			@PathVariable("bookId") Integer bookId, @PathVariable("dateOut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOut) throws SQLException {
//		return bookLoansRepository.findBookLoanByDetails(branchId, cardNo, bookId, dateOut);
//	}
	
	@RequestMapping(value = "borrower/readBookLoansByDetails", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BookLoan readBookLoansByDetails(@RequestBody BookLoan bookloan) throws SQLException {
		return bookLoansRepository.findBookLoanByDetails(bookloan.getBranch().getBranchId(), bookloan.getCardNo(), bookloan.getBook().getBookId(), bookloan.getDateOut());
	}

}
