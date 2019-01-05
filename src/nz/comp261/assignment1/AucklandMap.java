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
	double minLatitude;
	double minLongitude;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AucklandMap();
	}
	
	
	
	public AucklandMap() {
		this.graph = new Graph("data/test/roadDataTest.tab", 
							  "data/test/nodeTest.tab", 
							  "data/test/roadSegTest.tab"); //test files
		
		calculateBoundingBox(getDrawingAreaDimension());
		
		System.out.println(getDrawingAreaDimension());
		
//		getTextOutputArea().setText(graph.toString());
		getTextOutputArea().setText("Screen Size =" + getDrawingAreaDimension() + "\n" + graph.toString() + "\n" + "Scaling FactorX= " + this.scalingFactorX
									+ "\n" + "Scaling FactorY= " + this.scalingFactorY + "\nLat=" + this.minLatitude + ", Lon=" + this.minLongitude);
	}



	public void calculateBoundingBox(Dimension drawingArea) {
		double locationMax_x = -180;
		double locationMin_x = 180;
		double locationMax_y = -180;
		double locationMin_y = 180;
		
		//from StackOverflow Q# 1066589
		
		//iterate over nodes to find max and min coords
		for (Map.Entry<Integer, Node> node: graph.nodes.entrySet()) {
			double nodeX = node.getValue().coords.x;
			double nodeY = node.getValue().coords.y;
			
			if (nodeX > locationMax_x) {
				locationMax_x = nodeX;
			}
			
			if (nodeX < locationMin_x) {
				locationMin_x = nodeX;
			}
			
			if (nodeY > locationMax_y) {
				locationMax_y = nodeY;
			}
			
			if (nodeX < locationMin_y) {
				locationMin_y = nodeY;
			}
			
		}
		
		this.minLongitude = locationMin_x;
		this.minLatitude = locationMin_y;
		
		this.scalingFactorX = drawingArea.width / (locationMax_x - locationMin_x);
		this.scalingFactorY = drawingArea.height / (locationMax_y - locationMin_y);
		
	}

	@Override
	protected void redraw(Graphics g) {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer, Node> node: graph.nodes.entrySet()) {
			node.getValue().draw(g);
//			node.getValue().draw(g, this.scalingFactorX, this.scalingFactorY, this.minLatitude, this.minLongitude);
			System.out.println(node.getValue().x);
			System.out.println(node.getValue().y);
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
