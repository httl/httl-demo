/*
 * Copyright 2011-2012 HTTL Team.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.demo.domain;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Book
 * 
 * @author
 */
@Table("Book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private long id;
	
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String publisher;
	@Column
	private Date publication;
	@Column
	private int price;
	@Column
	private int discount;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book() {
	}
	
	public Book(String title, String author, String publisher, Date publication, int price, int discount){
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publication = publication;
		this.price = price;
		this.discount = discount;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublication() {
		return publication;
	}
	
	public void setPublication(Date publication) {
		this.publication = publication;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}