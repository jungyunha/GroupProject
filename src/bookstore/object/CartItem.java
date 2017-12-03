package bookstore.object;

public class CartItem {
	private Book book;
	private int quantity;
	
	public CartItem(Book b, int q)
	{
		book = b; quantity = q;
	}
	
	public Book getBook() {
		return book;
	}
	
	public int getQuantity(){
		return quantity;
	}
}
