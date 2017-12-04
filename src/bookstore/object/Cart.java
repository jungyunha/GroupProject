package bookstore.object;

import java.util.List;

public class Cart {

	public List<CartItem> cartItems;
	public double totalPrice;
	public int promoPercentage;
	public String paymentType;
	
	public Cart() {
		cartItems = null;
		totalPrice = 0;
		promoPercentage = 0;
		paymentType = "";
	}
	
	public Cart(List<CartItem> cartItems, double totalPrice, int promoPercentage, String paymentType) {
		super();
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.promoPercentage = promoPercentage;
		this.paymentType = paymentType;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPromoPercentage() {
		return promoPercentage;
	}

	public void setPromoPercentage(int promoPercentage) {
		this.promoPercentage = promoPercentage;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}
