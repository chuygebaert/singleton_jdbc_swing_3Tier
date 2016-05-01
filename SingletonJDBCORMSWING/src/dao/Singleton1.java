package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton1 {
	private static Connection connexion;

	static { // chargt class en memoire init ici ->static!
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue", "root", "");
			System.out.printf("creation connexion ok"); // pour le test
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static Connection getCo() {
		return connexion;
	}
}
