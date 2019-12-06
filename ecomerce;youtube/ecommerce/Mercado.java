package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Mercado implements IMercado {
	private String name;
	private List<Customer> customers;
	private List<Product> products;
	
	public Mercado(String name) {
		this.name = name;
		customers = new ArrayList<>();
		products = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void addProduct(Product product) {
		products.add(product);
		notifyCustomer(product);
	}
	
	@Override
	public void addCustomer(Customer cus) {
		customers.add(cus);
	}

	@Override
	public void desattachCustomer(Customer cus) {
		customers.remove(cus);
	}

	@Override
	public void notifyCustomer(Product product) {
		for(Customer cus: customers) {
			cus.notifyCustomer(product, getName());
		}
		
	}

}
