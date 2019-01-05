package nz.comp261.assignment1;

import java.util.ArrayList;

public class Road {
	int id;
    int type;
    String label;
    String city;
    boolean oneway;
    int speed;
    int roadclass;
    boolean notforcar;
    boolean notforpede;
    boolean notforbicy;
    ArrayList<Segment> segments = new ArrayList<Segment>();
	
    public Road(int id, int type, String label, String city, boolean oneway, int speed, int roadclass, boolean notforcar, boolean notforpede, boolean notforbicy) {
		this.id = id;
		this.type = type;
		this.label = label;
		this.city = city;
		this.oneway = oneway;
		this.speed = speed;
		this.roadclass = roadclass;
		this.notforcar = notforcar;
		this.notforpede = notforpede;
		this.notforbicy = notforbicy;
	}
    
	@Override
	public String toString() {
		return "Road [id=" + id + ", label=" + label + ", city=" + city + ", segments="+ segments + "]";
	}
	
    public void addSegment(Segment segment) {
    		this.segments.add(segment);
    		
    }
}
