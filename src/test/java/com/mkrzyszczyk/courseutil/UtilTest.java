package com.mkrzyszczyk.courseutil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UtilTest {

  /**
   * Method under test: {@link Util#sumNumbers(List)}
   */
  @Test
  void testSumNumbers() {
    // Arrange, Act and Assert
    assertEquals(0, Util.sumNumbers(new ArrayList<>()));
  }

  /**
   * Method under test: {@link Util#sumNumbers(List)}
   */
  @Test
  void testSumNumbers2() {
    // Arrange
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);

    // Act and Assert
    assertEquals(1, Util.sumNumbers(numbers));
  }

  /**
   * Method under test: {@link Util#sumNumbers(List)}
   */
  @Test
  void testSumNumbers3() {
    // Arrange
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);

    // Act and Assert
    assertEquals(3, Util.sumNumbers(numbers));
  }

  @Test
  void test_returns_0_when_given_null_list() {
    try {
      Util.sumNumbers(null);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Input list cannot be null");
    }
  }
}

