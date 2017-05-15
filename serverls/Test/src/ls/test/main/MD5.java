package ls.test.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void test()
    {
    	try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] data = "123456".getBytes();
			md5.update(data);
			String o = new String(md5.digest());
			System.out.println("encrypted length:" + md5.digest().length);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    }
}
