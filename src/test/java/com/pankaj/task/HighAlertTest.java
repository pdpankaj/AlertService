package com.pankaj.task;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.pankaj.task.service.HighAlert;

public class HighAlertTest {
  HighAlert highAlert = new HighAlert();
  @Test
  public void highAlertValue70() {
    final boolean actual = highAlert.checkRange(70);
    assertEquals(false, actual);
  }

  @Test
  public void highAlertValue74() {
    final boolean actual = highAlert.checkRange(74);
    assertEquals(false, actual);
  }

  @Test
  public void highAlertValue75() {
    final boolean actual = highAlert.checkRange(75);
    assertEquals(false, actual);
  }

  @Test
  public void highAlertValue755() {
    final boolean actual = highAlert.checkRange(75.5f);
    assertEquals(false, actual);
  }

  @Test
  public void highAlertValue765() {
    final boolean actual = highAlert.checkRange(76.5f);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue785() {
    final boolean actual = highAlert.checkRange(78.5f);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue80() {
    final boolean actual = highAlert.checkRange(80);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue81() {
    final boolean actual = highAlert.checkRange(81);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue85() {
    final boolean actual = highAlert.checkRange(85);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue90() {
    final boolean actual = highAlert.checkRange(90);
    assertEquals(true, actual);
  }

  @Test
  public void highAlertValue100() {
    final boolean actual = highAlert.checkRange(100);
    assertEquals(true, actual);
  }

  @Test
  public void alertMessageValue765() {
    final String actual = highAlert.alertMessage(76.5f);
    assertEquals("High alert Red. Not safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue80() {
    final String actual = highAlert.alertMessage(80);
    assertEquals("High alert Red. Not safe. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue81() {
    final String actual = highAlert.alertMessage(81);
    assertEquals("High alert Red. System is going down. Please monitor the application performance!!", actual);
  }

  @Test
  public void alertMessageValue90() {
    final String actual = highAlert.alertMessage(90);
    assertEquals("High alert Red. System is going down. Please monitor the application performance!!", actual);
  }
}