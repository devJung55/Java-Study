package hashMapTest;

public class Product {
	private int productNumber;
	private String productName;
	private int productPrice;
	private int productStock;

	public Product() {;}

	public Product(int productNumber, String productName, int productPrice, int productStock) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productStock=" + productStock + "]";
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

}
