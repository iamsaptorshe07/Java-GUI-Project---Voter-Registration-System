package voter_regestration_system;
import java.sql.*;
import javax.swing.*;
public class SQLiteConnection 
{
	 Connection conn = null;
	   public static Connection dbconnector()
	   {
		   try {
			   Class.forName("org.sqlite.JDBC");
			   Connection conn=DriverManager.getConnection("jdbc:sqlite:G:\\Projects\\Java Projects\\voter_regestration_system\\database\\maindata.db");
			   return conn;
		   }
		   catch(Exception e){
	         JOptionPane.showMessageDialog(null, e);
	         return null;
		   }
	   }
}
