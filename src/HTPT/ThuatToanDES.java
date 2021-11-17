/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTPT;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author USER
 */
public class ThuatToanDES {
    private static String mySecret_key = "12345678";//Bội số của 8
   
    public String maHoaDES(String chuoiPhanSo)
    {
        String encrypted = "";
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(mySecret_key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(chuoiPhanSo.getBytes("UTF-8")));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể thực hiện mã hóa");
            return null;
        }
    }
    
    public String giaiMaDES(String chuoiMa)
    {
        String decrypted = "";
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(mySecret_key.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(chuoiMa))); 
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể thực hiện giải mã");
            return null;
        }
    }
    public static void main(String[] args) {
        String str="Giai ma de";
        ThuatToanDES d= new ThuatToanDES();
        str=d.maHoaDES(str);
        System.out.println("Chuỗi đã mã hóa: "+ str);
        
        
        str=d.giaiMaDES(str);
        System.out.println("Chuỗi đã giải mã hóa: "+ str);
        
        
    }
}
