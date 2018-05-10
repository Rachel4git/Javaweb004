package main.atrachel.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hd48552 on 2018/5/10.
 */
public class Test1Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
/**
  *通过获取method的值，来调用对应的方法
 * 缺点：如果再test1.jsp页面加入一个方法，需要在swith语句中多加入一个case
 */


        String method = request.getParameter("method");
        if(! method.equals(null)){
            switch(method){
                case "add" : add(request,response); break;
                case "delete" : delete(request,response); break;
                case "update" : update(request,response); break;
                case "query" : query(request,response); break;
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
        //todo
        response.getWriter().print("query");
    }
}
