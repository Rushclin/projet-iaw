package org.carnet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.carnet.beans.Contacts;
import org.carnet.dao.ContactDao;

/**
 * Servlet implementation class ControllerServlet
 */
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// On recupere l'action
		String action = request.getParameter("action");
		if (action == null) {
			String number = request.getParameter("number");
			if (number != null) {
				try {
					ContactDao.deleteContact(number);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// ici on recupere les contacts dans la base de donnees
			try {
				ContactDao.getContact();
				request.setAttribute("contacts", ContactDao.getContact());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Ici, on est sur la page d'acceui et on doit lister les contacts
			System.out.println(action);
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/acceuil.jsp");
			rd.forward(request, response);
		} else if (action.equals("new")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/nouveauContact.jsp");
			rd.forward(request, response);

		} else if (action.equals("edit")) {
			Contacts contact = new Contacts();
			contact.setFirst_name(request.getParameter("firstname"));
			contact.setLast_name(request.getParameter("lastname"));
			contact.setAdresse(request.getParameter("adresse"));
			contact.setEmail(request.getParameter("email"));
			contact.setPhone(request.getParameter("phone"));
			request.setAttribute("contacts", contact);
			// On doit aussi recuperer l'identifiant
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/editerContact.jsp");
			rd.forward(request, response);

		} else if (action.equals("search")) {

			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("accueil.jsp");
			rd.forward(request, response);
			try {
				ContactDao.searchContact(request.getParameter("params"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("remove")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("accueil.jsp");
			rd.forward(request, response);
			try {
				ContactDao.deleteContact(request.getParameter("number"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("new")) {
			String nom = request.getParameter("firstname");
			String prenom = request.getParameter("lastname");
			String adresse = request.getParameter("adresse");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			Contacts contact = new Contacts();
			contact.setFirst_name(nom);
			contact.setLast_name(prenom);
			contact.setAdresse(adresse);
			contact.setEmail(email);
			contact.setPhone(phone);
			try {
				ContactDao.registerContact(contact);
				this.getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			}
		}
		
		if(action.equals("edit")) {
			
			String nom = request.getParameter("firstname");
			String prenom = request.getParameter("lastname");
			String adresse = request.getParameter("adresse");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			Contacts contact = new Contacts();
			contact.setFirst_name(nom);
			contact.setLast_name(prenom);
			contact.setAdresse(adresse);
			contact.setEmail(email);
			contact.setPhone(phone);
			try {
				ContactDao.updateContact(contact);
				this.getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			}
		}
	}

}
