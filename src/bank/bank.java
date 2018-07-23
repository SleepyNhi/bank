package bank;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class bank {

	
	
	public static void main(String[] args)	{
		Scanner sc = new Scanner(System.in);
		
		while(true)	{
			System.out.println("Would you like to run the bank "
					+ "simulation?(Yes/No): ");	
		String input = sc.nextLine();
		input.toLowerCase();
		
		if(input.equals("yes")) {
			Runnable queueTimer = new Runnable();
			Random rand = new Random();
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean teller1,teller2,teller3,teller4,teller5 = false;
			boolean[] tellerArray = {teller1,teller2,teller3,teller4,teller5};
			int[] tellersArray2 = {(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2),
					(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2),(rand.nextInt(5 - 2) + 2)};
			
			int i = 0; 
			
			//variables for testing if customer has been served
			int a, b, c, d, e; 
			int v, w, x, y, z = 1;
			//customers for output
			int postCustomer1, postCustomer2, postCustomer3, postCustomer4, postCustomer5 = 0; 
			//time for output
			int occupiedTime1, occupiedTime2, occupiedTime3, occupiedTime4, occupiedTime5 = 0;

			

class Runnable extends Thread {
			 public void run() {
				//once the 2 minutes (120 seconds) have elapsed, the various outputs requested by the professor are displayed
			if(i == 120){ 
				System.out.println("The total amount of customers that visited the bank: " + 
						(postCustomer1 + postCustomer2+ postCustomer3 
								+ postCustomer4 + postCustomer5 + 5 + queue.size()) + " customers.");

				System.out.println("\nThe total amount of customers that each teller helped: ");
				 //not forgetting to add the first set of customers that each teller served
	            System.out.println("Teller 1: " + (postCustomer1 + 1));
	            System.out.println("Teller 2: " + (postCustomer2 + 1));
	            System.out.println("Teller 3: " + (postCustomer3 + 1));
	            System.out.println("Teller 4: " + (postCustomer4 + 1));
	            System.out.println("Teller 5: " + (postCustomer5 + 1));
	            
	            System.out.println("\nThe total amount of time that each teller was occupied: ");
	            System.out.println("Teller 1: " + (occupiedTime1 + " seconds"));
	            System.out.println("Teller 2: " + (occupiedTime2 + " seconds"));
	            System.out.println("Teller 3: " + (occupiedTime3 + " seconds"));
	            System.out.println("Teller 4: " + (occupiedTime4 + " seconds"));
	            System.out.println("Teller 5: " + (occupiedTime5 + " seconds"));
	            
	            System.out.println("\nThe total amount of customers that did not get to see a teller: " + queue.size() + " customers");

	            System.out.println("\nEnd of simulation");
	            System.exit(0);
	          }
			//this else will add customers randomly between 2-6 seconds
			else{
	            if(rand.nextInt(4) < 6){
	            int time = (rand.nextInt(5 - 2) + 3);
	            queue.add(time);
	            }

	        while(v == 1){ 
	        	a = i;
	        	v = 0;
	        }
	        //checks if elapsed time is greater than or equal to the random proccessd number for each customer
	        if ((i - a) >= tellersArray2[0]){
	        	tellerArray[0] = true;
	        	//if the elapsed time is greater than or equal to, then then teller is set to next customer in queue
	        	if (tellerArray[0] == true && queue.isEmpty() == false){ 
	        		occupiedTime1 += tellersArray2[0];
	        		tellersArray2[0] = queue.poll();
	        		v = 1;
	        		postCustomer1++;
	        	}
	        }
	        
           while(w == 1){ 
           b = i;
           w = 0;
           }
           if ((i - b) >= tellersArray2[1]){
        	   tellerArray[1] = true;
        	   if (tellerArray[1] == true && queue.isEmpty() == false){
        		   occupiedTime2 += tellersArray2[1];
        		   tellersArray2[1] = queue.poll();
        		   w = 1;
        		   postCustomer2++;
        	   }
           }
           while(x == 1){
               c = i;
               x = 0;
           }
           if ((i - c) >= tellersArray2[2]){
        	   tellerArray[2] = true;
        	   if (tellerArray[2] == true && queue.isEmpty() == false){
        		   occupiedTime3 += tellersArray2[2];
        		   tellersArray2[2] = queue.poll();
                   x = 1;
                   postCustomer3++;
               }
           }
           while(y == 1){ 
               d = i;
               y = 0;
           }
           if ((i - d) >= tellersArray2[3]){
        	   tellerArray[3] = true;
        	   if (tellerArray[3] == true && queue.isEmpty() == false){
        		   occupiedTime4 += tellersArray2[3];
        		   tellersArray2[3] = queue.poll();
                   y = 1;
                   postCustomer4++;
               }
           }
           while(z == 1){
               e = i;
               z = 0;
           }
           if ((i - e) >= tellersArray2[4]){
        	   tellerArray[4] = true;
        	   if (tellerArray[4] == true && queue.isEmpty() == false){
        		   occupiedTime5 += tellersArray2[4];
        		   tellersArray2[4] = queue.poll();
                   z = 1;
                   postCustomer5++;
               }
           }        
           i++;
           
           if(queue.size() == 1){
        	      //print out for timer that displays each second how many people are in queue as well as the number of seconds left
        	   System.out.println("There is " + queue.size() + " person currently in the queue."); 
           }
           else	{
        	   System.out.println("There are " + queue.size() + " people currently in the queue.");
           }
           System.out.println("\nThere are " + (120 - i) + " second(s) left in the simulation.");
			    	  

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(queueTimer, 0, 1, TimeUnit.SECONDS);
        	 
			}
			 }
}
		}
		
        	    //if user inputed no, they are brought here and it terminates the program
		else if (input.equals("no")){
			
			System.out.println("End of program");
			System.exit(0);
        	        
		}
		else{
			//if input was neither yes or no, prints this
			System.out.println("Invalid input. Try again!");
		}
		}
	}
	

	

           
           
			

			
