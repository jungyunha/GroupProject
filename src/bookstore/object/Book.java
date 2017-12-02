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

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCoverphoto() {
		return coverphoto;
	}

	public void setCoverphoto(String coverphoto) {
		this.coverphoto = coverphoto;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getThresholdLimit() {
		return thresholdLimit;
	}

	public void setThresholdLimit(int thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
