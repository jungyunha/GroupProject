package bookstore.object;

public class CartItem {
	public Book book;
	public int quantity;
	
	public CartItem() {
		book = new Book();
		quantity = 0;
	}
	
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
	
	public void setBook(Book b) {
		this.book = b;
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
}
