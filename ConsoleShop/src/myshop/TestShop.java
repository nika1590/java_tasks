package myshop;

public class TestShop {

	public static void main(String[] args) {
		Shop myShop = new Shop(CsvFile.FILE_NAME);		
		CommandReader console = new CommandReader();
		console.readAndProceed(myShop);
	}
}