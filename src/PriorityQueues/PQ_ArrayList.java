package PriorityQueues;

import java.util.ArrayList;
import javafx.util.Pair;

public class  PQ_ArrayList<T> implements IPriorityQueue<T>{

    //used to test PQ
    public static void main(String[] args) {
        PQ_ArrayList<String> myPq = new PQ_ArrayList<>();
        myPq.enqueue("Mom", new myPriority(5));
        myPq.enqueue("Heather", new myPriority(10));
        myPq.enqueue("Ryan", new myPriority(2));
        myPq.enqueue("Ryan2", new myPriority(2));
        myPq.enqueue("Ryan3", new myPriority(2));
        myPq.enqueue("Brandon", new myPriority(1));
        System.out.println(myPq.dequeue());
        System.out.println(myPq.peak());
    }

    //class fields
    private ArrayList<Pair<T, myPriority>> pq;
    private int size;

    //constructor
    PQ_ArrayList(){
        pq = new ArrayList<>();
        //want to start at index 1 so 0 index should be null
        pq.add(null);
        size = 0;
    }
    // in place swap of two elements
    private void swap(int loc1, int loc2){
        Pair<T, myPriority> temp = pq.get(loc1);
        pq.set(loc1, pq.get(loc2));
        pq.set(loc2, temp);
    }
    //adds element to pqueue
    public void enqueue(T obj, myPriority P) {
        size++;
        // add element at the end of the queue
        Pair<T, myPriority> newPair = new Pair(obj, P);
        pq.add(newPair);
        // initialize parent and child
        int parent = size/2;
        int child = size;
        //while child priority is less than parent prio. swap them
        while(parent > 0 && HigherPriority(pq.get(parent).getValue() , pq.get(child).getValue())){
            swap(parent, child);
            child = parent;
            parent = child/2;
        }
    }
    //removes element from pqueue
    public T dequeue() {
        //check if queue is empty
        T head = peak();
        if (head == null) return null;
        //swap first and last element then erase last element
        swap(1, size);
        Remove(1);
        return head;
    }
    //removes an element from the pq
    private void Remove(int parent){
        //remove last element and decrement size
        pq.remove(size);
        size--;
        //initialize children
        int child1 = parent*2;
        int child2 = child1+1;
        // keep moving parent down while it is lower priority than child
        while(child1 <= size && child2 <= size &&
                (HigherPriority(pq.get(child1).getValue(), pq.get(parent).getValue()) ||
                        HigherPriority(pq.get(child2).getValue(), pq.get(parent).getValue()))){
            if (HigherPriority(pq.get(child1).getValue(), pq.get(child2).getValue())){
                swap(parent, child1);
                parent = child1;
            }else{
                swap(parent, child2);
                parent = child2;
            }
            child1 = parent*2;
            child2 = child1+1;
        }
        // swap child1 and parent if child1 is lower priority than parent
        if (child1 <= size && HigherPriority(pq.get(child1).getValue(), pq.get(parent).getValue())){
            swap(child1,parent);
        }
    }
    // returns the top element of the pq
    public T peak() {
        if (isEmpty()) {
            System.out.println("P-Queue is empty");
            return null;
        }
        return pq.get(1).getKey();
    }
    //returns the priority of the top element
    public myPriority peakPriority() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return pq.get(1).getValue();
    }
    //checks if the pq is empty
    public boolean isEmpty() {
        return (size<1);
    }
    //changes the priority of the given obj
    public void changePriority(T obj, myPriority P) {
        int parent = pq.indexOf(obj);
        T temp = pq.get(parent).getKey();
        swap(parent, size);
        Remove(parent);
        enqueue(temp, P);
    }
    // empties the pq
    public void clear() {
        pq.clear();
        pq.add(null);
        size = 0;
    }
    //compares two Priorities, if the first has higher priority it returns true, else returns false
    public boolean HigherPriority(myPriority P1, myPriority P2) {
        if (P1.Value< P2.Value) return true;
        if (P1.Value > P2.Value) return false;
        return (P1.date.before(P2.date));
    }
}
