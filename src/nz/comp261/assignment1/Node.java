package nz.comp261.assignment1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Node {
 public int id;
 public Location coords;
 public ArrayList<Segment> outSegments = new ArrayList<Segment>();
 public ArrayList<Segment> inSegments = new ArrayList<Segment>();
 
 //For GUI
 private static final int NODE_SIZE = 5; //for draw method
// public double x, y;
 public Point mapPoint;
 public Point scaledPoint = new Point();
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

public void draw(Graphics g, Dimension dimension, double scalingFactor, double minLat, double minLon) {
//	this.x = (this.coords.x - minLon) * scalingFactor; //
//	this.y = (this.coords.y - minLat) * scalingFactor;
	
	Location mapOrigin = new Location(minLon, minLat);
	this.mapPoint = coords.asPoint(mapOrigin, scalingFactor); //scalingFactor
	
	this.scaledPoint.x = dimension.width - mapPoint.x;
	this.scaledPoint.y = dimension.height - (0 - mapPoint.y) ;
	
//	int adjustedX = (int) (widthPadding + (point.getX() * globalRatio));

    // need to invert the Y since 0,0 starts at top left
//    int adjustedY = (int) (IMAGE_HEIGHT_IN_PX - heightPadding - (point.getY() * globalRatio));
	
//	Location mapOrigin = new Location(minLon, minLat);
//	//windowSize /(maxLocation - minLocation)
//	double scalingFactor = Math.min(scalingFactorY, scalingFactorX);
////	Point mapPoint = coords.asPoint(mapOrigin, scalingFactor);
//	System.out.println("MapPoint: " + mapPoint);
//	System.out.println(dimension.width - mapPoint.x);
//	System.out.println(0 - mapPoint.y);
////	
//	
//	g.setColor(colour); 
//	g.fillOval(mapPoint.x, mapPoint.y, NODE_SIZE, NODE_SIZE);
	
	g.setColor(colour);
	g.fillOval(scaledPoint.x, scaledPoint.y, NODE_SIZE, NODE_SIZE);
	
}

@Override
public String toString() {
	return "Node [id=" + id + ", coords=" + coords + ", inSegs=" + inSegments + ", outSegs=" + outSegments +"]";
}

}
