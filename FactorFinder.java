
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;

public class FactorFinder {
	
	// Function used to check input is a valid positive number 
	public static int checkInput(String numInput) {
		int num;
		// Try to cast input to an integer
		try {
			num = Integer.parseInt(numInput); 
			// If it is less than zero then input is invalid
			if(num < 0) {
				System.out.println("Please enter a number greater than zero");
				return -1;
			}	  
		}
		// If unable to cast then input is invalid
		catch(Exception e) {
			System.out.println("Please enter a valid integer");
			return -1;
		}
		// Return the integer
		return num;		
	}

    public static void main(String[] args) {
        
        int num;		
		// If an arguement is supplied
		if(args.length >= 1) {
			// Check that it is valid
			num = checkInput(args[0]);
			// If it is not exit program
			if(num == -1) {
				System.exit(0);
			}
		}
		// Else no arguement supplied so ask user to enter number
		else {
			// Continuous loop 
			while(true) {
				System.out.println("Enter a positive integer to see all its factors");
				// Read in user input
				Scanner sc = new Scanner(System.in);
				// Check input is valid
				num = checkInput(sc.next());
				// If it is valid then break out of loop
				if(num != -1) {
					break;
				}
			}
		}
        
        // Two arraylists to store the factors of the number input 
        List<Integer> f1 = new ArrayList<>();
        List<Integer> f2 = new ArrayList<>();
        
        // Iterate through each integer from 1 up to the number input
        for(int i=1;i<= num;i++) {
            // If i divides evenly into the number
            if(num%i == 0) {
                // Check that it is not already in the second factors list
                if(!f2.contains(i)) {
                    // Add i to the first factors list
                    f1.add(i);
                    // Add the number of times it divides into the number to the second list
                    f2.add(num/i);
                }             
            }
            // To prevent unnecessary iterations for large numbers, break out of loop 
            // if i is the same number as the last index of the second list
            if(i == f2.get(f2.size()-1)) {
                break;
            }
        }    
        System.out.println("The factors of "+ num + " are:");
        // Show factors in each list
        for(int i=0;i< f1.size();i++) {
            System.out.println(f1.get(i) + " x " + f2.get(i));
        }
    } 
}
