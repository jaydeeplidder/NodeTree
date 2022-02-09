package NodeOwn;


public class Employee {

	private int id;
	private String firstname;
	private String lastname;
	private String designation;
	private int reportingto;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getReportingto() {
		return reportingto;
	}
	public void setReportingto(int reportingto) {
		this.reportingto = reportingto;
	}


	public Employee(int id, String firstname, String lastname, String designation, int reportingto) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.designation = designation;
		this.reportingto = reportingto;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
}
