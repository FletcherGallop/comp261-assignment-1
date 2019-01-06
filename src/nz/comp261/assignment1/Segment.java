package nz.comp261.assignment1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Segment {
	//roadID	length	nodeID1	nodeID2	coords
	int roadId;
	float length;
	int nodeId1;
	int nodeId2;
	ArrayList<Location> coords;
	Color colour = new Color(0, 255, 0); 
	private Object mapPoint;

    public Segment(int roadId, float length, int nodeId1, int nodeId2, ArrayList<Location> coords) {
		this.roadId = roadId;
		this.length = length;
		this.nodeId1 = nodeId1;
		this.nodeId2 = nodeId2;
		this.coords = coords;
	}

	@Override
	public String toString() {
		return "Segment [roadId=" + roadId + ", nodeId1=" + nodeId1 + ", nodeId2=" + nodeId2 + ", coords=" + coords
				+ "]";
	}
	
//	public void draw(Graphics g, Dimension dimension, double scalingFactor, double minLat, double minLon) {
//		Location mapOrigin = new Location(minLon, minLat);
////		this.mapPoint = coords.asPoint(mapOrigin, scalingFactor);
//		ArrayList<Point> points = new ArrayList<Point>();
//		
////		Point point1 = coords.get(i).asPoint(mapOrigin, scalingFactor);
////		Point point2 = coords.get(i++).asPoint(mapOrigin, scalingFactor);
////		g.drawLine(point1.x, point1.y, point2.x, point2.y);
//		
////		dimension.width - mapPoint.x, 0 - mapPoint.y
//		
//		
//		for (Location coord : coords) {
//			System.out.println(coord);
//			System.out.println(coord.asPoint(mapOrigin, scalingFactor));
//			points.add(coord.asPoint(mapOrigin, scalingFactor));
//		}
//		
//		
//		g.setColor(colour);
////		g.drawLine(); 
////		g.drawLine(0, 0, 100, 100);
//		
//		
////		System.out.println(points);
//		
////		for (Location coord : coords) {
////			
////			
////		}
//	}

	public void draw(Graphics g, Point mapPoint1, Point mapPoint2) {
		g.setColor(colour);
		g.drawLine(mapPoint1.x, mapPoint1.y, mapPoint2.x, mapPoint2.y);
		
		System.out.println("Lines:" + mapPoint1.toString() + mapPoint2.toString());
		
	}
   
}
