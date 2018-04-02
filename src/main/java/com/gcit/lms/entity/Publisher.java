/**
 * 
 */
package com.gcit.lms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author ppradhan
 *
 */
@Entity
@Table(name="tbl_publisher")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="publisherId", scope=Publisher.class)
public class Publisher implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6154042387284730265L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="publisherId", unique = true, nullable = false)
	private Integer publisherId;
	
	@Column(name="publisherName", nullable = false)
	private String publisherName;
	
	@Column(name="publisherPhone", nullable = false)
	private String publisherPhone;
	
	@Column(name="publisherAddress", nullable = false)
	private String publisherAddress;
	
	@OneToMany
	@JoinColumn(name = "pubId")
	private List<Book> books;
	/**
	 * @return the publisherId
	 */
	public Integer getPublisherId() {
		return publisherId;
	}
	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}
	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	/**
	 * @return the publisherPhone
	 */
	public String getPublisherPhone() {
		return publisherPhone;
	}
	/**
	 * @param publisherPhone the publisherPhone to set
	 */
	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}
	/**
	 * @return the publisherAddress
	 */
	public String getPublisherAddress() {
		return publisherAddress;
	}
	/**
	 * @param publisherAddress the publisherAddress to set
	 */
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
