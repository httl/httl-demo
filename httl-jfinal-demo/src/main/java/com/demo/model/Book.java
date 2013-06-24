package com.demo.model;

import com.jfinal.plugin.activerecord.Model;

public class Book extends Model<Book> {
	private static final long serialVersionUID = 3921861459903415327L;
	public static Book dao = new Book();
}
