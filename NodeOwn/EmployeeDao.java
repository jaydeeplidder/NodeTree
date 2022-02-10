package in.sts.gradleproject.genericemployeetree;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {

	public ArrayList<Employee> getEmployee() {

		ArrayList<Employee> getEmployeeList= new ArrayList<Employee>();
		int id;
		String firstname;
		String lastname;
		String designation;
		int reportingto;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/jaydeep";
			String user="root";
			String pass="root";


			Connection  con=DriverManager.getConnection(url,user,pass);



			String query="Select * from employee";
			PreparedStatement pstmt=con.prepareStatement(query);

			ResultSet rs=pstmt.executeQuery();

			while(rs.next())
			{

				id=rs.getInt("EmployeeID");
				firstname=rs.getString("FirstName");
				lastname=rs.getString("LastName");
				designation=rs.getString("Designation");
				reportingto=rs.getInt("reportingto");
				
				Employee employeeModel=new Employee(id,firstname,lastname,designation,reportingto);
				
				getEmployeeList.add(employeeModel);



				

			}

		

			if(pstmt!=null)
			{
				System.out.println("You Successfully Signed In");
			}
			if(con!=null)
			{
				System.out.println("You Successfully Signed In");
			}
			
			

		}
		catch(SQLException ex)
		{
			System.out.println("Sql Exception please cheack the connectivity or the query");
		}
		catch(Exception e)
		{
			System.out.println(" Exception please cheack the code");
		}
		return getEmployeeList;





	}







}

