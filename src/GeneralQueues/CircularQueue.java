package GeneralQueues;

class CircularQueue implements ICharQ {

    private char q[];
    private int tail, head, size;
    private boolean start;

    //construct queue given size
    CircularQueue(int _size){
        q = new char[_size+1];
        head = tail = 0;
        size = _size+1;
    }

    // add character to queue
    public void push(char c){
        // means the queue is full
        if (head == (tail+1)%size){
            System.out.println("Queue is full!");
            return;
        }
        // fill tail, then increment
        q[tail] = c;
        tail = (++tail)%size;
    }

    //returns the element at the top of the queue
    public char peak(){
        if (head == tail){
            System.out.println("Queue is empty!");
            return (char) 0;
        }
        return q[head];
    }

    //returns the element at the top of the queue and deletes it
    public char pop(){
        if (head == tail){
            System.out.println("Queue is empty!");
            return (char) 0;
        }
        char temp = q[head];
        head = (++head)%size;
        return temp;
    }
}

