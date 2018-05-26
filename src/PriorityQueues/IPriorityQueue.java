package PriorityQueues;

public interface IPriorityQueue<T> {
   void enqueue(T obj, myPriority P);
   T dequeue();
   T peak();
   myPriority peakPriority();
   boolean isEmpty();
   boolean HigherPriority(myPriority P1, myPriority P2);
   void changePriority(T obj, myPriority P);
   void clear();
}
