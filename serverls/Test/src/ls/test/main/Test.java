package ls.test.main;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//        TestBASE64.testCode();
		instantiate(MyClass.class);
	}
	
	public static void instantiate(Class c)
	{
		try {
			c.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
