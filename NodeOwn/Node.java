package NodeOwn;

import java.util.ArrayList;

public class Node {



	public Node() {
		super();
	}
	private Integer parent;
	private Integer current;
	private ArrayList<Node> child;
	
	
	protected Integer getParent() {
		return parent;
	}
	protected void setParent(Integer parent) {
		this.parent = parent;
	}
	protected Integer getCurrent() {
		return current;
	}
	protected void setCurrent(Integer current) {
		this.current = current;
	}
	protected ArrayList<Node> getChild() {
		return child;
	}
	protected void setChild(ArrayList<Node> child) {
		this.child = child;
	}
	
	public Node(Integer parent, Integer current) {

		this.parent = parent;
		this.current = current;
		
	}
	
	
	



}
