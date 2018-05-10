package main.atrachel.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hd48552 on 2018/5/10.
 */
public class Test2Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }

    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response){
        //todo
//        System.out.println("---");
        String servletPath = request.getServletPath(); //获取servletpath："add.do"
        String methodName = servletPath.substring(1);  //去除“/”
        methodName = methodName.substring(0, methodName.length() - 3); //去除“.do”

        try {
//            1.通过反射，获取运行时类的方法
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
//            2.调用对应的方法
            method.invoke(this,request,response);
            /**
             * 方案二优点：通过servletpath获取方法名字并通过反射调用对应的方法，当JSP页面多加一个方法时，无需更该代码
             */
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
        //todo
        response.getWriter().print("query");
    }
}
