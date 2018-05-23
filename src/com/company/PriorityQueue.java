package com.company;

public interface PriorityQueue<T> {
   void enqueue(T obj, int priority);
   T dequeue();
   T peak();
   int peakPriority();
   boolean isEmpty();
   String toString();
   void changePriority(T obj, int value);
   void clear();
}
