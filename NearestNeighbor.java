//---------------------------------------------------------------
//Joe Griffin
//Programming Fundamentals
//FA20-CPSC-50100-003
//12/6/2020
//Programming Assignment 3 (Nearest Neighbor)
//---------------------------------------------------------------

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class NearestNeighbor {
	private static void inputTrainingValues (String filename, double[][]trainingValues, String [] trainingLabels) {
		// Scan in values and labels from Training file into 1D and 2D arrays
		try{
			BufferedReader br = new BufferedReader (new FileReader (filename));
			String[] column = new String [5];
			String line = "";
			int i = 0;
			while((line = br.readLine()) != null){
				column = line.split(",");
				trainingValues[i][0] = Double.parseDouble(column[0]);
				trainingValues[i][1] = Double.parseDouble(column[1]);
				trainingValues[i][2] = Double.parseDouble(column[2]);
				trainingValues[i][3] = Double.parseDouble(column[3]);
				trainingLabels[i] = column[4];
				i++;
			}
			// Close BufferedReader
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void inputTestingValues (String filename, double[][]testingValues, String [] testingLabels) {
		// Scan in values and labels from Testing file into 1D and 2D arrays
		try{
			BufferedReader br = new BufferedReader (new FileReader (filename));
			String[] column = new String [5];
			String line = "";
			int i = 0;
			while((line = br.readLine()) != null){
				column = line.split(",");
				testingValues[i][0] = Double.parseDouble(column[0]);
				testingValues[i][1] = Double.parseDouble(column[1]);
				testingValues[i][2] = Double.parseDouble(column[2]);
				testingValues[i][3] = Double.parseDouble(column[3]);
				testingLabels[i] = column[4];
				i++;	
			}
			// Close BufferedReader
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void classifyTestingValues (double[][]trainingValues, String [] trainingLabels, double[][]testingValues, String [] testingLabels) {
		// Establish variables for calculations
		double minDist, newDist;
		int mismatch = 0;
		String trueLabel, predictedLabel;
		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");
		
		// Apply nearest neighbor algorithm
		for (int i = 0; i < 75; i++) {
			minDist = 555555;
			trueLabel = testingLabels[i];
			predictedLabel = trainingLabels[i];
			for (int j = 0; j < 75; j++) {
				double slDiff = testingValues[i][0] - trainingValues[j][0];
				double swDiff = testingValues[i][1] - trainingValues[j][1];
				double plDiff = testingValues[i][2] - trainingValues[j][2];
				double pwDiff = testingValues[i][3] - trainingValues[j][3];
				newDist = Math.sqrt(slDiff*slDiff + swDiff*swDiff + plDiff*plDiff + pwDiff*pwDiff);	
				if (newDist < minDist) {
					minDist = newDist;
					predictedLabel = trainingLabels[j];
				}
			}
			// Output results and count number of mismatches
			System.out.println((i + 1) + ": " + trueLabel + " " + predictedLabel);
			if (!predictedLabel.equals(trueLabel))
				mismatch++;
		}
		// Calculate accuracy of predictions from algorithm
		double accuracy = ((75 - mismatch)/75.0);
		System.out.println("ACCURACY: " + accuracy);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// Introduction
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Joe Griffin");
		System.out.println("PROGRAMMING ASSIGNMENT 3");
		System.out.println();
		
		// Prompt user for training and testing files; read and store data; establish arrays
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter the name of the training file: ");
			String trainingFile = scan.next();
		System.out.print("Enter the name of the testing file: ");
			String testingFile = scan.next();
		System.out.println("");
		double[][]trainingValues = new double [75][4];
		double[][]testingValues = new double [75][4];
		String[]trainingLabels = new String[75];
		String[]testingLabels = new String[75];
		
		// Call methods
		inputTrainingValues (trainingFile, trainingValues, trainingLabels);
		inputTestingValues(testingFile, testingValues, testingLabels);
		classifyTestingValues(trainingValues, trainingLabels, testingValues, testingLabels);
		
		// Close scanner
		scan.close();
	}
}