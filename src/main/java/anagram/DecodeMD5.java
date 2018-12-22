package anagram;

import com.sun.istack.internal.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class DecodeMD5 {

  private static final String MD_5 = "MD5";
  private static final String UTF_8 = "UTF-8";
  private final String hascode;

  public DecodeMD5(@NotNull String hascode) {
    this.hascode = hascode;
  }

  public boolean isMd5MachToSentence(String sentence) {
    return hascode.equalsIgnoreCase(calculateMd5(sentence));
  }

  private String calculateMd5(String sentence) {
    String md5 = "";
    try {
      md5 = DatatypeConverter.printHexBinary(
          MessageDigest.getInstance(MD_5).digest(sentence.getBytes(UTF_8)));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return md5;
  }

}