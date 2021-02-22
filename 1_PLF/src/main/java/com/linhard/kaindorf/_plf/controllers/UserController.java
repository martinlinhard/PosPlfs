/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.controllers;

import com.linhard.kaindorf._plf.access.generic.UserHandler;
import com.linhard.kaindorf._plf.access.json.JsonUserHandler;
import com.linhard.kaindorf._plf.access.xml.XmlUserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.linhard.kaindorf._plf.pojo.generic.User;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;

/**
 *
 * @author martin
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private List<User> users = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            super.init(config); //To change body of generated methods, choose Tools | Templates.
            String path = config.getServletContext().getRealPath("/res");
            path += "/users";
            this.loadUsers(XmlUserHandler.class, path);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private <E extends UserHandler> void loadUsers(Class<E> loader, String path) throws InstantiationException, IllegalAccessException {
        this.users = loader.newInstance().getUsers(path);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        if (request.getSession().getAttribute("users") == null) {
            request.getSession().setAttribute("users", new ArrayList<User>() {
                {
                    addAll(users);
                }
            });
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String deleteId = request.getParameter("deleteId");
        if (request.getSession().getAttribute("users") != null) {
            List<User> current = (List<User>) request.getSession().getAttribute("users");
            current.removeIf(user -> user.getId().equals(deleteId));
            request.getSession().setAttribute("users", current);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
