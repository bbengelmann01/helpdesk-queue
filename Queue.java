public interface Queue<E>
{
    public void enqueue(E obj); //add obj to rear of Queue
    public E dequeue( ); //returns item from front of queue and then removes from front of queue
    public E peekFront( ); //return the front item in the queue and leave the queue intact
    public int size( ); //returns the size (depth) of the queue
    public boolean isEmpty(); // return true if Queue is empty
    public void clear(); //clears all elements from the Queue.  Results in an empty queue.
    public String toString(); //return String similar to: "front ->[x, x, x, x] <- rear"


}
