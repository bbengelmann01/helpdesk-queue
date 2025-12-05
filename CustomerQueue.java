//LOOK FURTHER BELOW for INTLINKEDQUEUE class

class IntLinkedNode //internal class for Linked nodes
{
    public CustomerRecord value;
    public IntLinkedNode next;

    public IntLinkedNode(CustomerRecord val)
    {
        this.value = val;
        this.next = null;
    }

    public void setValue(CustomerRecord val)
    {
        this.value = val;
    }
    public CustomerRecord getValue()
    {
        return value;
    }

    public void setNext(IntLinkedNode next)
    {
        this.next = next;
    }

    public IntLinkedNode getNext()
    {
        return next;
    }
}

public class CustomerQueue implements IntQueue {
    private IntLinkedNode head;
    private IntLinkedNode tail;
    int size;

    public CustomerQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(CustomerRecord obj) {
        IntLinkedNode node = new IntLinkedNode(obj);
        if (tail != null) {
            tail.setNext(node);
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    @Override
    public CustomerRecord dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        CustomerRecord val = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    @Override
    public CustomerRecord peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        return head.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString(){
        String str = "[";
        IntLinkedNode temp = head;
        while(temp.getNext() != null) {
            str += temp.getValue() + ", ";
            temp = temp.getNext();
        }
        str += temp.getValue() + "]";
        return str;
    }


}

