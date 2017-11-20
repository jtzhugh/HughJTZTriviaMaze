package SingleLinkedList;

/**
 * Created by RBoyette on 6/4/2017.
 * Seems ridiculous to rewrite the linkedlist class.
 */
public class LinkedList {

    private int size;
    private Node head;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public void add(int data, int weight){
        if(head == null){
            head = new Node(data, weight, null);
        }
        else{
            Node temp = head;
            while(temp.getNext () != null){
                temp = temp.getNext ();
            }

            temp.setNext (new Node(data, weight, null));

        }
        size++;
    }

    public int getSize(){
        return size;
    }

    public Node get(int position){
        if(position < 0 || position > size){
            throw new IndexOutOfBoundsException ("Invalid position");
        }

        Node temp = head;
        for(int i = 0; i < position; i++){
            temp = temp.getNext ();
        }
        return temp;
    }
}
