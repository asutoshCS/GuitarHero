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
public class GuitarString {

	public int ticTimes; //counts the nunber of tics 
	private RingBuffer rb; //creates a new RingBuffer objects
	static final int SAMPLING_RATE = 44100; //final variable for sampling rate
	static final double ENERGY_DECAY_FACTOR = 0.994; //final variable for energy decay factor
	
	//Constructor that creates a guitarString 
	public GuitarString(double frequency) {
		
		int size = (int) (SAMPLING_RATE/frequency);
		rb = new RingBuffer(size); 
		for(int i = 0; i < size; i++) {
			rb.enqueue(i);
		}
		ticTimes = 0; 
	}
	//Constructor that creates a guitar String whose initial size are already given 
	public GuitarString(double[] init) {
		int length = init.length; 
		rb = new RingBuffer(length); 
		for(int i = 0; i < length; i++) {
			rb.enqueue(init[i]);
		}
	}
	//Method that sets the buffer to white noise
	public void pluck() {
		for(int i = 0;i<rb.ringBuffer.length;i++){
			rb.dequeue();
			double random = Math.random() -.5;
			rb.enqueue(random);
		}
	}
	//Method that advances the simulation
	public void tic(){
		double a = rb.dequeue();
		double b = rb.peek();
		rb.enqueue(((a+b)/2)*ENERGY_DECAY_FACTOR);
		ticTimes++;
	}
	//Returns the sample 
	public double sample(){
		return this.rb.peek();
	}
	//Returns the number of tics 
	public int time(){
		return ticTimes;
	}
}
