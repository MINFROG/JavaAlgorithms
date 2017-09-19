package stacksAndQueues;

import java.util.Arrays;

/**
 * @desc 模拟队列(FIFO)
 * 
 * @author yuhuiping
 * @version v1.0 
 * @date 2017年3月16日下午12:18:45
 */
public class TheQueue {
	
	private String[] arrayQueue;
	
	private  int  queueSize;
	
	int front,rear,numberOfItems = 0;
	
	public TheQueue(int size){
		arrayQueue = new String[size];
		queueSize = size ; 
		Arrays.fill(arrayQueue, "-1");
	}
	
	public void insert(String input){	
		if(numberOfItems+1 <= queueSize){
			arrayQueue[rear] = input;
			rear++;
			numberOfItems++;
		}else System.out.println("sorry,but the queue is full!");
	}
	
	public String peek(){
		if(numberOfItems >= 0) return arrayQueue[front];
		else {
			System.out.println("sorry, but the queue is empty!");
			return "-1";
		}
	}
	
	public void remove(){
		if(numberOfItems >= 0 ){
			arrayQueue[front] = "-1";
			front++;
			numberOfItems--;
		}else{
			System.out.println("sorry,but the queue is empty!");
		}
	}
	
	public static void main(String[] args) {
		TheQueue theQueue = new TheQueue(10);
		theQueue.insert("10");
		theQueue.insert("12");
		theQueue.insert("15");
		System.out.println(theQueue.arrayQueue.toString());
		String peek = theQueue.peek();
		System.out.println(peek);
		theQueue.remove();
		String peek2 = theQueue.peek();
		System.out.println(peek2);
		theQueue.remove();
		String peek3 = theQueue.peek();
		System.out.println(peek3);
		theQueue.remove();
		String peek4 = theQueue.peek();
		System.out.println(peek4);
	}
	
}

