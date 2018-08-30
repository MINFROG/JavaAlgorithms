package linkedList;
/**
 * @desc LinkedList实现 （非线程安全）
 * 
 * @author yuhuiping
 * @version v1.0 
 * @date 2017年3月23日下午12:24:32
 */
public class Link<T> {

    private int size ;

    private Node<T>  head;

    /**
     * 新增链表节点
     */
     public void add(T data){

         Node<T> newNode = new Node<T>(data);

         if ( null == this.head ) {

             //空链表
            this.head = newNode;

         }else{

             Node<T> node  =  head;
             //非空链表
             while(true){

                 if ( null == node.next){

                     node.next = newNode;

                     size++;

                     return ;

                 }

                 node = node.next;

             }

         }
         size++;
     }

    /**
     * 更新节点
     * @param position 待更新位置
     * @param data 待更新数据
     */
     public void update(int position,T data){

         //check position
         if(position > size) throw new IllegalArgumentException("position is greater than size");

         Node<T> node  =  head;

         for (int i = 0; i < position; i++) {

             node = node.next;
         }

         node.setData(data);

     }


    /**
     * 删除节点
     * @param data
     */
    public void remove(T data){

        //如果要删除的是头节点
        if ( null != head && data.equals(head.getData())){
            head = head.next;
            return;
        }

         Node<T> node = head;

         while (true){

             if( null != node.next && data.equals(node.next.data)){

                 node.next = node.next.next;

                 return;

             }
             node = node.next;

             if ( null == node) return;
         }

     }

     public T get(int position){

         //check position
         if (position > size) throw new IllegalArgumentException("position is greater than size");

         Node<T> node = head;

         for (int i = 0; i < position; i++) {
             node = node.next;
         }

         return node.getData();

     }


     public void disPlay(){

         Node<T> disPlayNode  = head;

         while(true){

             if ( null == disPlayNode) return;

             System.out.println(disPlayNode.getData());

             disPlayNode = disPlayNode.next;

         }
     }


    /**
     * 链表节点
     * @param <T>
     */
    class Node<T>{

        private T data;//数据域

        private Node<T> next;//链域

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Link<String> stringLink = new Link<>();
        stringLink.add("111");
        stringLink.add("222");
        stringLink.add("333");
        stringLink.add("444");
        stringLink.add("555");
        stringLink.add("666");
        stringLink.add("777");
        System.out.println("=========after add===========");
        stringLink.disPlay();
        stringLink.update(6,"gggg");
        System.out.println("=========after update===========");
        stringLink.disPlay();
        stringLink.remove("ggg");
        System.out.println("=========after remove===========");
        stringLink.disPlay();
        System.out.println("=========show get===========");
        System.out.println(stringLink.get(3));

    }

}

