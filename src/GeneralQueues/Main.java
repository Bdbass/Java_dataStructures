package GeneralQueues;

public class Main {

    //Used to test the circular queue
    public static void main(String[] args) {
	    CircularQueue q1 = new CircularQueue(10);
	    ICharQ iQ;
	    iQ = q1;

	    // fill up queue
	    for (int i = 0; i < 10; i++){
	        iQ.push((char) ('A'+i));
        }
        // check to make sure its full
        iQ.push('W');

	    // make sure peak works
	    System.out.println("Peak:" + iQ.peak());

	    //remove a couple from the queue
        for (int j = 0; j < 3; j++){
            System.out.println("Removed: " + iQ.pop());
        }

        // add a couple more back in
        for (int k = 0; k < 3; k++){
            iQ.push((char) ('a'+k));
        }

        System.out.println("Printing all queue contents");
        // print out all contents of the queue
        for (int i = 0; i < 10; i++){
            System.out.println(iQ.pop());
        }

        // showing that it is empty
        System.out.println(iQ.pop());
    }

}
