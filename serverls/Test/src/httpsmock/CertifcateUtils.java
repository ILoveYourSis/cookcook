package httpsmock;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;

public class CertifcateUtils {
	public static byte[] readCertificates() throws Exception
    {
    	CertificateFactory factory = CertificateFactory.getInstance("X.509");
    	InputStream in = new FileInputStream("c:/https.crt");
    	java.security.cert.Certificate cate = factory.generateCertificate(in);
    	return cate.getEncoded();
    }
	
	public static byte[] readPrivateKey() throws Exception
	{
		KeyStore store = KeyStore.getInstance("JKS");
		InputStream in = new FileInputStream("c:/https.keystore");
		store.load(in, "fuckpig".toCharArray());
		PrivateKey pk = (PrivateKey)store.getKey("ls", "fuckpig".toCharArray());
		return pk.getEncoded();
	}
	
	public static PrivateKey readPrivateKeys() throws Exception
	{
		KeyStore store = KeyStore.getInstance("JKS");
		InputStream in = new FileInputStream("c:/https.keystore");
		store.load(in, "fuckpig".toCharArray());
		PrivateKey pk = (PrivateKey)store.getKey("ls", "fuckpig".toCharArray());
		return pk;
	}
	
	public static PublicKey readPublicKeys() throws Exception
	{
		CertificateFactory factory  = CertificateFactory.getInstance("X.509");
		InputStream in = new FileInputStream("c:/https.crt");
		java.security.cert.Certificate cate = factory.generateCertificate(in);
		return cate.getPublicKey();
	}
	
	
}
