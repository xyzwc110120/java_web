package com.cyx.java_web.web_01_servlet.servlet_07_simpleCalculator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleCalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = -7376001343632139289L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String num1 = req.getParameter("num1");
        String calculate = req.getParameter("calculate");
        String num2 = req.getParameter("num2");
        // 计算结果
        Integer result = null;
        if (isNotBlank(num1) && isNotBlank(num2)) {
            Integer n1 = Integer.valueOf(num1);
            Integer n2 = Integer.valueOf(num2);
            switch (calculate) {
                case "+" :
                    result = n1 + n2;
                    break;
                case "-" :
                    result = n1 - n2;
                    break;
                case "*" :
                    result = n1 * n2;
                    break;
                case "/" :
                    result = n1 / n2;
            }
        }

        // 设置响应信息
        resp.setContentType("text/html; charset=UTF-8");
        // 输出一个简单的计算机 HTML 页面
        PrintWriter writer = resp.getWriter();
        writer.print("<form action='/java_web/calculator' method='post'>");
        writer.print("<input type='number' name='num1' value='" + num1 + "' />&nbsp;&nbsp;");
        writer.print("<select name='calculate'>");
        writer.print("<option" + ("+".equals(calculate) ? " selected" : "") + ">+</option>");
        writer.print("<option" + ("-".equals(calculate) ? " selected" : "") + ">-</option>");
        writer.print("<option" + ("*".equals(calculate) ? " selected" : "") + ">*</option>");
        writer.print("<option" + ("/".equals(calculate) ? " selected" : "") + ">/</option>");
        writer.print("</select>&nbsp;&nbsp;");
        writer.print("<input type='number' name='num2' value='" + num2 + "' />&nbsp;&nbsp;");
        writer.print("<input type='submit' value=' = ' />&nbsp;&nbsp;");
        writer.print("<input type='number' value='" + result +"' readonly />");
        writer.print("</form>");
    }

    private boolean isNotBlank(String str) {
        return str != null && !"".equals(str.trim());
    }
}
