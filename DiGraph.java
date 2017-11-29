package DiGraph_A5;

import java.util.*;




public class DiGraph implements DiGraph_Interface {

  private int nodeNum;
  private int edgeNum; 
  private HashMap<String , GNode> fml;
  private HashSet<Long> edgeId;
  private HashSet<Long> nodeId;
// in here go all your data and methods for the graph
  // and the topo sort operation

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	fml = new HashMap<String, GNode>();  
	edgeId = new HashSet<Long>();  
	nodeId = new HashSet<Long>();
	
  }

@Override
public boolean addNode(long idNum, String label) {
	// TODO Auto-generated method stub
	if(fml.containsKey(label) || label == null){
		return false;
	}
	else if(idNum < 0 || nodeId.contains(idNum) ){
		return false;
	}
	fml.put(label, new GNode(idNum, label));
	nodeId.add(idNum);
	nodeNum++;
	return true;
	
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// TODO Auto-generated method stub
 	if(!fml.containsKey(sLabel)|| !fml.containsKey(dLabel)){
		return false;
	}
	else if(edgeId.contains(idNum)){
		return false;
	}
	else if(fml.get(sLabel).getDest().contains(dLabel)){
		return false;
	}
 	Edge e = new Edge(idNum, sLabel, dLabel, weight, eLabel);
 	fml.get(sLabel).addOutEdge(dLabel, e);
 	fml.get(dLabel).addInEdge(sLabel, e);
 	edgeId.add(idNum);
 	fml.get(sLabel).addDest(dLabel);
 	fml.get(sLabel).addEdgeId(dLabel, idNum);
 	edgeNum++;
 	return true;
}

@Override
public boolean delNode(String label) {
	// TODO Auto-generated method stub
	if(!fml.containsKey(label)){
		return false;
	}
	for(String a : fml.get(label).in.keySet()){
		edgeId.remove(fml.get(label).in.get(a).getId());
		fml.get(a).out.remove(label);
	}
	for(String a : fml.get(label).out.keySet()){
		edgeId.remove(fml.get(label).out.get(a).getId());
		fml.get(a).in.remove(label);
	}
	nodeId.remove(fml.get(label).getNum());
	fml.remove(label);
	nodeNum--;
	return true;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	// TODO Auto-generated method stub
	if(fml.get(sLabel) != null){
		if(fml.get(sLabel).getDest().contains(dLabel)== false){
			return false;
			}
			edgeNum --;
			edgeId.remove(fml.get(sLabel).retreiveEdgeId(dLabel));
			
			fml.get(sLabel).remDest(dLabel);
			fml.get(sLabel).remOutEdge(dLabel);
			fml.get(dLabel).remInEdge(sLabel);
			return true;
	}else{
		return false;
	}
	
	
}

@Override
public long numNodes() {
	// TODO Auto-generated method stub
	return nodeNum;
}

@Override
public long numEdges() {
	// TODO Auto-generated method stub
	return edgeNum;
}

@Override
public String[] topoSort() {
	// TODO Auto-generated method stub
	//HashSet <String> visited = new HashSet<>();
	String [] elements = new String[nodeNum];
	Queue<String> qu = new Queue<String>();
	
	int count = 0;
	for(String a : fml.keySet()){
		if(fml.get(a).in.size()==0){
			qu.enqueue(a);
		}
	}
	while(!qu.isEmpty()){
		elements[count] = qu.dequeue();
		
		for(String i : fml.get(elements[count]).out.keySet()){
			if(fml.get(i).in.size() == 1){
				qu.enqueue(i);
			}
		}
		delNode(elements[count]);
		count++;
	}
	if(count != elements.length){
		return null;
	}
	return elements;
	
	
	

}


  
  // rest of your code to implement the various operations
}

