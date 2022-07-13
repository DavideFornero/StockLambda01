package entities;

import java.util.Objects;

public class Stock {
	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;

	public Stock(Integer id, String name, Double price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double totalValueInStock() {
		return price * quantity;
	}

	public void addStock(Integer quantity) {

		if (quantity < 0 || quantity > 500) {
			System.out.println("Invalid quantity!!");
		} else {
			this.quantity += quantity;
			if (this.quantity > 500) {
				System.out.println("Invalid quantity, maximum quantity is 500, the stock has been updated automatically and the remaining quantity is " + (this.quantity - 500));
                this.quantity = 500;
            }
			 
			}
		}

	

	public void removeStock(Integer quantity) {
		if (quantity< 0 || quantity > 500) {
			System.out.println("Invalid quantity!!");
		} else {
			this.quantity -= quantity;
			if (this.quantity < 0) {
				System.out.println("Invalid quantity, stock cannot be negative.");
                this.quantity = 0;
            }
		
			}
		}

	
	

	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        result = prime * result + ((price == null) ? 0 : price.hashCode());
	        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
	        return result;
	    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(quantity, other.quantity);
	}

	public String toString() {
		return "ID " + id + " , " + name + ", $" + String.format("%.2f", price) + ", " + quantity + " units, Total: $"
				+ String.format("%.2f", totalValueInStock());
	}

}
