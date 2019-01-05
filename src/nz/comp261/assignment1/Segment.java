package nz.comp261.assignment1;

import java.util.ArrayList;

public class Segment {
	//roadID	length	nodeID1	nodeID2	coords
	int roadId;
	float length;
	int nodeId1;
	int nodeId2;
	ArrayList<Location> coords;

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
   
}
