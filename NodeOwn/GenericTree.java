package NodeOwn;

import java.util.ArrayList;

//import Practice.GenericTree.Node;

public class GenericTree {
	
	public void display(Node node)
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
	
public static void main(String args[]) {
	
		
		Node a= new Node(null,1);
	

		Node b= new Node(1,2);
	
		Node c= new Node(1,3);
		Node d= new Node(2,4);
		Node e= new Node(3,5);
		
		
//		Node currentNode= new Node();
//		currentNode=a;
		
		ArrayList<Node> child= new ArrayList();
		ArrayList<Node> child2= new ArrayList();
		ArrayList<Node> child3= new ArrayList();
		ArrayList<Node> child4= new ArrayList();
		ArrayList<Node> child5= new ArrayList();
		
		
		
		Node parentNode = new Node(c.getParent());
		Node currentNode = new Node(c.getParent(),c.getCurrent());
	
		parentNode.setChild(child);
		parentNode.getChild().add(currentNode);
		parentNode.getChild().add(b);
		currentNode.setChild(child2);
		currentNode.getChild().add(e);
		b.setChild(child3);
		b.getChild().add(d);
		e.setChild(child4);
		
		d.setChild(child5);
		
		
//		for(Node n:parentNode.getChild()) {
//			System.out.println(parentNode.getCurrent());
//			System.out.print(n.getCurrent()+"=> ");
//			
//			if(n.getChild()!=null)
//			{
//				for(Node n1:n.getChild()) {
//					
//					System.out.println(n1.getCurrent());
//				}
//			}
//		}
		
		GenericTree gt=new GenericTree();
		gt.display(parentNode);
		
	}
	
}
