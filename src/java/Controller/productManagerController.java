/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import dto.Category;
import dto.Product;
import dto.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
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
        List<Product> list;
        if ("1".equals(c.getRole())) {
            list = dao.pagingAllProducts(index);
        }else{
            list = dao.pagingProducts(index,id);
        }
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
        String action = request.getParameter("action");
        Product product = new Product();
        switch (action) {
            case "Add":
                String name = request.getParameter("name");
                String priceString = request.getParameter("price");
                BigDecimal price = new BigDecimal(priceString);
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String description = request.getParameter("description");
                int category = Integer.parseInt(request.getParameter("category"));
                product = new Product(name, price, quantity, description, 0,dao.getCategoryById(category), (User) session.getAttribute("user"),"0");
                dao.addProduct(product);
                int product_id = dao.findProductId(product);
                //-------------------------------------------------------
        //        List<Part> imageParts = new ArrayList<>();
        //        Collection<Part> parts = request.getParts();
        //        for (Part part : parts) {
        //            if ("images".equals(part.getName())) {
        //                imageParts.add(part);
        //            }
        //        }
                //--------------------------------------------------------
                //-------------------------------------------------------------
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                List<Part> imageParts = new ArrayList<>();
                Collection<Part> parts = request.getParts();
                for (Part part : parts) {
                    if ("images".equals(part.getName())) {
                        imageParts.add(part);
                    }
                } // Retrieves <input type="file" name="image">
                for(Part filePart : imageParts){
                        String fileName = UUID.randomUUID().toString() + ".jpg"; // Generate random file name
                        String filePath = uploadPath + File.separator + fileName;
                        Path path = new File(filePath).toPath();
                        Files.copy(filePart.getInputStream(), path);
                        File file = new File(filePath);
                        BufferedImage image = ImageIO.read(file);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "png", baos);
                        byte[] imageData = baos.toByteArray();
                        //-------------------------------------------------------------
                        dao.addImage(product_id, imageData);
                }
                processRequest(request, response);
                break;
            case "delete":
                int productIdDelete = Integer.parseInt(request.getParameter("product_id"));
                dao.deleteImagesByProductId(productIdDelete);
                dao.deleteProduct(productIdDelete);
                processRequest(request, response);
                break;
            case "detail":
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Detail");
                break;
            case "search":
                String search = request.getParameter("search");
                List<Product> productList = dao.getAllProducts();
                productList = product.findProductsByString(productList,search);
                session.setAttribute("ListP", productList);
                session.setAttribute("search", search);
                request.getRequestDispatcher("accountManager.jsp").forward(request, response);
                break;
            case "changeStatus":
                int productIdChangeStatus = Integer.parseInt(request.getParameter("product_id"));
                if("0".equals(dao.getProductWithImagesByProductID(productIdChangeStatus).getStatus())){
                    if(dao.getProductWithImagesByProductID(productIdChangeStatus).getQuantity()==0){
                        session.setAttribute("Message", "Cannot Activate Product: "+dao.getProductWithImagesByProductID(productIdChangeStatus).getName()+"(ID: "+
                                dao.getProductWithImagesByProductID(productIdChangeStatus).getProductId()+") Because Its Quantity = 0");
                    }else{
                        dao.changeStatusForProduct(dao.getProductWithImagesByProductID(productIdChangeStatus),"1");
                    }
                }else{
                    dao.changeStatusForProduct(dao.getProductWithImagesByProductID(productIdChangeStatus), "0");
                }
                processRequest(request, response);
                break;
            default:
                throw new AssertionError();
        }
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
