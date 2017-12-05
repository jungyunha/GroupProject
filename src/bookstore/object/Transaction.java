package bookstore.object;

public class Transaction {

	public int transactionID;
	public double totalAmountPaid;
	public String date;
	public String paymentType;
	public String status;
	
	public Transaction() {
		super();
		transactionID = 0;
		totalAmountPaid = 0;
	}

	public Transaction(int transactionID, double totalAmountPaid) {
		super();
		this.transactionID = transactionID;
		this.totalAmountPaid = totalAmountPaid;
		date = "";
		paymentType = "";
	}

	public Transaction(int transactionID, double totalAmountPaid, String date, String paymentType, String status) {
		super();
		this.transactionID = transactionID;
		this.totalAmountPaid = totalAmountPaid;
		this.date = date;
		this.paymentType = paymentType;
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public double getTotalAmountPaid() {
		return Math.floor(totalAmountPaid * 100) / 100;
	}

	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	
}
