package com.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("*** initializing controller servlet.");
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
    	HttpServletResponse response) throws ServletException, IOException {
    	// recuperation de l'action à effectuer
    	String do_this = request.getParameter("do_this");
    	if (do_this == null) {
    	// definir le contexte pour une redirection sur la page accueil.jsp
    	ServletContext sc = getServletContext();
    	RequestDispatcher rd = sc.getRequestDispatcher("/accueil.jsp");
    	// charger la liste des contacts dans la requête pour les
    	// transmettre à la JSP accueil.jsp (qui va les afficher)
    	//request.setAttribute("listContacts", contactFacade.findAll());
    	rd.forward(request, response);
    	} else if (do_this.equals("delete")) {
    	// recuperation de l'id du contact
    	String id = (String) request.getParameter("contact_id");
    	if (id == null) {
    	// redirection sur la page removeContact.jsp
    	response.sendRedirect("removeContact.jsp");
    	} else {
    	// id non nul, donc on supprime le contact identifié par id
    	//contactFacade.deleteContact(id);
    	// on recharge la page d'accueil
    	response.sendRedirect("ControllerServlet");
    	}
    	} else if (do_this.equals("create")) {
    	// recuperation du nom contact
    	String lastName = (String) request.getParameter("lastName");
    	if (lastName == null) {
    	// redirection sur la page removeContact.jsp
    	response.sendRedirect("addContact.jsp");
    	} else {
    	// TODO le nom n'est pas nul, donc on ajoute le contact dans la base
    		//contactFacade.createContact(...);
    		// on recharge la page d'accueil
    		response.sendRedirect("ControllerServlet");
    	}
    	} else if (do_this.equals("update")) {
    	// TODO ...
    	} else if (do_this.equals("search")) {
    	// TODO ...
    	}
    	// TODO ...
    	}
}