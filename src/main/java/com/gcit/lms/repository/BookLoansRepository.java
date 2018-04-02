package com.gcit.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookLoan;

@Repository
public interface BookLoansRepository extends JpaRepository<BookLoan, Integer> {
	
	@Query("SELECT bl FROM BookLoan bl where bl.cardNo = ?1")
    public List<BookLoan> findBookLoansByCardNo(Integer cardNo);
	
}
