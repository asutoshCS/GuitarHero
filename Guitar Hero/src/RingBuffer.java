import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * CS312 Assignment 12.
 *
 * On my honor, Asutosh Dhakal, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Hangman.
 *
 *  email address: asutosh.dhakal@utexas.edu	
 *  UTEID: ad42324
 *  Unique 5 digit course ID: 51295
 *  Grader name: Shelby
 *  Number of slip days used on this assignment: 0
 */

public class RingBuffer {

	public double[] ringBuffer; //creates the public ring buffer that the other classes access
	private int sizeOfBuffer; //instance variable that is the size of the buffer
	private int first; //first index of the buffer
	private int last; //last index of the buffer
	private int size; //keeps track of the size of the buffer
	//Constructor that takes in a capacity which initializes the size of the buffer array
	public RingBuffer(int capacity) {
		 sizeOfBuffer = capacity; 
		 ringBuffer = new double[sizeOfBuffer]; 
		 first = 0; 
		 last = 0; 
		 size = 0; 
	}
	//returns the size of the elements in buffer
	public int size() {
		return size; 
	}
	//checks if the buffer is empty
	public boolean isEmpty() {
		return size == 0; 
	}
	//checks if the buffer is full (# of elements == sizeOfBufffer)
	public boolean isFull() {
		return size == sizeOfBuffer; 
	}
	//adds a new element to the buffer
	public void enqueue(double x) throws IllegalStateException {
		if(!isFull()) {
			ringBuffer[last++] = x;
			last %= sizeOfBuffer; 
			size++; 
		}
	}
	//deletes the item at the front of the array
	public double dequeue() throws NoSuchElementException {
		double front = 0; 
		if(!isEmpty()) {
			front = ringBuffer[first++]; 
			first %= sizeOfBuffer; 
			size--; 
		}
		return front; 
	}
	//returns the item from the front of the array 
	public double peek()  {
		
		if(isEmpty()) {
			throw new NoSuchElementException(); 
		}
		return ringBuffer[first]; 
	}
	//toString method
	public String toString() {
		
		double[] d = new double[size()]; 
		int begin = first;
		for(int i = 0; i < size(); i++ ) {
			d[i] = ringBuffer[begin]; 
			begin++; 
			if(begin >= sizeOfBuffer) {
				begin -= sizeOfBuffer; 
			}
		}
		return Arrays.toString(d); 
		
	}
}
