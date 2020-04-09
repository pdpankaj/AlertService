package com.pankaj.task;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pankaj.task.service.MediumAlert;

public class MediumAlertTest {
	MediumAlert medium = new MediumAlert();;
  @Test
  public void pulseRateValue66() {
    final boolean actual = medium.checkRange(66);
    assertEquals(true, actual);
  }

  @Test
  public void pulseRateValue60() {
    final boolean actual = medium.checkRange(60);
    assertEquals(false, actual);
  }

  @Test
  public void pulseRateValue61() {
    final boolean actual = medium.checkRange(61);
    assertEquals(false, actual);
  }

  @Test
  public void pulseRateValue75() {
    final boolean actual = medium.checkRange(75);
    assertEquals(false, actual);
  }

  @Test
  public void pulseRateValue100() {
    final boolean actual = medium.checkRange(100);
    assertEquals(false, actual);
  }

  @Test
  public void pulseRateValue70() {
    final boolean actual = medium.checkRange(70);
    assertEquals(true, actual);
  }

  @Test
  public void pulseRateValue74() {
    final boolean actual = medium.checkRange(74);
    assertEquals(true, actual);
  }

  @Test
  public void alertMessageValue66() {
    final String actual = medium.alertMessage(66);
    assertEquals("Medium alert Green. Still its safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue40() {
    final String actual = medium.alertMessage(40);
    assertEquals("", actual);
  }

  @Test
  public void alertMessageValue41() {
    final String actual = medium.alertMessage(41);
    assertEquals("", actual);
  }

  @Test
  public void alertMessageValue99() {
    final String actual = medium.alertMessage(99);
    assertEquals("", actual);
  }

  @Test
  public void alertMessageValue100() {
    final String actual = medium.alertMessage(100);
    assertEquals("", actual);
  }

  @Test
  public void alertMessageValue70() {
    final String actual = medium.alertMessage(70);
    assertEquals("Medium alert Green. Still its safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue73() {
    final String actual = medium.alertMessage(73);
    assertEquals("Medium alert Orange. Not safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue74() {
    final String actual = medium.alertMessage(74);
    assertEquals("Medium alert Orange. Not safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue75() {
    final String actual = medium.alertMessage(75);
    assertEquals("", actual);
  }
}