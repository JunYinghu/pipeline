package test.cicd.project;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
    /**
     * encryptBASE64
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);

    }
    public static String decryptBase64(String key) throws Exception{
        byte result[] = (new BASE64Decoder()).decodeBuffer(key);
        return new String(result);
    }
    /**
     * encryptBASE64
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
    public static void main(String[] args) {
        String  str="8B4VYzzc";
        try {
            String  result1= Base64.encryptBASE64(str.getBytes());
            System.out.println("result1=====encryptBASE64=========="+result1);
            byte  result2[]= Base64.decryptBASE64(result1);
            String  str2=new String(result2);
            System.out.println("str2========decryptBASE64========"+str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
