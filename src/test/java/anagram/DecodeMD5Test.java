package anagram;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DecodeMD5Test {

  private static final String HASH_CODE = "e4820b45d2277f3844eac66c903e84be";

  @Test
  public void shouldReturnTrue() {
    DecodeMD5 decodeMD5 = new DecodeMD5(HASH_CODE);
    assertTrue(decodeMD5.isMd5MachToSentence("printout stout yawls"));
  }
}