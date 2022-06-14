package application.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PatientDB {
	
	private static String url = "jdbc:mysql://localhost:3306/database56" ;
	private static String user = "root";
	private static String password = System.getenv("motdepasse");
	private static Connection cn=null ;
	public PatientDB() {
	try {
		cn = DriverManager.getConnection(url, user, password);
		System.out.println("connected...");
	} catch (Exception e) {e.printStackTrace();}}
		
	// Récupérer l’instance de la connexion
	public static Connection getConnection() {
	if (cn == null) { new PatientDB(); }
	return cn;
	}
	public static void Fermer() {
	if (cn != null) {
	try { cn.close(); }
	catch (SQLException e) {e.printStackTrace();}}}
	
}
