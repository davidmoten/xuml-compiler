package moten.david.xuml.model.example.shop;

public class ShopGenerator {

	public static void main(String[] args) throws Exception {
		Shop shop = new Shop();
		String o = "target/shop";
		shop.generate(o, o, o, o);
	}
}
