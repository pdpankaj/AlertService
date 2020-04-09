package com.pankaj.task;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.pankaj.task.service.LowAlert;

public class LowAlertTest {
  LowAlert lowalert = new LowAlert();

  @Test
  public void lowValue96() {
    final boolean actual = lowalert.checkRange(96);
    assertEquals(false, actual);
  }

  @Test
  public void lowValue95() {
    final boolean actual = lowalert.checkRange(95);
    assertEquals(false, actual);
  }

  @Test
  public void lowValue94() {
    final boolean actual = lowalert.checkRange(94);
    assertEquals(false, actual);
  }

  @Test
  public void lowValue91() {
    final boolean actual = lowalert.checkRange(91);
    assertEquals(false, actual);
  }

  @Test
  public void lowValue90() {
    final boolean actual = lowalert.checkRange(90);
    assertEquals(true, actual);
  }

  @Test
  public void lowValue89() {
    final boolean actual = lowalert.checkRange(89);
    assertEquals(true, actual);
  }

  @Test
  public void lowValue71() {
    final boolean actual = lowalert.checkRange(71);
    assertEquals(true, actual);
  }

  @Test
  public void lowValue70() {
    final boolean actual = lowalert.checkRange(70);
    assertEquals(true, actual);
  }

  @Test
  public void lowValue69() {
    final boolean actual = lowalert.checkRange(69);
    assertEquals(true, actual);
  }

  @Test
  public void alertMessageValue69() {
    final String actual = lowalert.alertMessage(69);
    assertEquals("Critical low reading: Extreme lack of oxygen, ischemic diseases may occur.", actual);
  }

  @Test
  public void alertMessageValue70() {
    final String actual = lowalert.alertMessage(70);
    assertEquals("Critical low reading: Hypoxemia. Unhealthy and unsafe level.", actual);
  }

  @Test
  public void alertMessageValue71() {
    final String actual = lowalert.alertMessage(71);
    assertEquals("Critical low reading: Hypoxemia. Unhealthy and unsafe level.", actual);
  }

  @Test
  public void alertMessageValue89() {
    final String actual = lowalert.alertMessage(89);
    assertEquals("Critical low reading: Hypoxemia. Unhealthy and unsafe level.", actual);
  }

  @Test
  public void alertMessageValue90() {
    final String actual = lowalert.alertMessage(90);
    assertEquals("Critical low reading: Hypoxemia. Unhealthy and unsafe level.", actual);
  }

  @Test
  public void alertMessageValue91() {
    final String actual = lowalert.alertMessage(91);
    assertEquals("", actual);
  }
}
