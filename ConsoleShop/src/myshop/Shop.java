package myshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Shop {

    private List<ProductItem> stock = new ArrayList<ProductItem>();
    private Map<Integer, Integer> shoppingCart = new HashMap<Integer, Integer>();

    public Shop(String fileName){
        CsvFile file = new CsvFile();
        this.stock = file.read(fileName);
    }

    public List<ProductItem> getStock(){
        return this.stock;
    }

    public Map<Integer, Integer> getShoppingCart(){
        return this.shoppingCart;
    }

    public void listGoods(){
        System.out.println("There are the following products:");
        Formatter.prettyPrintHeader();
        for (int i = 0; i < stock.size(); i++) {
            System.out.print(i + 1 + "  |  ");
            Formatter.prettyPrintStockItem(stock.get(i));
        }
        System.out.println();
    }

    public void addItemToShoppingCart(int productId){
        ProductItem itemFound = searchItemInStock(productId);
        if (itemFound != null){
            int count = itemFound.getUnitsInstock();
            if (count > 0){
                int newCount = count - 1;
                itemFound.setUnitsInstock(newCount);
                int index  = itemFound.getProductId();
                if(shoppingCart.containsKey(index)) {
                    int val = shoppingCart.get(index);
                    shoppingCart.put(index, val + 1);
                }
                else
                    shoppingCart.put(index, 1);
                System.out.println("The product was added to the shopping cart");
                System.out.println();
            }
            else{
                System.out.println("No more products with this id");
            }
        }
        else{
            System.out.println("There is no product with this id");
        }
    }

    public ProductItem searchItemInStock(int productId){
        ProductItem itemInShop = null;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getProductId() == productId){
                itemInShop = stock.get(i);
                break;
            }
        }
        return itemInShop;
    }

    public void getOrder(){
        if (shoppingCart.size() > 0){
            System.out.println("Your ordered the following items:");
            double price = 0;
            Formatter.prettyPrintHeader();
            for (int i = 0; i < stock.size(); i++) {
                int productId = stock.get(i).getProductId();
                if(shoppingCart.containsKey(productId)) {
                    price = price + stock.get(i).getUnitPrice() * shoppingCart.get(productId);
                    System.out.print(i + 1 + "  |  ");
                    Formatter.prettyPrintCartItem(stock.get(i), shoppingCart);
                }    
            }
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            price = Math.round(price * 100);
            System.out.println("TOTAL " + price / 100);
            System.out.println();
        }
        else{
            System.out.println("There are no items in your shopping cart");
        }
    }

    public void exit(){
        System.out.println("The Magazine has stopped working");
    }	
}
