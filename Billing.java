
	import java.io.BufferedReader;
	import java.io.IOException;
	i4mport java.io.InputStreamReader;
	import java.util.Vector;
	public class Billing
	{
		/*
		Project
		Author:MANSI KESHARI
		University Roll no: 1900290110058

		Program to implement an ordering system for a Cafe

		Each func/!////3//4⁴4tion's functionality is defined before the function in form of comment.
		Other necessary comments are added to explain the functionality of specific parts
		*/

// declaring and initializing the global variables
		String A[]; // array to store the names of items for Sandwhiches
		String B[]; // array to store the names of items for Coffee, Tea, Hot Chocolate, Milk, and Juice:
		String C[]; // array to store the names of items for Coffee, Tea, Hot Chocolate, Milk, and Juice

		int price_A[]; // array to store the prices of respective menu set of A
		int price_B[]; // array to store the prices of respective menu set of B
		int price_C[]; // array to store the prices of respective menu set of C

		int price_set[]; // array to store the prices of respective menu set for set meals

		Vector<String> orderID=new Vector<String>();   // vector to store the ID of the ordered Meal
		Vector<Integer> orderPrice=new Vector<Integer>();   // vector to store the price of the ordered Meal
		Vector<String> orderName=new Vector<String>(); // vector to store the name of the ordered Meal
		//Constructor to initialize the items present in cafe and their respective prices
	    Billing()
	    {
	    	// adding the names of meals to the global variable
	    	A=new String[3];
		    A[0] = "Cheese veggie sandwhich";
		    A[1] = "Salmon & cheese sandwhich";
		    A[2] = "Chicken Caesar Sandwhich";
	        B=new String[3];
		    B[0] =  "(Quebec homemade) Quiche";
		    B[1] = "Bagel with Cream Cheese";
		    B[2] = "(East Village Chicken) Pie";
	        C=new String[5];
		    C[0] = "Coffee";
		    C[1] = "Green Tea";
		    C[2] = "Hot Chocolate";
		    C[3] = "Milk";
		    C[4] = "Juice";
		    
		 // adding the price of respective meals to the global variables
		    price_A=new int[3];
		    price_A[0] = 30;
		    price_A[1] = 34;
		    price_A[2] = 32;
		    price_B=new int[3];
		    price_B[0] = 28;
		    price_B[1] = 20;
		    price_B[2] = 28;
		    price_C=new int[5];
		    price_C[0] = 36;
		    price_C[1] = 28;
		    price_C[2] = 28;
		    price_C[3] = 26;
		    price_C[4] = 26;
		    price_set=new int[5];
		    price_set[0] = 48;
		    price_set[1] = 52;
		    price_set[2] = 50;
		    price_set[3] = 50;
		    price_set[4] = 60;
	    }
		public static void main(String[]args)throws IOException
		{
		    // declaring variables
		    int choice;           // variable to store user's choice of starting order or not and user's coice of continuing ordering or not
		    float total;          // variable to store the total amount of order
		    String name;          // variable to store name of the customer
		    float discount = 0.0f; // variable to store the discount
		    Billing obj=new Billing();//Creating object of class

		    obj.clearScreen(); // clearing screen
		    obj.welcome();     // displaying the welcome message
		    obj.clearScreen();
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//Creating object of BufferedReader class to take input
		    while (true)
		    {
		        // erase all the elements form the vectors (if present)
		        obj.orderID.clear();
		        obj.orderPrice.clear();
		        obj.orderName.clear();

		        // Displaying the system commands choice and entering them
		        System.out.println( "Press 1 to start ordering.");
		        System.out.println("Press 0 to exit the ordering system.");
	            System.out.println( "Enter your "choice here: ");
		        choice=Integer.parseInt(br.readLine());

		        // performing input validation
		        while (choice != 0 && choice != 1)
		        {
		        	System.out.println("Please enter either 1 or 0:");
		            choice=Integer.parseInt(br.readLine());
		        }
		        if (choice==1)
		        { // if choice is 1
		            // enter the name of customer
		        	System.out.println("Enter the name of customer: ");
		        	name=br.readLine();
		            while (name.length() > 40)
		            {
		            	System.out.println( "Number of characters in name should be less than 40. Please re-enter: ");
		                name=br.readLine();
		            }
		            obj.clearScreen(); // clear the screen
		            obj.displayMenu(); // displaying the menu
		            System.out.println("Welcome " + name +". Please select the meal ID for the meal.");
		            while (true)
		            {
		                obj.order();
		                System.out.println( "Press 1 to continue the order, and press 0 to complete the order: ");
		                choice=Integer.parseInt(br.readLine());

		                while (choice != 1 && choice != 0)
		                {
		                    System.out.println("Please enter wither 1 (for continuing the order) or 0 (to complete the order): ");
		                    choice=Integer.parseInt(br.readLine());
		                }
		                if (choice == 0)
		                    break;
		            }
		            obj.clearScreen();
		            System.out.println( name + ", these are the meals you ordered.");

		            obj.displayOrderList();   // displaying the ordered items
		            total = obj.orderTotal(); // calculating the total amount of order
		            System.out.println( "Total = $" + total); // Displaying the total
		            if (total > 100)
		            {
		                discount = 0.05f * total;  // Calculating the total
		                total = total - discount; // calculating the grand total
		            }
		            // calculating the grand total
		            System.out.println( "Discount = $" + discount); // displaying the discount
		            System.out.println( "Grand Total = $" + total); // displaying the grand total
		            System.out.println("\nThank You "+ name +" for choosing 7-23 Cafe!\n\n");
		            break;
		        }
		        else
		        { //displaying the closing message
		        	System.out.println( "\n\nThank You! Bye Bye!!");
		            break;
		        }
		    }

		} // End of main

		// Function to clear the screen
		void clearScreen()
		{ // using system commands to clear the screen
		    System.out.print('\f');
		}

		/* This function will be displaying the welcome message.*/
		void welcome()
		{
		    System.out.println( "Welcome to the 7-23 Cafe!!!!!");
		    System.out.println("--------------------------------\n\n");
		    System.out.println( "Following this screen you will see the Menu along with the Item code and Price of a specific item.");
		    System.out.println("The Menu is divided into 4 sections, namely:\n(A)  Sandwiched,\n(B)  Quiche, Pei, and Bagel with Cream Cheese ");
		    System.out.println("(C)  Coffee, Tea, Hot Chocolate, Milk, and Juice, AND\n(D)  Set Meals.");
		    System.out.println( "Scroll through the menu and select your order.");
		    System.out.println("Also, do not worry if you enter items which are part of a set meal.");
		    System.out.println("our system will identify the set meal and add the price of the meal, not the price of individual items.");
		    System.out.println( "Happy ordering!!\n\n");
		}

		/* This function will be displaying the menu */
		void displayMenu()
		{
		    // declaring variables
		    int i; // loop counter
		    // variable to store the names of set meal
		    String set[] = {
		        "Coffee + Bagel with cream cheese",
		        "Milk + Chicken Caeser Sandwhich ",
		        "Juice + Cheese Veggie Sandwhich",
		        "Hot Chocolate + Pie",
		        "Coffee + Quiche"};

		    // displaying the menu items of the sandwiches
		    System.out.println("A. Sanwhiches:\n");
		    System.out.printf("%10s%30s%5s","Item Code |","name |", "Price");
		    System.out.println();
		    System.out.println("-----------------------------------------------------");
		    for (i = 0; i < 3; i++)
		    {
		    	System.out.printf("%8s%d%s%28s%s%2s%d","A" ,(i + 1) ," |" ,A[i]," |" , "$",price_A[i]);
		    	System.out.println();
		    }

		    System.out.println( "\n\n");

		    // displaying the menu items of Quiche, Pie, and Bagel with Cream Cheese
		    System.out.println( "B. Quiche, Pei, and Bagel with Cream Cheese:");
		    System.out.printf("%10s %29s%5s","Item Code |", "name |","Price");
		    System.out.println();
		    System.out.println ("-----------------------------------------------------");
		    for (i = 0; i < 3; i++)
		    {
		    	System.out.printf("%8s%d%s%28s%s%2s%d","B",(i + 1)," |", B[i], " |", "$", price_B[i]);
		    	System.out.println();
		    }

		    System.out.println("\n\n");

		    // displaying the menu items of Coffee, Tea, Hot Chocolate, Milk, and Juice
		    System.out.println("C. Coffee, Tea, Hot Chocolate, Milk, and Juice:");
		    System.out.printf("%10s %29s %5s", "Item Code |" ,"name |", "Price");
		    System.out.println();
		    System.out.println("-----------------------------------------------------");
		    for (i = 0; i < 5; i++)
		    {
		    	System.out.printf("%8s%d%s%28s%s%2s%d", "C",(i + 1)," |" , C[i], " |" , "$" ,price_C[i]);
		    	System.out.println();
		    }

		    System.out.println("\n\n");

		    // displaying the menu items of set meals
		    System.out.println("D. Set Meals:");
		    System.out.printf("%10s%62s%5s","Item Code |", "name |","Price");
		    System.out.println();
		    System.out.println("------------------------------------------------------------------------------");
		    for (i = 0; i < 5; i++)
		    {
		    	System.out.printf("%8s%d%s%60s%s%2s%d", "S" ,(i + 1) ," |" ,set[i] , " |" , "$", price_set[i]);
		    	System.out.println();
		    }
		}

		// function to check if the entered meal ID is valid or not
		boolean isValidID(String ID)
		{
		    String validID[] = {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3", "C4", "C5", "S1", "S2", "S3", "S4", "S5"};

		    for (int i = 0; i < 16; i++) // simple linear search
		        if (ID.compareTo(validID[i])==0)
		            return true;
		    return false;
		}

		// function to update the orderPrice vector, to store the price of ordered item, thorugh the order ID.
		void updateOrderPrice(String ID)
		{
		    if (ID.charAt(0) == 'A')
		        orderPrice.add(price_A[ID.charAt(1) - 49]);
		    else if (ID.charAt(0) == 'B')
		        orderPrice.add(price_B[ID.charAt(1) - 49]);
		    else if (ID.charAt(0) == 'C')
		        orderPrice.add(price_C[ID.charAt(1) - 49]);
		    else
		        orderPrice.add(price_set[ID.charAt(1) - 49]);
		}

		// function to update the orderName vector, to store the name of ordered item, through the order ID.
		void updateOrderItemName(String ID)
		{
		    String set[] = {
		        "Coffee + Bagel with cream cheese",
		        "Milk + Chicken Caeser Sandwhich",
		        "Juice + Cheese Veggie Sandwhich",
		        "Hot chocolate + Pie",
		        "Coffee + Quiche"};

		    if (ID.charAt(0) == 'A')
		        orderName.add(A[ID.charAt(1) - 49]);
		    else if (ID.charAt(0) == 'B')
		        orderName.add(B[ID.charAt(1) - 49]);
		    else if (ID.charAt(0)== 'C')
		        orderName.add(C[ID.charAt(1) - 49]);
		    else
		        orderName.add(set[ID.charAt(1) - 49]);
		}

		// function to take Item ID as input and update the three order vectors (global variable)
		void order()throws IOException
		{
		    String ID; // variable to store entered ID
		    int q;//to store quantity of item
		    int i;//uesd for loop
		    System.out.println( "Enter the item ID: ");
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    ID=br.readLine();

		    // validating the entered ID
		    while (!isValidID(ID))
		    {
		    	System.out.println("Please enter a valid Item ID: ");
		        ID=br.readLine();
		    }
		    System.out.println("Enter the quantity");
             q=Integer.parseInt(br.readLine());//taking the quantity of the item entered by customer
             for(i=1;i<=q;i++)
             {
		    // updating the values
		     orderID.add(ID);//adding ID to orderID
		     updateOrderPrice(ID);//to store the price of the item 
		     updateOrderItemName(ID);//to store the name of the item
             }
		}

		// this function will be displaying the order list
		void displayOrderList()
		{
			System.out.printf("%12s %63s %5s", "Item Code |", "name |", "Price");
			System.out.println( "\n------------------------------------------------------------------------------");
		    for (int i = 0; i < orderID.size(); i++)
		    {
		    	System.out.printf("%9s %s%60s %s %2s %d", orderID.get(i), " |",orderName.get(i), " |","$", orderPrice.get(i));
		    	System.out.println();
		    }
		}

		// function to return the meal ID, if the order list contains individual items those are collectively part of a set meal
		String hasSet(Vector<String> orderID)
		{
			   if(orderID.contains("C1") && orderID.contains("B2"))
				   return "S1";
			   if(orderID.contains("A3") && orderID.contains("C4"))
				   return"S2";
			   if(orderID.contains("A1") && orderID.contains("C5"))
				   return "S3";
			   if(orderID.contains("C3") && orderID.contains("B3"))
				   return "S4";
			   if(orderID.contains("C1") && orderID.contains("B1"))
				   return "S5";
		   return "";//if the list no longer contains extra set meal item
		 }

		/* function to calculate order total*/
		int orderTotal()
		{
		    int sum = 0;// variable to store the total
		    int j,i;//used for loop
		   Vector<String> copy=new Vector<String>();
		   copy.addAll(orderID);//add all the elements of orderID to copy
		   String setID;//variable to store the set meal ID
		    	int n=orderID.size();//variable to store the no of ordered items
		    	int k=0;//variable to store the quantity of extra set meals present in the order
		    //loop to add the set meal ID and its price and remove the respective items present in the set meal from the ordered list
		    for(j=1;j<n;j++)
		    {
		     setID=hasSet(orderID);// checking if the order list contains a set meal, if it does, storing the set meal ID
		     if(setID=="")
		    	 break;//no extra set meal item is present
		    if(setID.compareTo("S1")==0)
		    {
		    	k++;
		    	i=orderID.indexOf("C1");//getting the index of C1 in the ordered list
		    	orderID.set(i,"");//replacing C1 with null
		    	orderPrice.set(i, 0);//replacing the price at index i with 0
		    	i=orderID.indexOf("B2");//getting the index of B2 in the ordered list
		    	orderID.set(i,"");//replacing B2 with null
		    	orderPrice.set(i, 0);//replacing the price at index i with 0
		    	orderID.add("S1");//adding S1 to the orderID
		    	orderPrice.add(48);//Adding the price of S1 to the price list
		    }
		    
		    if(setID.compareTo("S2")==0)
		    {
		    	k++;
		    	i=orderID.indexOf("A3");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	i=orderID.indexOf("C4");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	orderID.add("S1");
		    	orderPrice.add(52);
		    }
		    if(setID.compareTo("S3")==0)
		    {
		    	k++;
		    	i=orderID.indexOf("A1");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	i=orderID.indexOf("C5");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	orderID.add("S1");
		    	orderPrice.add(50);
		    }
		    if(setID.compareTo("S4")==0)
		    {
		    	k++;
		    	i=orderID.indexOf("B3");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	i=orderID.indexOf("C3");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	orderID.add("S1");
		    	orderPrice.add(50);
		    }
		    if(setID.compareTo("S5")==0)
		    {
		    	k++;
		    	i=orderID.indexOf("C1");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	i=orderID.indexOf("B1");
		    	orderID.set(i,"");
		    	orderPrice.set(i, 0);
		    	orderID.add("S1");
		    	orderPrice.add(60);
		    }
		    }
		    //printing the extra set meals present in the ordered list
		    if(k!=0)
		    System.out.println("Your item contains "+k+" set meal."+"\nSo its price will be taken instead of individual items.");
		    //Calculating total price
		    for(i=0;i<orderID.size();i++)
		    {
		    	sum=sum+orderPrice.get(i);
		    }
		    return sum;
		}
	}//end of class
of class
