package DiGraph_A5;

public class Edge {
	long Num;
	String s_Label;
	String d_label;
	long weights;
	String e_Label;
	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel){
		Num = idNum;
		s_Label = sLabel;
		d_label = dLabel;
		weights = weight;
		e_Label = eLabel;
	}
	public long getId(){
		return Num;
	}
	
}
