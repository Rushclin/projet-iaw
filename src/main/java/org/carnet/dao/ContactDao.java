package org.carnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.carnet.beans.Contacts;

public class ContactDao {

	public static Statement connexion() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjava-iew", "root", "");
		java.sql.Statement statement = connection.createStatement();
		return statement;
	}

	public static List<Contacts> getContact() throws Exception {
		List<Contacts> listcontacts = new ArrayList<Contacts>();
		ResultSet resultat = null;
		Statement statement = null;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			statement = connexion();
			resultat = statement.executeQuery("SELECT * FROM contact");
			while (resultat.next()) {
				Contacts contact = new Contacts();
				contact.setFirst_name(resultat.getString("first_name"));
				contact.setLast_name(resultat.getString("last_name"));
				contact.setPhone(resultat.getString("phone"));
				contact.setEmail(resultat.getString("email"));
				contact.setAdresse(resultat.getString("adresse"));
				listcontacts.add(contact);
				System.out.println(resultat.getString("first_name"));
			}
			statement.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			connexion().close();
			resultat.close();
			System.out.println("dafffffffffffffffffffffffffffffffffffffffffffersgrwegewasdceafdsd");
		}
		return listcontacts;
	}

	public static int registerContact(Contacts contact) throws Exception {
		ResultSet resultat = null;
		Statement statement = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjava-iew", "root", "");

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO contact(first_name,last_name,email,phone,adresse) VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, contact.getFirst_name());
			preparedStatement.setString(2, contact.getLast_name());
			preparedStatement.setString(3, contact.getEmail());
			preparedStatement.setString(4, contact.getPhone());
			preparedStatement.setString(5, contact.getAdresse());
			preparedStatement.executeUpdate();
			System.out.println("innnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnsert");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}

		return 0;

	}

	public static void deleteContact(String id) throws Exception {
		ResultSet resultat = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjava-iew", "root", "");

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contact WHERE phone= ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {

		}
	}

	public static List<Contacts> searchContact(String id) throws Exception {
		List<Contacts> listcontacts = new ArrayList<Contacts>();
		java.sql.Statement statement = null;
		ResultSet resultat = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjava-iew", "root", "");
		try {
			System.out.println(id);
			String search = "SELECT * FROM contact WHERE first_name=? || last_name=? || email=? || phone =? || adresse=?";
			PreparedStatement preparedStatement = connection.prepareStatement(search);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, id);
			preparedStatement.setString(4, id);
			preparedStatement.setString(5, id);
			resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Contacts contact = new Contacts();
				contact.setFirst_name(resultat.getString("first_name"));
				contact.setLast_name(resultat.getString("last_name"));
				contact.setAdresse(resultat.getString("adresse"));
				contact.setEmail(resultat.getString("email"));
				contact.setPhone(resultat.getString("phone"));
				listcontacts.add(contact);
				System.out.println(resultat.getString("first_name"));
				;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			resultat.close();
			connection.close();
		}

		return listcontacts;

	}

	public static void updateContact(Contacts contact) throws Exception {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		try {

			String update = "UPDATE contact SET first_name = ? ,last_name = ?,email= ?,phone= ?,adresse = ? WHERE phone = ?";
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjava-iew", "root", "");
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, contact.getFirst_name());
			preparedStatement.setString(2, contact.getLast_name());
			preparedStatement.setString(3, contact.getEmail());
			preparedStatement.setString(4, contact.getPhone().trim());
			preparedStatement.setString(5, contact.getAdresse());
			preparedStatement.setString(6, contact.getPhone().trim());
			System.out.println(contact.getAdresse());
			System.out.println("__________________________________________________________________________________________________");
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			connection.close();
		}
	}

}
