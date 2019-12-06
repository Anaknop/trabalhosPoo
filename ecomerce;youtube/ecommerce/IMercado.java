package ecommerce;

public interface IMercado {
	void addCustomer(Customer cus);
	void desattachCustomer(Customer cus);
	void notifyCustomer(Product product);
}
