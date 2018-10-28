import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class rsa {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub

		String plaintext = " " ;
		
		//Accepting The input from the user and storing it in the buffer
		BufferedReader breader = new BufferedReader( new InputStreamReader(System.in)) ;
		
		//Reading line and transferin it to string variable
		System.out.println("Enter PlainText");
		try {
			plaintext = breader.readLine() ;
			System.out.println("PlainText = " + plaintext ) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Getting instance of RSA in KeyPairGenerattor
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA") ;
		//Setting block size
		gen.initialize(512) ;
		//Generating the Key Pairs - Public Key and Private Key
		KeyPair pair = gen.generateKeyPair() ;
		
		//Getting Public and Private Key
		PublicKey public_key = pair.getPublic() ;
		PrivateKey private_key = pair.getPrivate() ;
		
		//Getting cipher object for encryption and decryption
		Cipher cipher = Cipher.getInstance("RSA") ;
		
		//Enryption
		//Initializing
		cipher.init(Cipher.ENCRYPT_MODE, public_key);
		//Converting plainText to bytes
		byte[] plain_byte = plaintext.getBytes() ;
		//Encrypting step
		byte[] encrypted_data = cipher.doFinal(plain_byte) ;
		
		System.out.println("Encrypted Text = " + encrypted_data);
		
		//Decryption
		//Initializing
		cipher.init(Cipher.DECRYPT_MODE, private_key);
		//Converting encrypted text to decrypted text
		byte[] orginalText = cipher.doFinal(encrypted_data) ;
		
		System.out.println("Decrypted Text = " + new String (orginalText));
		
		
		
	}

}
