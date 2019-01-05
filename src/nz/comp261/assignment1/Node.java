package nz.comp261.assignment1;
import java.util.ArrayList;

public class Node {
 int id;
 Location coords;
 ArrayList<Segment> outSegments = new ArrayList<Segment>();
 ArrayList<Segment> inSegments = new ArrayList<Segment>();
 
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

@Override
public String toString() {
	return "Node [id=" + id + ", coords=" + coords + ", inSegs=" + inSegments + ", outSegs=" + outSegments +"]";
}

}
