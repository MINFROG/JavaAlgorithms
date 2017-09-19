package stacksAndQueues;

import java.util.Arrays;

/**
 * @desc 模拟栈(FILO)
 * 
 * @author yuhuiping
 * @version v1.0 
 * @date 2017年3月14日下午12:18:45
 */
public class TheStack {
	
	private String[] stackArray;
	
	private int stackSize;//栈大小
	
	private int topofStack = -1;//栈顶初始值
	
	public TheStack(int size){
		this.stackSize = size ;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public static void main(String[] args) {
		TheStack stack = new TheStack(10);
		stack.push("10");
		stack.push("11");
		String peek = stack.peek();
		System.out.println(peek);
		String pop = stack.pop();
		String pop2 = stack.pop();
		System.out.println(pop);
		System.out.println(pop2);
	}
	
	
	/**
	 *	压栈 
	 * @param input
	 */
	public void push(String input){
		if(topofStack +1 < stackSize){
			stackArray[++topofStack] = input;
		}else System.out.println("sorry! but the stack is full");
		
	}
	
	/**
	 * 弹栈
	 * 
	 * @return
	 */
	public String pop(){
		if(topofStack >= 0){
			return stackArray[topofStack--];
		}else {
			System.out.println("sorry! but the stack is empty");
			return "-1";
		}
			
	}
	
	/**
	 * 查找栈顶对象
	 * 
	 * @return
	 */
	public String peek(){
		if(topofStack >= 0){
			return stackArray[topofStack];
		}else{
			System.out.println("sorry! but the stack is empty");
			return "-1";
		}
	}

}

