package nz.comp261.assignment1;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	static ArrayList<Segment> segments;
    static Map<Integer,Road> roads;
    static Map<Integer,Node> nodes;

//    public static void main(String[] args){
//        roads = importRoadData("data/test/roadDataTest.tab");
//        
////        System.out.println(roads.get(13107));
//
//        nodes = importNodeData("data/test/nodeTest.tab");
//        
////        System.out.println(nodes.get(10526).toString());
//        
//        segments = importSegmentData("data/test/roadSegTest.tab");
//
////        System.out.println(segments.get(0).toString());
//
//    }
    
    public Graph(String segFilePath, String roadFilePath, String nodeFilePath) {
//    		roads = importRoadData("data/test/roadDataTest.tab");
//    		nodes = importNodeData("data/test/nodeTest.tab");
//    		segments = importSegmentData("data/test/roadSegTest.tab");
    		roads = importRoadData(segFilePath);
		nodes = importNodeData(roadFilePath);
		segments = importSegmentData(nodeFilePath);
		
	}

    private static ArrayList<Segment> importSegmentData(String segFilePath) {
        //Sourced from Stack overflow Q# 19575308
        try {
//        	"data/roadID-roadInfo.tab"
            BufferedReader buffer = new BufferedReader(new FileReader(segFilePath));
            ArrayList<Segment> segs = new ArrayList<Segment>();
            String lineJustFetched = null;
            String[] segData;

            lineJustFetched = buffer.readLine(); //skip headers
            while(true){
                lineJustFetched = buffer.readLine();
                if (lineJustFetched == null) {
                    break;
                } else if (lineJustFetched.startsWith("roadid")){
                    continue;
                } else {
                    segData = lineJustFetched.split("\t");
                     
                    ArrayList<Location> coords = new ArrayList<Location>();
                                        
                    for (int i = 4; i<segData.length; i++) { //get all coords
//                    		coords.add(Float.parseFloat(roadData[i]));
                    		Location fromLatLon = Location.newFromLatLon(Double.parseDouble(segData[i]),Double.parseDouble(segData[i+1]));
                    		coords.add(fromLatLon);
                    		i++;
                    }
                    
                    int roadId = Integer.parseInt(segData[0]);
                    int nodeId1 = Integer.parseInt(segData[2]);
                    int nodeId2 = Integer.parseInt(segData[3]);
                    
                    Segment segment = new Segment(roadId,
						    						Float.parseFloat(segData[1]),
						    						nodeId1,
						    						nodeId2,
						    						coords);
                    
                    segs.add(segment);
                    
                    if (roads.containsKey(roadId)) {
                    		Road road = roads.get(roadId);
                    		
//                    		System.out.println("before: " + road);
                    		
                    		road.addSegment(segment);
                    		
//                    		System.out.println("after:" + road);
                    		
                    		roads.put(roadId, road);
                    }
                    
                    if (nodes.containsKey(nodeId1)) {
	                		Node node = nodes.get(nodeId1);
	                		
//	                		System.out.println("before: " + node);
	                		
	                		node.addOutSegment(segment);
	                		
//	                		System.out.println("after:" + node);
	                		
	                		nodes.put(nodeId1, node);
                    }
                    
                    if (nodes.containsKey(nodeId2)) {
                		Node node = nodes.get(nodeId2);
                		
//                		System.out.println("before: " + node);
                		
                		node.addInSegment(segment);
                		
//                		System.out.println("after:" + node);
                		
                		nodes.put(nodeId2, node);
                }
                }

            }
            buffer.close();
            
            return segs;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Map<Integer,Road> importRoadData(String roadFilePath) {
		try {
			//
			BufferedReader buffer = new BufferedReader(new FileReader(roadFilePath));
			Map<Integer, Road> roads = new HashMap<>();
			
			String lineJustFetched = null;
            String[] roadData;

            lineJustFetched = buffer.readLine(); //skip headers
            while(true){
                lineJustFetched = buffer.readLine();
                if (lineJustFetched == null) {
                    break;
                } else if (lineJustFetched.startsWith("roadid")){
                    continue;
                } else {
                    roadData = lineJustFetched.split("\t");
                    
                    Road road;
                                        
                    road = new Road(Integer.parseInt(roadData[0]),
                    					  Integer.parseInt(roadData[1]),
                    					  roadData[2],
                    					  roadData[3],
                    					  Boolean.parseBoolean(roadData[4]),
                    					  Integer.parseInt(roadData[5]),
                    					  Integer.parseInt(roadData[6]),
                    					  Boolean.parseBoolean(roadData[7]),
                    					  Boolean.parseBoolean(roadData[8]),
                    					  Boolean.parseBoolean(roadData[9]));
                    
                    roads.put(Integer.parseInt(roadData[0]), road);
                
                }
                
            }
            
            buffer.close();
			
			return roads;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
    
	private static Map<Integer,Node> importNodeData(String nodeFilePath) {
		try {
			//
			BufferedReader buffer = new BufferedReader(new FileReader(nodeFilePath));
			Map<Integer, Node> nodes = new HashMap<>();
			
			String lineJustFetched = null;
            String[] nodeData;
            
            //no headers
            while(true){
                lineJustFetched = buffer.readLine();
                if (lineJustFetched == null) {
                    break;
                } else if (lineJustFetched.startsWith("roadid")){
                    continue;
                } else {
                    nodeData = lineJustFetched.split("\t");
                    
                    Node node;
                    Location coords = Location.newFromLatLon(Double.parseDouble(nodeData[2]),
                    				   Double.parseDouble(nodeData[1])); //Now in dist
                    
//                    System.out.println(coords);
                    
                    node = new Node(Integer.parseInt(nodeData[0]),
                    				   coords
                    				   );
                    
                    nodes.put(Integer.parseInt(nodeData[0]), node);
                
                }
                
            }
            buffer.close();
            
		    return nodes;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	
	@Override
	public String toString() {
		return "Graph [nodes=[" + nodes.size() + "], roads=[" + roads.size() + "], segments=[" + segments.size() + "]" + "]";
	}

	

}

