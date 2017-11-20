package SingleLinkedList;

/**
 * Created by RBoyette on 6/4/2017.
 */
public class Node {
    private int data;
    private int weight;
    private Node next;

    public Node(){

    }

    public Node(final int data, final int weight, final Node next){
        this.data = data;
        this.weight = weight;
        this.next = next;
    }

    public Node(final int data, final int weight){
        this.data = data;
        this.weight = weight;
        next = null;
    }

    public int getWeight(){
        return weight;
    }

    public int getData(){
        return data;
    }

    public Node getNext(){
        return next;
    }

    public void setData(final int data){
        this.data = data;
    }

    public void setNext(final Node next){
        this.next = next;
    }
}
