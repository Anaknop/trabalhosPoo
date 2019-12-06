package ecommerce;

public class Customer implements ICustomer{
	private String notification;
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void notifyCustomer(Product prod, String shopName) {
		notification = "Bem vindo(a) " + this.name + ", Confira nossos produtos: " + prod.getName() + ". Para mais detalhes veja nosso estoque na " + shopName+"!";
		System.out.println(notification);
	}
	
}
