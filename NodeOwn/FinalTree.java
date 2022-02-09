package NodeOwn;

import java.util.ArrayList;

public class FinalTree {

	/*
	 * Created a rootNode to store all the node reference to inside it
	 */
	
	Node rootNode;

	/*
	 * getEmployeeFromEmployeeDao()
	 * It is a method where it gets all the Employees List from the EmployeeDao
	 * By making Object of EmployeeDao class at calling its getEmployee() method
	 * getEmployee() method has a parameter ArrayList which stores all the Employee details	in it 			
	 */
	public void getEmployeeFromEmployeeDao(ArrayList<Employee> getEmployeeList){
		
		EmployeeDao employeeDao=new EmployeeDao(); 			// Created Object of the EmployeeDao
		
		employeeDao.getEmployee(getEmployeeList);			 //call the method of the EmployeeDao which give and stores the Employee Details in the ArrayList


	}
	
	/*
	 *  getRootNode()
	 *  Its is an Node class method that returns the rootNode
	 *  
	 */

	public Node getRootNode() {

		ArrayList<Employee> EmployeeList=new ArrayList<Employee>();
		
		getEmployeeFromEmployeeDao(EmployeeList); //this method stores the details of the  Employee in EmployeeList

	
		
		for(Employee employee:EmployeeList) {
			
			int current=employee.getId();			//current is the employeeId
			int parent=employee.getReportingto();	//parent is the report id which current employee is reportingTo


			/*
			 * if the parent which is the reportingTo of the employee is equalTo 0
			 * it will considered as the rootNode and it will store it in the rootNode
			 */
			
			if(parent==0) {

				rootNode=new Node(parent,current);  //It will store the parent and current value where parent==0 and create a rootNode

				getNodes(rootNode, EmployeeList, rootNode.getCurrent());  /*-> This calls the getNodes()method and passing the value to the parameter
																			-> here rootNode.getCurrent() will be pass the parentId to the method
																			-> this will be the start of the getNode() method*/
						


			}


		}
		return rootNode;

	}

	
	/*
	 * getNodes()
	 * It get all the node inside that node whenever this method is called
	 * So when we got the rootNode this method was called and it was the start of this method
	 * It performs a  recursion function as per the condition
	 * rootNode has a child node so it check the condition if the child node has another child or not
	 * if it has it will create a newNode it will call the method again and set the child of that node till the end of that child node loop
	 * At the end of all it return ArrayList of node of every node
	 */

	public Node getNodes(Node currentNode,ArrayList<Employee> getEmployeeList,int currentNodeParent) {
		
		ArrayList<Node> childrens=new ArrayList<Node>(); //create a new ArrayList of node for the rootNode first then as per the loop
		
		currentNode.setChild(childrens);   //this will set the currentNode ArrayList               
		{
			for(Employee employee:getEmployeeList)			//first for each loop of the no.of employees in the getEmployeeList
			{

				
				int current=employee.getId();					//it will store employeeId as per loop			
				int parent= employee.getReportingto();			// same for reportingTo


			
				if(currentNodeParent==parent) {					//check if the currentNodeParent==parent for e.g currentNodeParent=[current(employeeId) of the rootNode] and parent=[reportingTo of each employeeList]						

					Node newNode=new Node(parent,current);			// this will create a newNode for every matched condition
					currentNode.getChild().add(newNode);			//this is will add the node to currentNode arrayList

					for(Node Child:currentNode.getChild()) {			//then it will check if the node in the currentNode has a child or not
						
						getNodes(Child, getEmployeeList, Child.getCurrent()); //it will call the method again as a recursion and will set the arrayList for the child node if there is no child it store an empty list

					}

				}
			}
		}

		return currentNode;



	}
	



	public void createTree()     // this is will construct the tree for the class, So create an Object of the current class and call this method in the main class 
	{								// it will start the logic and display the tree in the console
		getRootNode();
		display(rootNode);
	}
	public void display(Node node)               //this is to display the structure in the consoles
	{
		
		
		String str=node.getCurrent()+" => ";     

		for(Node child:node.getChild())
		{
			str+=child.getCurrent() +" ";
		}
		System.out.println(str);


		for(Node child:node.getChild())
		{

			{
				display(child);
			}

		}

	}


}
