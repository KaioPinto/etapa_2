package br.com.unifacisa.mondoDB.model;

public class Produto {
	private String description;
	private float price;
	private int id;

	public Produto(String description, float price, int id) {
		this.description = description;
		this.price = price;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produto [description=" + description + ", price=" + price + ", id=" + id + "]";
	}
	

}
