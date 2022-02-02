//---------------------------------------------------------------
// Joe Griffin
// Programming Fundamentals
// FA20-CPSC-50100-003
// 11/18/2020
// Programming Assignment 1 (Cipher)
//---------------------------------------------------------------

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Cipher {
	
	public static void main(String[] args) {
		// Declare variables
       	int intOne, intTwo, intThree, intFour, intFive; // Input values
        int intSum;     // Sum of inputs
        int caesarOne;  // First enciphered digit
        int caesarTwo;  // Second enciphered digit
        Scanner scan = new Scanner (System.in);
        
        // Introduction
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: Joe Griffin");
        System.out.println("PROGRAMMING ASSIGNMENT 1");
        System.out.println();
        System.out.println("Welcome to the Cipher program.");

        // Prompt for the first integer and validate the value
        System.out.println("Please enter 5 numbers between 0 and 19");
        System.out.print("1st number: ");
        intOne = scan.nextInt();
        if (intOne<0 || intOne>19) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
                  }
        
        // Prompt for the second integer and validate the value
        System.out.print("2nd number: ");
        intTwo = scan.nextInt();
        if (intTwo>19 || intTwo<0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
                  }
        
        // Prompt for the third integer and validate the value
        System.out.print("3rd number: ");
        intThree = scan.nextInt();
        if (intThree>19 || intThree<0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
                  }
        
        // Prompt for the fourth integer and validate the value
        System.out.print("4th number: ");
        intFour = scan.nextInt();
        if (intFour>19 || intFour<0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
                  }

        // Prompt for the fifth integer and validate the value
        System.out.print("5th number: ");
        intFive = scan.nextInt();
        if (intFive>19 || intFive<0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
                  }
	
        // Generate key
        Random generator = new Random ();
        int key = generator.nextInt(10);
	
        // Calculate integer sum and enciphered number
        intSum = intOne + intTwo + intThree + intFour + intFive;
        caesarOne = (((intSum/10) % 10) + key) % 10;
        caesarTwo = (intSum + key) % 10;
        DecimalFormat dec = new DecimalFormat ("0");
        
        // Share integer sum, key, and enciphered number with user 
        System.out.println();
        System.out.println("Total = " + intSum);
        System.out.println("Your random key is " + key);
        System.out.println("Your encoded number is " + (dec.format(caesarOne)) + caesarTwo);
			
	}

}
