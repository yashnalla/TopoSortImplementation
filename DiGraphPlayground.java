package DiGraph_A5;



public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      System.out.println(d.delEdge("f", "s")==false);
      d.addNode(1,"f");
      d.addNode(3, "s");
      d.addEdge(0, "f", "s", 0, null);
      System.out.println(d.delEdge("f","s")==true);
      System.out.println(d.delEdge("f","s")==false);
      System.out.println(d.addEdge(0, "f", "s", 0, null)==true);
      System.out.println(d.delEdge("f","s")==true);

      
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }
    

}