/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import dto.Category;
import dto.Product;
import dto.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class productManagerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String indexPage = request.getParameter("index");
        if(indexPage==null){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        HttpSession session = request.getSession();
        User c = (User) session.getAttribute("user");
        int id = c.getUserId();
        DAO dao = new DAO();
        int count = dao.getTotal("product");
        int endPage = count/10;
        if(count%10!=0) endPage++;
        List<Product> list = dao.pagingProducts(index,id);
        List<Category> listC = dao.getAllCategories();
        session.setAttribute("listCC", listC);
        session.setAttribute("listP", list);
        request.setAttribute("endPage", endPage);
        request.setAttribute("tag", index);
        request.getRequestDispatcher("productManager.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name, price, quantity, description, 0,dao.getCategoryById(category), (User) session.getAttribute("user"));
        List<Part> imageParts = new ArrayList<>();
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if ("images".equals(part.getName())) {
                imageParts.add(part);
            }
        }
        dao.addProduct(product, imageParts);
        request.getRequestDispatcher("productManager.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
