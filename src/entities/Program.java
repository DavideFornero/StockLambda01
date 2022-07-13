package entities;


import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;



import java.util.ArrayList;
import java.util.InputMismatchException;

public class Program {
    
    public static void main(String[] args)  {
        
        Locale.setDefault(Locale.US);	
        Scanner sc = new Scanner(System.in);

        List<Stock> stockList = new ArrayList<>();
        
        int n=0;
		try {
			System.out.println("How many products do you want to register?");
			n = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error ! (Repeat process) "+e.getMessage());
            System.exit(0);    			
			
		}
		
		
        sc.nextLine();

        try {
			for (int i = 0; i < n; i++) {
			    System.out.println("Id:");
			    Integer id = sc.nextInt();
			    sc.nextLine();
			    System.out.println("Name: ");
			    String name = sc.nextLine();
			    System.out.println("Price: ");
			    Double price = sc.nextDouble();
			    Integer quantity;
			    do{
			    System.out.println("Quantity: (Max 500 units) ");
			     quantity= sc.nextInt(); 
			    } while (quantity < 0 || quantity > 500);
			    
			    sc.nextLine();
			    stockList.add(new Stock(id, name, price, quantity));
			}
		} catch (InputMismatchException e1) {
			System.out.println("Error "+e1.getMessage());
            System.exit(0);
		}
               

        System.out.println("Stock List: ");
        for (Stock stock : stockList) {
            System.out.println(stock);
        }

        System.out.println("Do you want to update the stock? (y/n)");
        Character answer=null;
		try {
			answer = sc.next().toUpperCase().charAt(0);
		} catch (InputMismatchException e2) {
			System.out.println("Error "+e2.getMessage());
			
		}
        sc.nextLine();
        if (answer=='Y') {
            System.out.println("Which product do you want to update? Insert the id:");
            int id = sc.nextInt();
            sc.nextLine();
            String response = stockList.stream().filter(x -> x.getId() == id).map(x -> "true").findFirst().orElse("false");
            
        
            try {
                if (response.equals("true")) {                
           
                    System.out.println("Add or remove?");
                    String addOrRemove = sc.nextLine().toUpperCase();
                    System.out.println("How many?");
                    int quantity = sc.nextInt();
                    if (addOrRemove.equals("ADD")) {
                        stockList.stream().filter(e -> e.getId() == (id)).collect(Collectors.toList()).get(0).addStock(quantity);
                    } else if (addOrRemove.equals("REMOVE")) {
                        stockList.stream().filter(e -> e.getId() == (id)).collect(Collectors.toList()).get(0).removeStock(quantity);
                    } else {
                        System.out.println("Invalid option");
                    }
    
               
                } else { System.out.println("Invalid id"); }

            } catch (InputMismatchException e) {
                System.out.println("Error "+e.getMessage());
                System.exit(0);
            }
            
       
        

        System.out.println("Updated List: ");
        for (Stock stock : stockList) {
            System.out.println(stock);
        }
        


        System.out.println("\nTotal value in stock: ");
        Double totalValue = stockList.stream().mapToDouble(e -> e.totalValueInStock()).sum();        
        System.out.println(String.format("Total $ %.2f", totalValue));

        
    
        

        sc.close();
        

            }
           
            
}

}