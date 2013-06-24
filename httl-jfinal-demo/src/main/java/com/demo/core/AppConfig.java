package com.demo.core;

import httl.web.jfinal.HttlRenderFactory;

import com.alibaba.druid.filter.stat.StatFilter;
import com.demo.controller.BookController;
import com.demo.controller.IndexController;
import com.demo.model.Book;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;

public class AppConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		//加载数据库配置文件
		loadPropertyFile("database.properties");
		//设定采用httl模板引擎
		me.setMainRenderFactory(new HttlRenderFactory());
		//设定错误页面
		me.setError404View("/404.html");
		me.setError500View("/500.html");
		//设定为开发者模式
		me.setDevMode(true);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/",IndexController.class);
		me.add("/book", BookController.class);

	}

	@Override
	public void configPlugin(Plugins me) {
		//从配置文件中获取数据库配置项
        String driver = getProperty("dataSource.driverClass");
        String jdbcUrl = getProperty("dataSource.url");
        String username = getProperty("dataSource.userName");
        String password = getProperty("dataSource.password");

        //初始化数据库连接池
        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrl, username, password, driver);
        druidPlugin.setInitialSize(3).setMaxActive(10);
        druidPlugin.addFilter(new StatFilter());

        //加载数据库连接池插件
        me.add(druidPlugin);
        //初始化activerecord
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        //开发阶段，显示sql
        arp.setShowSql(true);
        //因为AR默认使用MySqL的方言，若使用PostgreSQL，则需要配置PostgreSQL的方言。
        //arp.setDialect(new PostgreSqlDialect());
        //因为AR默认使用MySqL的方言，若使用Mysql，也可不加此行。
        arp.setDialect(new MysqlDialect());
        //添加表名~实体类的映射。
        arp.addMapping("books", Book.class);
        //加载AR插件
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		//Druid链接池状态处理器，可以通过访问 http://ip:port/druid 来查看数据库访问情况。
		DruidStatViewHandler dvh =  new DruidStatViewHandler("/druid");
		me.add(dvh);
		//该处理器将request.getContextPath()存储在BASE_PATH中，可以解决路径问题
		ContextPathHandler path = new ContextPathHandler("BASE_PATH");
		me.add(path);

	}

}
