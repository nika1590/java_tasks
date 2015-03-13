package tests;

import myshop.Shop;

import org.junit.Assert;
import org.junit.Test;

public class CsvFileTest {

    @Test
    public void testNoFile() {
        String fileNotInitiated = null;
        Shop myshop = new Shop(fileNotInitiated);
        Assert.assertNull(myshop.getStock());
    }

    @Test()
    public void testNotExisted() {
        String fileIncorrectPath = "notExisted.csv";
        Shop myshop = new Shop(fileIncorrectPath);
        Assert.assertNull(myshop.getStock());
    }

    @Test
    public void testBrokenFile() {
        String fileBroken = "broken.csv";
        Shop myshop = new Shop(fileBroken);
        Assert.assertNull(myshop.getStock());
    }

    @Test
    public void testIncorrectFormat() {
        String fileIncorrectFormat = "products.txt";
        Shop myshop = new Shop(fileIncorrectFormat);
        Assert.assertNull(myshop.getStock());
    }

    @Test
    public void testCorrectFile() {
        String file = "products.csv";
        Shop myshop = new Shop(file);
        Assert.assertNotNull(myshop.getStock().size());
    }	

}
