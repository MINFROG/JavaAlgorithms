package Tree;

/**
 * @Description: 二叉树结构
 * @author: Shawn Yu
 * @Date: 2018-09-03 10:03
 */
public class Tree<T extends Comparable> {

    private Node<T> root;//根节点




    class Node<T> {

        private T data;
        private Node<T> left;//左节点
        private Node<T> right;//右节点
        private Node<T> parent;//父节点

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    private void add(T data){

        Node<T> newNode = new Node<T>(data);

        //根节点未初始化
        if( null == root) {
            this.root  = newNode;
            return ;
        }

        Node<T> node = root;

        //根节点 初始化
        while(true){
            if( data.compareTo(node.data) == -1 ){

                if(node.left != null){

                    node = node.left;

                }else{

                    node.left = newNode; break;
                }

            }else if(data.compareTo(node.data) == 1 ){

                if(node.right != null ){
                    node = node.right;
                }else{
                    node.right = newNode; break;
                }
            }else{
                System.out.println("非法参数异常"+data);
                return;
            }

        }

    }

    public void display(Node<T>  node){

        Node<T> diaPlayNode = node ;
        System.out.println(node.getData());
        if(diaPlayNode.left != null){
            display(diaPlayNode.left);
        }

        if(diaPlayNode.right != null){
            display(diaPlayNode.right);
        }

    }

    /**
     *                                        30
 *                                        19   |   32
*                                      14    22|31   37
     *                                         |        50
     *
     * @param args
     */

    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<Integer>();
        tree.add(30);
        tree.add(19);
        tree.add(14);
        tree.add(22);
        tree.add(32);
        tree.add(37);
        tree.add(31);
        tree.add(50);


        tree.display(tree.root);
    }


}
