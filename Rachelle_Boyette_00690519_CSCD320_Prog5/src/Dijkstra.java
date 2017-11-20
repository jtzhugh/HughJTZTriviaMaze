import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Graph.Graph;
import SingleLinkedList.LinkedList;

/**
 * Created by RBoyette on 6/11/2017.
 */
public class Dijkstra {
    private static int sourceNodeDistance = 0;
    private static final String FILE_PARSER = "((\\d+),(\\d+);?)";
    public static void main(String[]args){

        if(args.length < 1 ){
            System.err.println("Error on input file. Please specify an input file to use this program.");
            System.exit (0);
        }
        int sourceNode = Integer.parseInt (args[1]);

        try( Scanner input = new Scanner (new File (args[0]));
             Scanner graphInput = new Scanner(new File(args[0]))){

            int lines = 0;
            while(input.hasNextLine ()){
                input.nextLine ();
                lines++;
            }

            Graph graph = new Graph(lines);

            while(graphInput.hasNextLine ()){
                String graphVertex = graphInput.nextLine ();
                String[] splitVertexEdges = graphVertex.split (":");
                String vertex = splitVertexEdges[0];

                if(splitVertexEdges.length > 1) {
                    String edgesWithWeights = splitVertexEdges[1];

                    Pattern fileParserPattern = Pattern.compile (FILE_PARSER);
                    Matcher edgeWeight = fileParserPattern.matcher (edgesWithWeights);

                    while(edgeWeight.find ()){
                        String example = edgeWeight.group ();
                        int edge = Integer.parseInt (edgeWeight.group (2));
                        int weight = Integer.parseInt (edgeWeight.group (3));
                        graph.addEdge (Integer.parseInt (vertex), edge, weight);
                    }

                    /*if ( splitEdges != null ) {
                        for ( String edge : splitEdges ) {
                            //graph.addEdge (Integer.parseInt (vertex), Integer.parseInt (edge));
                        }
                    }*/
                }

            }

            dijkstraAlgorithm (graph, sourceNode);

        }catch(FileNotFoundException e){
            e.printStackTrace ();
        }
    }

    private static void dijkstraAlgorithm(Graph graph, int sourceNode){
        int[] distances = new int[graph.getVertices ()];
        int[] parents = new int[graph.getVertices ()];
        boolean[] visited = new boolean[graph.getVertices ()];

        for(int i = 0; i < distances.length; i++){
            distances[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < parents.length; i++){
            parents[i] = -1;
        }

        distances[sourceNode] = 0;

        for(int i = 0; i < distances.length; i++){
            int next = extractMin(distances, visited);
            if(next == -1){
                //means that it's unreachable
                break;
            }
            visited[next] = true;

            LinkedList edges = graph.getAdjacencyList (next);

            for(int j = 0; j < edges.getSize (); j++){
                int edge = edges.get (j).getData ();
                int d = distances[next] + edges.get (j).getWeight ();

                if(distances[edge] > d){
                    distances[edge] = d;
                    parents[edge] = next;
                }
            }
        }

        printPath(parents, distances);



        /*distances[sourceNode] = 0;
        MinHeap qHeap = new MinHeap ();
        qHeap.buildMinHeap (distances);

        while(qHeap.getSize () > 0){
            int u = qHeap.extractMin (distances);
            visited
        }*/


    }

    private static void printPath ( int[] parents, int[] distances ) {
        //distances and parents should be the same length
        for(int i = 0; i < distances.length; i++){
            if(parents[i] != -1){
                if(distances[i] != Integer.MAX_VALUE || distances[i] != 0){
                    System.out.println("[" + i + "]" + " shortest path: (" + parents[i] + ", "  + i + ") shortest distance: " + distances[i] );
                }
            }else{
                if(distances[i] != 0){
                    System.out.println ("[" + i + "] unreachable");
                }


            }
        }
    }

    private static int extractMin ( int[] distances, boolean[] visited ) {
        int d = Integer.MAX_VALUE;
        int y = -1;

        for(int i = 0; i < distances.length; i++){
            if(!visited[i] && distances[i] < d){
                y = i;
                d = distances[i];
            }
        }
        return y;
    }
}
