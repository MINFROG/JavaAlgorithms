package linkedList;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 线程安全列表实现
 *
 * @author: Shawn Yu
 * @Date: 2018-8-31 14:11
 */
public class ConcurrentLink<T> {

    private volatile int size;

    private volatile  Node<T> head;

    private volatile  Node<T> tail;

    private Lock lock = new ReentrantLock();

    public void add(T data){

        lock.lock();

/*      Node<T> l = tail;
        Node<T> newNode = new Node<T>(data,l,null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;*/


        try {
            Node<T> l = tail;
            Node<T> newNode = new Node<T>(data,l,null);
            tail = newNode;
            if( null == head){
                //空链表
                this.head = newNode ;
            }else{
                //非空链表
                l.next = newNode;
            }

            size++;

        } finally {

            lock.unlock();//释放锁
        }


    }


    public void  display(){

        Node<T> displayNode = head;

        while(true){
            if(null != displayNode){
                System.out.println(displayNode.getData());
                displayNode = displayNode.next;
                continue;
            }
            return;
        }

    }


    /**
     * Node节点
     * @param <T>
     */
    class Node<T>{

        private volatile T data;
        private volatile Node<T> prev;
        private volatile Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }


    public static void main(String[] args) {

        ConcurrentLink<Object> concurrentLink = new ConcurrentLink<>();
        concurrentLink.add("111");
        concurrentLink.add("222");
        concurrentLink.add("333");
        concurrentLink.add("444");
        concurrentLink.add("555");
        concurrentLink.add("666");
        concurrentLink.display();
    }


}
