/**
 * Created by RBoyette on 5/15/2017. Rachelle Boyette
 */
public class MinHeap {

    private int size;

    public int getSize(){
        return size;
    }

    public MinHeap(){
        size = 0;
    }

    public void buildMinHeap(int [] array){
        size = array.length - 1;

        for(int i = size / 2; i >= 1; i--){
            minHeapify(array, i);
        }
    }

    public int extractMin(int[] array){
        if(size <= 0){
            return Integer.MAX_VALUE;
        }
        if(size == 1){
            size--;
            return array[0];
        }
        else{
            int min = array[0];
            array[0] = array[size - 1];
            size--;
            minHeapify (array, 0);
            return min;
        }
    }

    public void minHeapify ( int[] array, int i ) {
        int minimum;
        if(leftChild (i) <= size && array[leftChild (i)] < array[i]){
            minimum = leftChild (i);
        }

        else{
            minimum = i;
        }

        if(rightChild (i) <= size && array[rightChild (i)] < array[minimum]){
            minimum = rightChild (i);
        }

        if(minimum != i){
            swap(array, i, minimum);
            minHeapify (array, minimum);
        }
    }

    public void heapSort(int [] array){
        buildMinHeap (array);

        for(int i = size; i >= 2; i--){
            swap(array, 1, i);
            size--;
            minHeapify (array, 1);
        }
    }

    public void swap ( int[] array, int i, int j ) {
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    private int leftChild(int i){
        return i * 2;
    }

    private int rightChild(int i){
        return i * 2 + 1;
    }

    private int parent(int i){
        return i / 2;
    }

}
