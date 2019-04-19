package wheels;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Singleton.getInstance());
	}

}
class Singleton {
	private Singleton() {}
	public static Singleton getInstance() {
		return Singleton.Nested.Instance();
	}
	private static class Nested {
		private Nested() {}
		private static Singleton Instance() {
			return new Singleton();
		}
	}
}
