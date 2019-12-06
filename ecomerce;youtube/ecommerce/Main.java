package ecommerce;

public class Main {

	public static void main(String[] args) {
		Mercado mercado = new Mercado("T-Surt");
		Customer cus1 = new Customer("Ana Carolina");
		Customer cus2 = new Customer("Ricardo");
		Customer cus3 = new Customer("João");
		Product prod = new Product("Camisa manga longa", 35, "100% algodão, estampa a escolher e tecido mais macio do mercado!");
		
		mercado.addCustomer(cus1);
		mercado.addCustomer(cus2);
		mercado.addCustomer(cus3);

		mercado.addProduct(prod);
	}

}
