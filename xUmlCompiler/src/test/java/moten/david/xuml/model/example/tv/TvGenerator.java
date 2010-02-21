package moten.david.xuml.model.example.tv;

public class TvGenerator {

	public static void main(String[] args) throws Exception {
		Tv tv = new Tv();
		String o = "target/tv";
		tv.generate(o, o, o, o);
	}
}
