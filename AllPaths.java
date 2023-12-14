package Graphs;
//{All Path} from Source to Target
// Q. For te given src & tar, print all paths that exists from  src=0 to tar=5.
import java.util.*;

public class AllPaths {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
//        implement iterator
        for(int i=0; i <graph.length; i++){
            graph[i]= new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
//    modified graph with the time complexity of O(V)^V

    public static void printAllPath(ArrayList<Edge> graph[], boolean vist[], int curr, String path,int tar){
//        base condition
        if(curr == tar){
            System.out.println(path);
            return;
        }

//        else
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vist[e.dest]){
                vist[curr]= true;
                printAllPath(graph, vist,e.dest,path+e.dest,tar);
                vist[curr]=false;
            }
        }
    }

    public static void main(String args[]){
        int V = 7;

//        1----3
//       /     | \
//      0      |   5---6
//        \    | /
//        2----4
         ArrayList<Edge> graph[] =new ArrayList[V];
         createGraph(graph);

         int src =0, tar=5;
         printAllPath(graph,new boolean[V],src,"0",tar);
    }

}
