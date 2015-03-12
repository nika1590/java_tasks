package myshop;

import java.util.Map;

public class Formatter {
	
	Formatter(){};
	
	public static void prettyPrintHeader(){
        System.out.printf("%-7s%-8s%-11s%-8s%s\n","N", "Id", "Name", "Count", "Price");
	}
	
	public static void prettyPrintStockItem(ProductItem item){
        System.out.printf("%-6s%-3s%-9s%-3s%-4s%-3s%-6s%s\n", item.getProductId(),
        		"|", item.getProductName(), "|", item.getUnitsInstock(), "|", item.getUnitPrice(), "|");
	}

	public static void prettyPrintCartItem(ProductItem item, Map<Integer, Integer> cart){
		System.out.printf("%-6s%-3s%-9s%-3s%-4s%-3s%-6s%s\n", item.getProductId(), "|",
				item.getProductName(), "|", cart.get(item.getProductId()), "|", item.getUnitPrice(), "|");
	}
}
