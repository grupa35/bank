package currency;

public class Currency {
	private String code;
	private String name;
	private double multiplier;
	private double price;

	public Currency(String name, double multiplier, String code, double price) {
		this.name = name;
		this.multiplier = multiplier;
		this.code = code;
		this.price = price;
	}
	
	public Currency() {};

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getMultiplier() {
		return multiplier;
	}

	public double getPrice() {
		return price;
	}

	void setCode(String code) {
		this.code = code;
	}

	void setName(String name) {
		this.name = name;
	}

	void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	void setPrice(double price) {
		this.price = price;
	}
}
