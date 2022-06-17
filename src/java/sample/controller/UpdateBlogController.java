/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.posts.Blog;
import sample.posts.BlogDAO;
import sample.users.ManagerDTO;

/**
 *
 * @author tvfep
 */
@WebServlet(name = "UpdateBlogController", urlPatterns = {"/UpdateBlogController"})
public class UpdateBlogController extends HttpServlet {

    private static final String SUCCESS = "BlogListController";
    private static final String ERROR = "error.jsp";
    private static final String UPDATE_PAGE = "Update_Blog.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;

        BlogDAO blogDao = new BlogDAO();
        Blog blog = new Blog();
        HttpSession session = request.getSession();
        ManagerDTO manager = (ManagerDTO) session.getAttribute("LOGIN_USER");
        try {

            String type = request.getParameter("type");
            String activity = request.getParameter("activity");

            String id = request.getParameter("blogID");
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            String imgUrl = request.getParameter("imgUrl");
            String summary = request.getParameter("summary");

            if (activity == null) {
                blog = blogDao.getAnBlogByID(id);
                request.setAttribute("blog", blog);
                url = UPDATE_PAGE;

            } else if ("CLB".equals(manager.getRoleID())) {

                blog = new Blog(id, title, content, imgUrl, summary);
                boolean checkUpdate = blogDao.updateABlog(blog, manager.getRoleID());
                if (checkUpdate == true) {
                    url = SUCCESS;

                }
            } else if ("MOD".equals(manager.getRoleID())) {
                if (type == null) {
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    blog = new Blog(id, title, content, imgUrl, summary, status);

                    boolean checkUpdate = blogDao.updateABlog(blog, manager.getRoleID());
                    if (checkUpdate == true) {
                        url = SUCCESS;
                    }

                } else if ("FPT".equals(type)) {
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    boolean checkUpdate = blogDao.updateBlogStatus(id, status);
                    if (checkUpdate == true) {
                        url = SUCCESS;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
        processRequest(request, response);
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
