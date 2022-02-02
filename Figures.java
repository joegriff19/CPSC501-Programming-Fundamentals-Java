//---------------------------------------------------------------
// Joe Griffin
// Programming Fundamentals
// FA20-CPSC-50100-003
// 11/22/2020
// Programming Assignment 2 (Figures)
//---------------------------------------------------------------

import java.util.Scanner;

public class Figures {
	
	// Box Method
	public static void printBox(int size) {
		for (int i = 1; i <= size; i++)
		{
			// Output X's
			for(int j = 1; j <= size; j++)
			{
				System.out.print("X"); 
			}
			System.out.println("");		
		}
	}
	
	// Diamond Method
	public static void printDiamond(int size) {

		// Top half of triangle
		int i, j, c = 0;
        for (i = 1; i <= ((size/2)); i++) { 
            // Output blank spaces
            for (j = 1; j <= size - (i+(size/2)); j++) { 
                System.out.print(" "); 
            } 
            // Output X's
            while (c != (2 * i)) { 
                if (c == 0 || c == 2 * i - 1) 
                    System.out.print("X"); 
                else
                    System.out.print(" "); 
                c++; 
            } 
            c = 0; 
            System.out.println(); 
        }     
        // Bottom half of triangle
        size--; 
        for (i = ((size/2)+1); i >= 1; i--) { 
        	// Output blank spaces 
            for (j = 0; j <= size - (i+(size/2)); j++) { 
                System.out.print(" "); 
            } 
            // Output X's
            c = 0; 
            while (c != (2 * i)) { 
                if (c == 0 || c == 2 * i - 1) 
                    System.out.print("X"); 
                else
                    System.out.print(" "); 
                c++; 
            } 
            System.out.println(); 
        } 

	}
		
	// X Method
	public static void printX(int size) {
		int i, j;
		for (i = 0; i < size; i++) {
	        for (j = 0; j < size; j++) {
	        	// Output X's
	        	if (i == j || i + j == size-1) {
	                System.out.print("X");
	            // Output blank spaces
	        	} else {
	                System.out.print(" ");
	            }
	        }
	        System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int size, option;
		Scanner scan = new Scanner (System.in);
		
		// Introduction
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: Joe Griffin");
        System.out.println("PROGRAMMING ASSIGNMENT 2");
        System.out.println();
        // Prompt user for figure size
		System.out.print("Enter the size of the figure (odd number): ");
			size=scan.nextInt();
		while (size % 2 != 1 || size < 3) {
			System.out.println("Invalid figure size - must be an odd number");
			System.out.println("");
			System.out.print("Reenter the size of the figure: ");
				size=scan.nextInt();
		}
		// Prompt user with menu
		System.out.println("");
		System.out.println("MENU:");
		System.out.println("1. Print box");
		System.out.println("2. Print diamond"); 
		System.out.println("3. Print X");
		System.out.println("4. Quit program");
		System.out.println("");
		System.out.print("Please select an option: ");
			option=scan.nextInt();		
		while (option > 4 || option < 1) {
			System.out.println("Invalid option selection - please try again");
			System.out.println("");
			System.out.print("Please select an option: ");
				option=scan.nextInt();
		}	
		// Output figures
		while (option<4){
			if (option==1) {
				System.out.println("");
				Figures.printBox(size);
			}
			if (option==2) {
				System.out.println("");
				Figures.printDiamond(size);
			}
			if (option==3) {
				System.out.println("");
				Figures.printX(size);
			}
			// Display menu again
			System.out.println("");
			System.out.println("MENU:");
			System.out.println("1. Print box");
			System.out.println("2. Print diamond"); 
			System.out.println("3. Print X");
			System.out.println("4. Quit program");
			System.out.println("");
			System.out.print("Please select an option: ");
				option=scan.nextInt();
					
			while (option > 4 || option < 1) {
				System.out.println("Invalid option selection - please try again");
				System.out.println("");
				System.out.print("Please select an option: ");
					option=scan.nextInt();
			}
		}
		// End program
		if (option==4) {
				System.out.println("");
				System.out.println("Good bye!");
		}
	
	}							

}
