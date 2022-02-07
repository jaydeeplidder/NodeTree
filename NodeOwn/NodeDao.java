package NodeOwn;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NodeDao {

	public void connection(Employee employeemodel,ArrayList<Employee> getArray) {

		int root=0;
		int id;
		String firstname;
		String lastname;
		String designation;
		int reportingto;


		ArrayList<Employee> employeeList=new ArrayList<>();


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
				
				employeemodel.setId(rs.getInt("EmployeeID"));
				employeemodel.setFirstname(rs.getString("FirstName"));
				employeemodel.setLastname(rs.getString("LastName"));
				employeemodel.setDesignation(rs.getString("Designation"));
				employeemodel.setReportingto(rs.getInt("reportingto"));
				id=employeemodel.getId();
				firstname=employeemodel.getFirstname();
				lastname=employeemodel.getLastname();
				designation=employeemodel.getDesignation();
				reportingto=employeemodel.getReportingto();
				Employee employeemodel1=new Employee(id,firstname,lastname,designation,reportingto);
				employeeList.add(employeemodel1);

				employeemodel.setEmployee(employeeList);;
				
				
				
			}
			
			getArray.addAll(employeeList);

//			for(Employee e:employeemodel.getEmployee())
//			{
//				
//				
//				System.out.println(e.getId()+" "+e.getFirstname()+" "+e.getLastname()+" "+e.getDesignation()+" "+e.getReportingto());
//			}
//
//			System.out.println(employeemodel.getEmployee().get(0).getId());
//
//			for(int i=0;i<employeeList.size();i++)
//			{
//				for(int j=0;j<employeeList.size();j++)
//				{
//					
//					if(employeeList.get(i).getReportingto() == employeeList.get(j).getId())
//					{
//						
//						
//						System.out.println("Parent == "+employeeList.get(j).getFirstname()+" parentid= "+employeeList.get(j).getId()+" child is "+employeeList.get(i).getFirstname()+" id "+employeeList.get(i).getId());
//					}
//					else if(employeeList.get(i).getReportingto()== root && employeeList.get(j).getReportingto()== root)
//					{
//						System.out.println("Root node :---"+employeeList.get(i).getFirstname());
//					}
//					
//					 
//				}
//				if(employeeList.get(i).getReportingto() == 0){
//					
//					System.out.println("Root node :---"+employeeList.get(i).getFirstname());
//				}
			

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





	}







}

