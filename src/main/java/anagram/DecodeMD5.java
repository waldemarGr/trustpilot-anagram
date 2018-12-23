package anagram;

import com.sun.istack.internal.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class DecodeMD5 {

  private static final String MD_5 = "MD5";
  private final String hashcode;

  public DecodeMD5(@NotNull String hashcode) {
    this.hashcode = hashcode;
  }

  public boolean isMd5MachToSentence(String sentence) {
    return hashcode.equalsIgnoreCase(calculateMd5(sentence));
  }

  private String calculateMd5(String sentence) {
    String md5 = "";
    try {
      md5 = DatatypeConverter.printHexBinary(
          MessageDigest.getInstance(MD_5).digest(sentence.getBytes(StandardCharsets.UTF_8)));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return md5;
  }

}