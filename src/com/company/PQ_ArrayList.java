package com.company;

import java.util.ArrayList;
import javafx.util.Pair;

public class PQ_ArrayList<T> implements PriorityQueue{
    ArrayList<Pair<T, Integer>> pq;
    int size;
    //constructor
    PQ_ArrayList(){
        pq = new ArrayList<>();
        //want to start at index 1 so 0 index should be null
        pq.add(null);
        size = 0;
    }
    // in place swap of two elements
    public void swap(int loc1, int loc2){
        Pair<T, Integer> temp = pq.get(loc1);
        pq.set(loc1, pq.get(loc2));
        pq.set(loc2, temp);
    }
    //adds element to pqueue
    public void enqueue(Object obj, int priority) {
        size++;
        // add element at the end of the queue
        Pair newPair = new Pair(obj, priority);
        pq.add(newPair);
        // initialize parent and child
        int parent = size/2;
        int child = size-1;
        //while child priority is less than parent prio. swap them
        while(pq.get(parent).getValue() > pq.get(child).getValue() && parent > 0){
            swap(parent, child);
            child = parent;
            parent = child/2;
        }
    }
    //removes element from pqueue
    public Object dequeue() {
        //check if queue is empty
        Object head = peak();
        if (head == null) return null;
        //swap first and last element then erase last element
        swap(1, size-1);
        pq.remove(size-1);
        size--;
        //initalize parent and children
        int parent = 1;
        int child1 = 2;
        int child2 = 3;
        while(child1 > size-1 && child2 > size-1 &&
                (pq.get(child1).getValue() < pq.get(parent).getValue()) ||
                pq.get(child2).getValue() < pq.get(parent).getValue()){
            if (pq.get(child1).getValue() < pq.get(child2).getValue()){
                swap(parent, child1);
                parent = child1;
            }else{
                swap(parent, child2);
                parent = child2;
            }
            child1 = parent*2;
            child2 = child1+1;
        }
        if (child1 < parent && pq.get(child1).getValue() < pq.get(parent).getValue()){
            swap(child1,parent);
        }
        return head;
    }

    public Object peak() {
        if (isEmpty()) {
            System.out.println("P-Queue is empty");
            return null;
        }
        return pq.get(1);
    }

    public int peakPriority() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return pq.get(1).getValue();
    }

    public boolean isEmpty() {
        return (size<2);
    }

    public void changePriority(Object obj) {
        Object temp = pq.get(pq.indexOf(obj)).getKey();
        dequeue();
    }

    public void clear() {
        pq.clear();
        pq.add(null);
        size = 0;
    }
}
