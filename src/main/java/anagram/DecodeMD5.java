package anagram;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecodeMD5 {

  private static final String MD_5 = "MD5";
  private final String hashcode;
  private final Logger LOGGER = LogManager.getLogger(DecodeMD5.class);

  public DecodeMD5(String hashcode) {
    this.hashcode = hashcode;
  }

  public boolean isMd5MachToSentence(String sentence) {
    return hashcode.equalsIgnoreCase(calculateMd5(sentence));
  }

  private String calculateMd5(String sentence) {
    String md5 = "";
    try {
      md5 = DatatypeConverter.printHexBinary(
          MessageDigest.getInstance(MD_5).digest(sentence.getBytes(UTF_8)));
    } catch (NoSuchAlgorithmException e) {
      LOGGER.warn("Problem with calculate md5 for: " + sentence, e);
    }
    return md5;
  }

}