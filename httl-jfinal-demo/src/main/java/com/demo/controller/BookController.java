package com.demo.controller;

import com.demo.model.Book;
import com.jfinal.core.Controller;

public class BookController extends Controller {
	public void index(){
		setAttr("title", "图书列表");
		setAttr("books",  Book.dao.find("select * from books"));
		render("index.httl");
	}

	public void newPage(){
		setAttr("title", "新增图书");
		setAttr("book",  new Book());
		createToken("newToken", 120);
		render("new.httl");
	}

	public void create(){
		if(this.getModel(Book.class,"book").save()){
			this.setSessionAttr("msg", "创建成功");
			redirect("/book/index");
		}else{
			this.setSessionAttr("msg", "创建失败");
			this.keepModel(Book.class,"book");
			createToken("newToken", 120);
			render("new.httl");
		}
	}
}
