package NodeOwn;

import java.util.ArrayList;

public class FinalTree {
	
	
	Node rootNode;
	
	FinalTree(){
		this.createNode();
	}
	public void getArray(ArrayList<Employee> getArrayList){
		Employee empmodel=new Employee();
		NodeDao nodeDao=new NodeDao();
		ArrayList<Employee> getEmployeeList=new ArrayList<>();
		nodeDao.connection(empmodel,getEmployeeList);
		
		getArrayList.addAll(getEmployeeList);
	
	}
	
	public Node createNode() {
		
		ArrayList<Employee> setArrayList=new ArrayList<Employee>();
		getArray(setArrayList);
		
		Node newNode=new Node();
		for(Employee e:setArrayList) {
			int parent=e.getId();
			int current=e.getReportingto();
			
			
			
			

			if(current==0) {
				
				rootNode=new Node(parent,current);
				
				getNode(rootNode, setArrayList, parent);
//				return rootNode;
				
				
				
			}
			
			
//			
//			else {
//			newNode=new Node(parent,current);
//			
//			ArrayList<Node> children= new ArrayList<>();
//			newNode.setChild(children);
//			for(Employee e2:setArrayList)
//			{
//				
//				
//				
//				
//				int report= e2.getReportingto();
//				int parent2=e2.getId();
//				
//				if(parent==report) {
//					Node currentNode=new Node(parent2,report);
//					newNode.getChild().add(currentNode);
//				}
//				
//				
//			}
//		
//			
//			
//			Node parentNode= new Node();
//			Node currentNode=new Node();
//			currentNode.setParent(parent);
//			currentNode.setCurrent(current);
			
			
//			addNode(currentNode);
			
			
//			currentNode.getChild().add(currentNode);
			
//			System.out.println("Employeeid :" +e.getId()+" reportto :"+e.getReportingto());
//			return newNode;
//			}
			}
		return newNode;
		
	}
	
	
	public Node getNode(Node node,ArrayList<Employee> setArrayList,int parent) {
		ArrayList<Node> childrens=new ArrayList<Node>();
		node.setChild(childrens);
		{
			for(Employee e2:setArrayList)
			{
				
				int report= e2.getReportingto();
				int parent2=e2.getId();
				
				
				
				if(parent==report) {
					
					Node currentNode=new Node(parent2,report);
					node.getChild().add(currentNode);
					for(Node Child:node.getChild()) {
						getNode(Child, setArrayList, Child.getParent());
						
					}
					
				}
			}
		}
		
		return node;
		
		
		
	}
	
	
	public void display()
	{
		display(rootNode);
	}
	public void display(Node node)
	{
		
		String str=node.getParent()+" => ";
		
		for(Node child:node.getChild())
		{
			str+=child.getParent() +" ";
		}
		System.out.println(str);
		
		
		for(Node child:node.getChild())
		{
			
			{
			display(child);
			}
			
		}
	
	}
	

	public static void main(String[] args) {
		
		FinalTree finalTree=new FinalTree();
//		finalTree.getArray();
		
		finalTree.display();
	}

}
