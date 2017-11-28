package bookstore.object;

public class Book {

	public int ISBN;
	public String title;
	public String price;
	public int quantity;
	public String coverphoto;
	public String category;
	public String description;
	public int thresholdLimit;
	public float rating;
	public String author;
	
	public Book() {
		ISBN = 0;
		title = "";
		price = "";
		quantity = 0;
		coverphoto = "";
		category = "";
		description = "";
		thresholdLimit = 0;
		rating = 0;
		author = "";
	}

	public Book(int iSBN, String title, String price, int quantity, String coverphoto, String category,
			String description, int thresholdLimit, float rating, String author) {
		ISBN = iSBN;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.coverphoto = coverphoto;
		this.category = category;
		this.description = description;
		this.thresholdLimit = thresholdLimit;
		this.rating = rating;
		this.author = author;
	}
	
}
