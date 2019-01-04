package com.cyx.java_web.web_03_CRUD.web.servlet.product;

import com.cyx.java_web.web_03_CRUD.dao.IProductDAO;
import com.cyx.java_web.web_03_CRUD.dao.IProductTypeDAO;
import com.cyx.java_web.web_03_CRUD.dao.impl.ProductDAOImpl;
import com.cyx.java_web.web_03_CRUD.dao.impl.ProductTypeDAOImpl;
import com.cyx.java_web.web_03_CRUD.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = -8469721335099406543L;

    private IProductDAO productDAO;
    private IProductTypeDAO typeDAO;

    @Override
    public void init() {
        productDAO = new ProductDAOImpl();
        typeDAO = new ProductTypeDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断当前用户是否登陆（判断 session 中是否存在 USER_IN_SESSION）
        if (req.getSession().getAttribute("USER_IN_SESSION") == null) {
            // 若不存在，返回登陆页面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        req.setCharacterEncoding("UTF-8");
        String opt = req.getParameter("opt") == null ? "" : req.getParameter("opt");
        switch (opt) {
            case "delete":
                delete(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "save":
                save(req, resp);
                break;
            default:
                list(req, resp);
        }
    }

    /**
     * 获取商品列表
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productDAO.getAll());
        req.getRequestDispatcher("/WEB-INF/views/product/productList.jsp").forward(req, resp);
    }

    /**
     * 删除指定商品
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (isNotBlank(id)) {
            productDAO.delete(Long.valueOf(id));
        }
        resp.sendRedirect(req.getContextPath() + "/product");
    }

    /**
     * 修改制定商品
     */
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (isNotBlank(id)) {
            req.setAttribute("product", productDAO.get(Long.valueOf(id)));
        }
        req.setAttribute("productTypes", typeDAO.getAll());
        req.getRequestDispatcher("/WEB-INF/views/product/productEdit.jsp").forward(req, resp);
    }

    /**
     * 添加商品
     */
    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Product product = new Product(Integer.valueOf(req.getParameter("productTypeId")),
                req.getParameter("name"), req.getParameter("brand"),
                new BigDecimal(req.getParameter("purchasingPrice")),
                new BigDecimal(req.getParameter("originalPrice")),
                new BigDecimal(req.getParameter("currentPrice")));
        if (isNotBlank(id)) {
            product.setId(Long.valueOf(id));
            productDAO.update(product);
        } else {
            productDAO.add(product);
        }
        resp.sendRedirect(req.getContextPath() + "/product");
    }

    private boolean isNotBlank(String str) {
        return str != null && !"".equals(str.trim());
    }
}