package com.demo;

import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.demo.domain.Book;
import com.demo.util.Webs;



public class MvcSetup implements Setup {

	@Override
	public void init(NutConfig config) {
		Webs.dao().create(Book.class, true);
		for (int i = 0; i < 100; i++) {
			Book book = new Book();
			book.setAuthor("xxx"+i);
			book.setPrice(i);
			book.setPublisher("pp"+i);
			book.setTitle("title"+i);
			Webs.dao().insert(book);
		}
	}

	/**
	 * 当应用系统停止的时候要做的操作
	 */
	@Override
	public void destroy(NutConfig config) {
	}

}