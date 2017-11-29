package DiGraph_A5;

import java.util.*;

public class GNode {
	long Num;
	String Label;
	HashMap<String,Edge> out;
	HashMap<String, Edge> in;
	HashSet<String> dNodes;
	HashMap<String, Long> edgeId;		
	public GNode(long idNum, String label){
		Num = idNum;
		Label = label;
		out = new HashMap<String, Edge>();
		in = new HashMap<String, Edge>();
		dNodes = new HashSet<String>();
		edgeId = new HashMap<String, Long>();
	}
	public String getLabel(){
		return Label;
	}
	public long getNum(){
		return Num;
	}
	public HashMap<String,Edge> getOutEdges(){
		return out;
	}
	public HashSet<String> getDest(){
		return dNodes;
	}
	public void addDest(String a){
		dNodes.add(a);
	}
	public void addOutEdge(String dLabel, Edge a){
		out.put(dLabel, a);
	}
	public void addInEdge(String sLabel, Edge a){
		in.put(sLabel, a);
	}
	public void remDest(String a){
		dNodes.remove(a);
	}
	public Long retreiveEdgeId(String dLabel){
		return edgeId.get(dLabel);
	}
	public void addEdgeId(String dLabel, Long num){
		edgeId.put(dLabel, num);
	}
	public void remOutEdge(String dLabel){
		out.remove(dLabel);
	}
	public void remInEdge(String sLabel){
		in.remove(sLabel);
	}
	
}
