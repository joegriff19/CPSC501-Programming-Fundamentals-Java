/*
 * Joe Griffin
 * 12/18/2020
 * Programming Fundamentals
 * FA20-CPSC-50100-003
 * Programming Assignment #4: SortedSet
 */

import java.util.Scanner;

// Defines the a Sorted Set collection and implements a driver program in main
public class SortedSet {
	// Define a basic element of a linked list
	private class LinkedNode {
		int x;  // Value stored in the node
		LinkedNode next;  // Reference to the next node in the list
	}
	
	LinkedNode front = null;  // Reference to the front of the singly linked list
	
	// Adds the integer x to the collection.
    // The resulting collection is sorted in increasing order and
    // does not contain any duplicate values.
	public void add(int x) {
		// Initialize a new node to be added to the collection
		LinkedNode newNode = new LinkedNode();
		LinkedNode cur = front;
		newNode.x = x;

		// Check if list is empty
		if (cur == null) {
			front = newNode;
			newNode.next = null;
		}
		else {
			// Check if node should be placed in front
			if (newNode.x < cur.x) {
				newNode.next = cur;
				front = newNode;
				}
			
			// Check if node is already present
			else {
				while (cur.next != null) {
					if (cur.x == newNode.x) {
						cur = null;
						break;
					}
					cur = cur.next;
				}
				if (cur == null || cur.x == newNode.x);
				
				// If not, find correct spot for node in middle or end
				else {
					cur = front;
						while (cur != null) {
			
							// Check if node should go at end
							if (cur.next == null) {
								cur.next = newNode;
								newNode.next = null;
								cur = null;
							}
							// If not, find correct place in middle
							else if (cur.next.x > newNode.x) {
								newNode.next = cur.next;
								cur.next = newNode;
								cur = null;
							}
							else 
								cur = cur.next;
						}	
				}	
			}	
		}
	}

	// Deletes the integer x from the sorted set.
	// The remaining collection remains sorted and without duplicates.
	public void delete(int x){
		// Declare a new reference and initialize it to the front of the list
		LinkedNode cur = front;
		LinkedNode newNode = new LinkedNode();
		int trigger = 0;
		
		// Check if list is empty
		if (front == null) {
			System.out.print("There is nothing to delete!");
		} else {  // Not empty
			
			// Go through list, checking whether node is in the list, and delete if found
			while (cur != null && cur.next != null) {
				if (cur.next.x == x) {
					newNode = cur.next;
					cur.next = newNode.next;
					trigger=1;
				} 
				cur = cur.next;
			}
			if (front.x == x) {
				front = front.next;
				trigger=1;
			}
			// Nothing to delete message if not present
			if (trigger == 0) 
				System.out.println("There is nothing to delete!");
		}
	}
	
	// Returns true if the integer x exists in the sorted set and false otherwise.
	public void exists(int x) {
		// Declare a new reference and initialize it to the front of the list
		LinkedNode cur = front;
		
		// Check if list is empty.
		if (front == null) {
			System.out.println("false");
		}
		
		// If not empty, check for the node.
		else {
			while (cur != null) {
				if (cur.x == x) {
					System.out.println("true");
					break;
			}
			cur = cur.next;
		}
		if (cur == null) 
			System.out.println("false");	
		}
	}
	
	// Returns a string representing the sorted set as a space separated list.
	public String toString() {
		String s = "";
		
		LinkedNode cur = front;		
		while (cur!=null) {
			s+= cur.x + " ";
			cur = cur.next;
		}
		
		return s;
	}
	
	// Driver method
	public static void main(String[] args) {
		// Declare variables
		SortedSet sortedSet = new SortedSet();
		Scanner scan = new Scanner(System.in);
		String[] tokens;
		String command;
		int num;
		
		// Print header info
		System.out.println("Programming Fundamentals\n"
				+ "NAME: Joe Griffin\n"
				+ "PROGRAMMING ASSIGNMENT 4\n");
				
		// Enter command loop
		while (true) {
			// Prompt the user for a command
			System.out.print("Enter command: ");
			String input = scan.nextLine();
			
			// Parse input
			if (input.equals("q")) break;  // user quits
			tokens = input.split("\\s");
			if (tokens.length < 2) continue; // invalid input
			command = tokens[0];
			num = Integer.parseInt(tokens[1]);
			
			// Execute command
			if (command.equals("add")){
				sortedSet.add(num);
				System.out.println(sortedSet);
			} else if (command.equals("del")) {
				sortedSet.delete(num);
				System.out.println(sortedSet);
			} else if (command.equals("exists")) {
				sortedSet.exists(num);
			} else {
				System.out.print("Command does not exist");
			}
		}
		
		System.out.println("\nGood bye!");
	}
}

