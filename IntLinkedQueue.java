//LOOK FURTHER BELOW for INTLINKEDQUEUE class

class IntLinkedNode //internal class for Linked nodes
{
    public Integer value;
    public IntLinkedNode next;

    public IntLinkedNode(int val)
    {
        this.value = val;
        this.next = null;
    }

    public void setValue(int val)
    {
        this.value = val;
    }
    public Integer getValue()
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

public class IntLinkedQueue implements IntQueue {
    private IntLinkedNode head;
    private IntLinkedNode tail;
    int size;

    public IntLinkedQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(Integer obj) {
        IntLinkedNode node = new IntLinkedNode(obj);
        if (tail != null) {
            tail.setNext(node)
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        int val = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    @Override
    public Integer peekFront() {
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

