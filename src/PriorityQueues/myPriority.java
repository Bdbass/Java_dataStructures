package PriorityQueues;
import java.util.Date;

//uses a value and a time stamp to determine priority
public class myPriority {
    public Date date;
    public Integer Value;

    myPriority(Date d, Integer i){
        date = d;
        Value = i;
    }
    myPriority(Integer i){
        date = new Date();
        Value = i;
    }
}
