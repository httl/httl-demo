package com.demo.module;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.service.IdEntityService;

import com.demo.domain.Book;


@IocBean(fields = { "dao" })
public class BooksModule extends IdEntityService<Book> {
	@At("diplay")
	@Ok("httl:page.books")
	public Map<String, Object>  diplay() throws SQLException {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Book> books = this.dao().query(Book.class, null, null);
		map.put("books", books);
		return map;

	}
}
