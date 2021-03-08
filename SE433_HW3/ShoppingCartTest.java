package SE433_HW3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {

	@Test
	void newCartTest() {
		ShoppingCart newcart = new ShoppingCart();
		int result  = newcart.getItemCount();
		assertEquals(0, result);
		
	}
	@Test
	void emptyCartTest() {
		ShoppingCart newcart = new ShoppingCart();
		newcart.empty();
		int result  = newcart.getItemCount();
		assertEquals(0, result);
	}
	@Test
	void addItemTest() {
		ShoppingCart newcart = new ShoppingCart();
		String itemName = "soap";
		double itemPrice = 1.10;
		Product  newitem = new Product(itemName, itemPrice);
		newcart.addItem(newitem);
		int result  = newcart.getItemCount();
		assertEquals(1, result);

	}
	@Test
	void removeItemTest() throws ProductNotFoundException {
		ShoppingCart newcart = new ShoppingCart();
		String itemName = "soap";
		double itemPrice = 1.10;
		Product  newitem = new Product(itemName, itemPrice);
		newcart.addItem(newitem);
		newcart.removeItem(newitem);
		int result  = newcart.getItemCount();
		assertEquals(0, result);
	}
	
	

}
