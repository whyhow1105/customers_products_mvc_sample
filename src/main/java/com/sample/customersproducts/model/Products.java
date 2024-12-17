package com.sample.customersproducts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products extends Maintenance {
	
	@Column(name = "Book_Title")
	private String bookTitle;
	
	@Column(name = "Book_Price")
	private double bookPrice;
	
	@Column(name = "Book_Quantity")
	private int bookQuantity;

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public Products() {
		super();
	}

}
