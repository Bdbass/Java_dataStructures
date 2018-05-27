package PriorityQueues;


//uses a value and a time stamp to determine priority
public class myPriority {
    public long date;
    public Integer Value;

    myPriority(long d, Integer i){
        date = d;
        Value = i;
    }
    myPriority(Integer i){
        date = System.nanoTime();
        Value = i;
    }
}
