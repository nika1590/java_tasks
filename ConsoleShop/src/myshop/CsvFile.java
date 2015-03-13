package myshop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;


public class CsvFile {

    final static String FILE_NAME = "products.csv";

    public List<ProductItem> read(String fileName) {

        List<ProductItem> stock = null;

        try {
            CsvReader products = new CsvReader(fileName);
            products.readHeaders();
            stock = new ArrayList<ProductItem>();

            while (products.readRecord()){
                String productID = products.get("ProductID");
                String productName = products.get("ProductName");
                String unitsInStock = products.get("UnitsInStock");
                String unitPrice = products.get("UnitPrice");

                ProductItem item = new ProductItem(Integer.parseInt(productID), productName,
                        Integer.parseInt(unitsInStock), Double.parseDouble(unitPrice));

                stock.add(item);
            }	        
            products.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error Occured Exception: " + e.getMessage());
            stock = null;
        } catch (Exception e) {
            System.out.println("Unknown Exception Occured: " + e.getMessage());
            e.printStackTrace();
            stock = null;
        }
        return stock;
    }
}
