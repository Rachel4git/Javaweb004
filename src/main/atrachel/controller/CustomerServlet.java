package main.atrachel.controller;
import main.atrachel.DAO.ZoneDao;
import main.atrachel.DAO.ZoneDaoFactory;
import main.atrachel.DAO.ZoneDaoImpl;
import main.atrachel.DTO.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
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
//  调用工厂方法，返回一个ZoneDaoImpl的实例对象，由其父类引用ZoneDao接收。该对象用于执行数据库操作
   ZoneDaoFactory  zoneDaoFactory = ZoneDaoFactory.getInstance();
   ZoneDao zoneDao = zoneDaoFactory.getZoneDao("zonedaoimpl");

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
//  response.getWriter().print("add");
  ZoneDaoImpl zoneDAOImpl = null;

//  获取查询请求参数
  String qid= request.getParameter("id");
  String qzonename= request.getParameter("zonename");
  String qzonearea= request.getParameter("zonearea");

//  将请求参数封装成对象，并调用dao实例对象进行查询操作
  if(zoneDao instanceof ZoneDaoImpl )
   zoneDAOImpl = (ZoneDaoImpl) zoneDao;
  try {
   zoneDAOImpl.update(new CriteriaZone(qid,qzonename,qzonearea,0),"ADD");
   request.setAttribute("message","添加成功");
   try {
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e) {
    e.printStackTrace();
   }
  } catch (SQLException e) {
   e.printStackTrace();
   try {
    request.setAttribute("message","您请求的页面出现错误");
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e1) {
    e1.printStackTrace();
   }
  }
 }

 public  void  update(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //todo
//  response.getWriter().print("delete");
  //todo
//  response.getWriter().print("update");
  System.out.println("update");
  ZoneDaoImpl zoneDAOImpl = null;

//  获取查询请求参数
  String qid= request.getParameter("id");
  String qzonename= request.getParameter("zonename");
  String qzonearea= request.getParameter("zonearea");

  String qidnew= request.getParameter("idnew");
  String qzonenamenew= request.getParameter("zonenamenew");
  String qzoneareanew= request.getParameter("zoneareanew");

//  将请求参数封装成对象，并调用dao实例对象进行查询操作
  if(zoneDao instanceof ZoneDaoImpl )
   zoneDAOImpl = (ZoneDaoImpl) zoneDao;
  try {
   zoneDAOImpl.update(new CriteriaZone(qid,qzonename,qzonearea,0),new CriteriaZone(qidnew,qzonenamenew,qzoneareanew,0));
   request.setAttribute("message","更新成功");
   try {
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e) {
    e.printStackTrace();
   }
  } catch (SQLException e) {
   e.printStackTrace();
   try {
    request.setAttribute("message","您请求的页面出现错误");
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e1) {
    e1.printStackTrace();
   }
  }
 }


 public  void  delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //todo
//  response.getWriter().print("update");
  System.out.println("delete");
  ZoneDaoImpl zoneDAOImpl = null;

//  获取查询请求参数
  String qid= request.getParameter("id");
  String qzonename= request.getParameter("zonename");
  String qzonearea= request.getParameter("zonearea");

//  将请求参数封装成对象，并调用dao实例对象进行查询操作
  if(zoneDao instanceof ZoneDaoImpl )
   zoneDAOImpl = (ZoneDaoImpl) zoneDao;
  try {
   zoneDAOImpl.update(new CriteriaZone(qid,qzonename,qzonearea,0));
   request.setAttribute("message","删除成功");
   try {
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e) {
    e.printStackTrace();
   }
  } catch (SQLException e) {
   e.printStackTrace();
   try {
    request.setAttribute("message","您请求的页面出现错误");
    request.getRequestDispatcher("error.jsp").forward(request,response);
   } catch (ServletException e1) {
    e1.printStackTrace();
   }
  }

 }

 public  void  query(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
  List<Zone> lsz =null; //用于存放查询结果
  ZoneDaoImpl zoneDAOImpl = null;

//  获取查询请求参数
  String qid= request.getParameter("id");
  String qzonename= request.getParameter("zonename");
  String qzonearea= request.getParameter("zonearea");

//  将请求参数封装成对象，并调用dao实例对象进行查询操作
  if(zoneDao instanceof ZoneDaoImpl )
      zoneDAOImpl = (ZoneDaoImpl) zoneDao;
   lsz = zoneDAOImpl.queryMany( new CriteriaZone(qid,qzonename,qzonearea,1));

//将查询结果放到request中
  request.setAttribute("zonelist",lsz);
  try {
// 请求转发到zone.jsp，将查询结果在页面回显
   request.getRequestDispatcher("zone.jsp").forward(request,response);
  } catch (ServletException e) {
   e.printStackTrace();
  }

//  response.getWriter().print("query");
 }
}

