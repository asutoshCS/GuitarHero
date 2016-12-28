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
public class GuitarHero {
	
	static final int numberOfStrings = 37; //final variable for number of strings
	static final double TEXT_X_AND_Y_POS = 0.52; //position for the text
	static final double PICTURE_POS = 0.5; //position for the picture
	static final int FREQUENCY = 440; //frequency
	static final double HALF_STEPS = 1.05956; //not sure what this is??
	static final int DIFFERENCE = 24; //difference for each increment of i
	
    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; //keyboard
        GuitarString[] strings = new GuitarString[numberOfStrings];
        //adds the picture to the stdDraw (needs the url to run)
        StdDraw.picture(PICTURE_POS, PICTURE_POS, "https://www.cs.utexas.edu/~scottm/cs312/javaCode/A11GuitarHero/keyboard.png"); 
        StdDraw.text(TEXT_X_AND_Y_POS, TEXT_X_AND_Y_POS, "USE YOUR KEYBOARD TO PLAY NOTES!");
        
        //correspond the keyboard to the guitar strings
        for (int i = 0; i<numberOfStrings; i++){
        	double newNote = FREQUENCY * Math.pow(HALF_STEPS, i-DIFFERENCE);
        	GuitarString guitar = new GuitarString(newNote);
        	strings[i] = guitar;
        }
        play(keyboard, strings); //method that calls the play method
    }
    //method that plays the string 
    public static void play(String keyboard, GuitarString[] strings) {
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key)!= -1){
                	int stringIndex = keyboard.indexOf(key);
                	strings[stringIndex].pluck();
                }
            }
            double sample = 0;
            for(int i = 0; i<numberOfStrings; i++){
            	sample += strings[i].sample();
            }
            StdAudio.play(sample);
            for(int i = 0; i<numberOfStrings; i++){
            	strings[i].tic();
            }
        }
    }
}