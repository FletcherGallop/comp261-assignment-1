package nz.comp261.assignment1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Collection;
import java.util.Map;

public class AucklandMap extends GUI {
	Graph graph;
	double scalingFactorX;
	double scalingFactorY;
	double globalScalingFactor;
	double minLatitude;
	double minLongitude;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AucklandMap();
	}
	
	
	
	public AucklandMap() {
//		this.graph = new Graph("data/test/roadDataTest.tab", 
//							  "data/test/nodeTest.tab", 
//							  "data/test/roadSegTest.tab"); //test files
		this.graph = new Graph("data/large/roadID-roadInfo.tab", 
				  "data/large/nodeID-lat-lon.tab", 
				  "data/large/roadSeg-roadID-length-nodeID-nodeID-coords.tab"); //full files
		
		calculateBoundingBox(getDrawingAreaDimension());
		
		System.out.println(getDrawingAreaDimension());
		
//		getTextOutputArea().setText(graph.toString());
		getTextOutputArea().setText("Screen Size =" + getDrawingAreaDimension() + "\n" + graph.toString() + "\n" + "Scaling FactorX= " + this.scalingFactorX
									+ "\n" + "Scaling FactorY= " + this.scalingFactorY + "\nLat=" + this.minLatitude + ", Lon=" + this.minLongitude);
	}



	public void calculateBoundingBox(Dimension drawingArea) {
		double maxLat = 0;
		double minLat = 0;
		double maxLon = 0;
		double minLon = 0;
		
		//from StackOverflow Q# 1066589
		
		//iterate over nodes to find max and min coords
		for (Map.Entry<Integer, Node> node: graph.nodes.entrySet()) {
			double nodeLon = node.getValue().coords.x;
			double nodeLat = node.getValue().coords.y;
			
			if (maxLat == 0) {
				maxLat = nodeLat;
				minLat = nodeLat;
				maxLon = nodeLon;
				minLon = nodeLon;
			}
			
			else if (maxLat != 0) {
				if (maxLat < nodeLat) {
					maxLat = nodeLat;
				}
				if (minLat > nodeLat) {
					minLat = nodeLat;
				}
				if (maxLon < nodeLon) {
					maxLon = nodeLon;
				}
				if (minLon > nodeLon) {
					minLon = nodeLon;
				}
			}
			
		}
		
		this.minLongitude = minLon;
		this.minLatitude = minLat;
		
		this.scalingFactorX = drawingArea.width / (maxLon - minLon);
		this.scalingFactorY = drawingArea.height / (maxLat - minLat);
		this.globalScalingFactor = Math.min(scalingFactorX, scalingFactorY);
		
		System.out.println("Lat=" + minLat + "-" + maxLat + ", Lon=" + minLon + "-" + maxLon);
	}

	@Override
	protected void redraw(Graphics g) {
		for (Map.Entry<Integer, Node> node: graph.nodes.entrySet()) {
//			node.getValue().draw(g);
			node.getValue().draw(g, getDrawingAreaDimension(), this.globalScalingFactor, this.minLatitude, this.minLongitude);
//			System.out.println(node.getValue().mapPoint);
//			System.out.println(node.getValue().y);
			
			
			
		}
		
		for (Map.Entry<Integer, Node> node: graph.nodes.entrySet()) {
			for (Segment segment : node.getValue().outSegments) {
				segment.draw(g, node.getValue().scaledPoint, graph.nodes.get(segment.nodeId2).scaledPoint);
			}
			for (Segment segment : node.getValue().inSegments) {
				segment.draw(g, node.getValue().scaledPoint, graph.nodes.get(segment.nodeId2).scaledPoint);
			}
		}
		
	}


	@Override
	protected void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onSearch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onMove(Move m) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void onLoad(File nodes, File roads, File segments, File polygons) {
		// TODO
		
	}
	
	

}
