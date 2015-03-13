package myshop;

import java.util.Scanner;

public class CommandReader {

    public void readAndProceed(Shop shop) {
        System.out.println("***Welcome to our shop!***");
        System.out.println("***To proceed with shopping please enter the command***");
        System.out.println();
        System.out.println("The list of available commands:***");
        System.out.println("'list goods' - print the list of all products: their product id, name, count in stock and price");
        System.out.println("'add' - prompt you to enter product id and add it to the shopping cart");
        System.out.println("'get order' - print out the products from the shoping cart and make order");
        System.out.println("'exit' - exit from the shop");

        Scanner console = new Scanner(System.in);
        boolean readCommand = true;

        while(readCommand){
            String command = null;
            command = console.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                readCommand = false;
                shop.exit();
                break;
            }

            switch (command) {

            case "list goods":
                shop.listGoods();
                break;

            case "add":
                System.out.println("Please enter product id = ");
                String productId;
                productId = console.nextLine();				
                shop.addItemToShoppingCart(Integer.parseInt(productId));
                break;

            case "get order":
                shop.getOrder();
                break;

            default:
                System.out.println("You typed '" + command + "'. There is no such command. Please try again");
                break;
            }
        }
        console.close();
    }		
}