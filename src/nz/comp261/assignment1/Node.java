package nz.comp261.assignment1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class Node {
 public int id;
 public Location coords;
 public ArrayList<Segment> outSegments = new ArrayList<Segment>();
 public ArrayList<Segment> inSegments = new ArrayList<Segment>();
 
 //For GUI
 private static final int NODE_SIZE = 10; //for draw method
 public double x, y;
 public Color colour = new Color(0, 0, 255); //Blue

 
 public Node(int id, Location coords) {
	this.id = id;
	this.coords = coords;
 }

public ArrayList<Segment> getOutSegments() {
	return outSegments;
}

public void addOutSegment(Segment outSegment) {
	this.outSegments.add(outSegment);
}

public ArrayList<Segment> getInSegments() {
	return inSegments;
}

public void addInSegment(Segment inSegment) {
	this.inSegments.add(inSegment);
}

public void draw(Graphics g, double scalingFactorX, double scalingFactorY, double minLat, double minLon) {
	this.x = (this.coords.x - minLon) * scalingFactorX;
	this.y = (this.coords.y - minLat) * scalingFactorY;
	
	g.setColor(colour); 
	g.fillOval((int) this.x, (int) this.y, NODE_SIZE, NODE_SIZE);
	
}

public void draw(Graphics g) {
	
	g.setColor(colour); 
	g.fillOval((int) this.x, (int) this.y, NODE_SIZE, NODE_SIZE);
	
}

@Override
public String toString() {
	return "Node [id=" + id + ", coords=" + coords + ", inSegs=" + inSegments + ", outSegs=" + outSegments +"]";
}

}
