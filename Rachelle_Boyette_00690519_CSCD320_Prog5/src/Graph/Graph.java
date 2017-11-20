package Graph;

import SingleLinkedList.LinkedList;

/**
 * Created by RBoyette on 6/4/2017.
 */
public class Graph {

    private int vertices;
    private LinkedList adjacencyList[];

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList ();
        }
    }

    public void addEdge(int vertex, int edge, int weight){
        adjacencyList[vertex].add (edge, weight);
    }

    public int getVertices(){
        return vertices;
    }

    public LinkedList getAdjacencyList(int i){
        return adjacencyList[i];
    }

   /* public void DFS(){
        boolean[] visited = new boolean[vertices];

        graphDFS (0, visited);
    }

    private void graphDFS ( int startingPoint, boolean[] visited ) {
        visited[startingPoint] = true;

        System.out.print (startingPoint + " ");

        LinkedList list = adjacencyList[startingPoint];
        for(int i = 0; i < list.getSize (); i++){
            int next = list.get (i);
            if(visited[next] != true){
                graphDFS (next, visited);
            }
        }
    }*/
}
