package tests;

import static org.junit.Assert.*;
import myshop.ProductItem;
import myshop.Shop;

import org.junit.Test;

public class ShopTest {

    private String fileName = "test_products.csv";
    Shop myShop = new Shop(fileName);

    @Test
    public void testStockSize() {
        int expectedCount = 4;

        assertEquals(expectedCount, myShop.getStock().size()); 
    }

    @Test
    public void testAddingToCart() {
        myShop.addItemToShoppingCart(1001);

        assertTrue(myShop.getShoppingCart().containsKey(1001));
        assertTrue(myShop.getShoppingCart().containsValue(1));

        myShop.addItemToShoppingCart(1001);

        assertTrue(myShop.getShoppingCart().containsKey(1001));
        assertTrue(myShop.getShoppingCart().containsValue(1));

        myShop.addItemToShoppingCart(1002);
        myShop.addItemToShoppingCart(1002);
        myShop.addItemToShoppingCart(1003);

        assertTrue(myShop.getShoppingCart().containsKey(1001));
        assertTrue(myShop.getShoppingCart().containsValue(1));		
        assertTrue(myShop.getShoppingCart().containsKey(1002));
        assertTrue(myShop.getShoppingCart().containsValue(2));
        assertTrue(myShop.getShoppingCart().containsKey(1003));
        assertTrue(myShop.getShoppingCart().containsValue(1));
    }

    @Test
    public void testUnitsInStockAfterBuying() {
        ProductItem item1 = myShop.searchItemInStock(1004);

        assertEquals(1, item1.getUnitsInstock());		

        myShop.addItemToShoppingCart(1004);

        assertEquals(0, item1.getUnitsInstock());		

        myShop.addItemToShoppingCart(1004);

        assertEquals(0, item1.getUnitsInstock());
    }	
}
