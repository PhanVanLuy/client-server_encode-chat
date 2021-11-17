/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTPT;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public class ThuatToanRSA {
    public byte[] readData(String url)
    {
        try {
	FileInputStream fis = new FileInputStream(url);
	byte[] b = new byte[fis.available()];
	fis.read(b);
	fis.close();
        return b;
        }                
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đọc file");
        }
        return null;
    }
    public String maHoaRSA(String chuoi) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        // Tạo public key
	X509EncodedKeySpec spec = new X509EncodedKeySpec(readData(SecurityKeyPairGenerator.getUrlPublicKey()));
	KeyFactory factory = KeyFactory.getInstance("RSA");
	PublicKey pubKey = factory.generatePublic(spec);
        // Mã hoá dữ liệu
	Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE, pubKey);
	byte encryptOut[] = c.doFinal(chuoi.getBytes());
	return new String(Base64.getEncoder().encodeToString(encryptOut));
    }
    
    public String giaiMaRSA(String chuoiMa) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        // Tạo public key
	PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(readData(SecurityKeyPairGenerator.getUrlPrivateKey()));
	KeyFactory factory = KeyFactory.getInstance("RSA");
	PrivateKey priKey = factory.generatePrivate(spec);

	// Giải mã dữ liệu
	Cipher c = Cipher.getInstance("RSA");
	c.init(Cipher.DECRYPT_MODE, priKey);
	return new String(c.doFinal(Base64.getDecoder().decode(chuoiMa)));
    }
}


