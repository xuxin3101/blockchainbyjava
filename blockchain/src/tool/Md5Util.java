package tool;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
 
public class Md5Util {
 
    private static MessageDigest md5 = null;
 
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    public static String getMd5(String string) {
        try {
            byte[] bs = md5.digest(string.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(40);
            for (byte x : bs) {
                if ((x & 0xff) >> 4 == 0) {
                    sb.append("0").append(Integer.toHexString(x & 0xff));
                } else {
                    sb.append(Integer.toHexString(x & 0xff));
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
 
    public static String getMD5(File file) {
        if (!file.isFile()) {
            throw new RuntimeException(file.getName() + "is not a file!");
        }
        MessageDigest digest;
        byte buffer[] = new byte[1024];
        int len;
        try (FileInputStream in = new FileInputStream(file)) {
            digest = MessageDigest.getInstance("MD5");
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }
 
}
