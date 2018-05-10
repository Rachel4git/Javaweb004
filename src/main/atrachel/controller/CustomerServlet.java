package main.atrachel.controller;
import main.atrachel.DAO.ZoneDao;
import main.atrachel.DAO.ZoneDaoFactory;
import main.atrachel.DAO.ZoneDaoImpl;
import main.atrachel.DTO.Zone;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by hd48552 on 2018/5/10.
 */

/**
 * mvc设计模式：先写数据库，再写dao层，再写业务层，再写JSP，最后写servlet。由下至上不可逆。
 * 数据库：
 * dao层：
 * 业务层：
 * JSP：
 * servlet：
 */
 public class CustomerServlet extends HttpServlet  {
//  调用工厂方法，返回一个实现类的实例对象，由其父类引用接收。该对象用于执行数据库操作
   ZoneDao zoneDao = ZoneDaoFactory.getInstance().getZoneDao();

  @Override
 public  void  doGet(HttpServletRequest request,HttpServletResponse response){
   doPost(request,response);
  }

  @Override
 public void doPost(HttpServletRequest request,HttpServletResponse response){
   String servletPath = request.getServletPath();
   String methodname = servletPath.substring(1);
   methodname = methodname.substring(0,methodname.length()-3);

   try {
    Method method = getClass().getDeclaredMethod(methodname,HttpServletRequest.class,HttpServletResponse.class);
    method.invoke(this,request,response);
   } catch (Exception e) {
    e.printStackTrace();
    try {
     response.sendRedirect("error.jsp");
    } catch (IOException e1) {
     e1.printStackTrace();
    }
   }

  }

 public  void  add(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //todo
  response.getWriter().print("add");
 }

 public  void  delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //todo
  response.getWriter().print("delete");
 }

 public  void  update(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //todo
  response.getWriter().print("update");
 }

 public  void  query(HttpServletRequest request, HttpServletResponse response) throws IOException {
  List<Zone> lsz =null;
  //todo
//  获取查询请求参数
  String qid= request.getParameter("id");
  String qzonename= request.getParameter("zonename");
  String zonearea= request.getParameter("zonearea");

//  调用dao实例对象进行查询操作
//  lsz = zoneDao.queryMany();

  request.setAttribute("zonelist",lsz);

//  response.getWriter().print("query");
 }
}

