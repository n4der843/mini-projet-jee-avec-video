package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
public class dbc{
	public static Connection createConnection()
	{
		Connection con=null;
		String url= "jdbc:mysql://127.0.0.1:3306/crud1";
		String username= "root";
		String password="";
		try
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("OKKKK");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
			System.out.println("OKKKK");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
