package bookstore.object;

public class Transaction {

	public int transactionID;
	public double totalAmountPaid;
	
	public Transaction() {
		super();
		transactionID = 0;
		totalAmountPaid = 0;
	}

	public Transaction(int transactionID, double totalAmountPaid) {
		super();
		this.transactionID = transactionID;
		this.totalAmountPaid = totalAmountPaid;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	
}
