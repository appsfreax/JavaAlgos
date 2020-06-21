package models;
/*
 * Node with Hd: This is used for vertical traversing in Tree
 */
public class NodeWithHd {
	
	
	private BinaryNode node; 
    private int hd; 

    public NodeWithHd(BinaryNode node, int hd) { 
        this.node = node; 
        this.hd = hd; 
    } 

	public BinaryNode getNode() {
		return node;
	}

	public void setNode(BinaryNode node) {
		this.node = node;
	}

	
	public int getHd() {
		return hd;
	}
	
	public void setHd(int hd) {
		this.hd = hd;
	}

}
