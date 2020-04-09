package com.pankaj.task;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pankaj.task.controller.AlertController;
import com.pankaj.task.domain.Alert;
import com.pankaj.task.service.AlertService;

public class AlertControllerTest {

  @Test
  public void deleteNonExistingAlert() {
    final AlertController alertController = new AlertController();
    final AlertService service = Mockito.mock(AlertService.class);
    Mockito.when(service.findById("Alert0")).thenReturn(null);
    alertController.setService(service);
    final ResponseEntity<Alert> response = alertController.deleteAlert("Alert0");
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  public void deleteExistingAlert() {
    final AlertController controller = new AlertController();
    final AlertService service = Mockito.mock(AlertService.class);
    Mockito.when(service.findById("Alert2")).thenReturn(Mockito.mock(Alert.class));
    controller.setService(service);
    final ResponseEntity<Alert> response = controller.deleteAlert("Alert2");
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }

  @Test
  public void monitorAlertTypeForNonExistingAlert() {
    final AlertController controller = new AlertController();
    final AlertService service = Mockito.mock(AlertService.class);
    Mockito.when(service.findById("Alert1")).thenReturn(null);
    controller.setService(service);
    final ResponseEntity<List<String>> response = controller.monitorAlertType("Alert1", Mockito.mock(Alert.class));
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void monitorHighAlert() {
    final AlertController controller = new AlertController();
    final AlertService service = Mockito.mock(AlertService.class);
    Mockito.when(service.findById("Alert1")).thenReturn(Mockito.mock(Alert.class));
    controller.setService(service);
    final Alert alert = new Alert();
    alert.setHighValue(104.0f);
    alert.setMediumValue(100.f);
    alert.setLowValue(45.0f);
    final ResponseEntity<List<String>> response = controller.monitorAlertType("Alert1", alert);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void monitorMediumAlert() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert1")).thenReturn(Mockito.mock(Alert.class));
    pc.setService(ps);
    final Alert alert = new Alert();
    alert.setHighValue(97.0f);
    alert.setMediumValue(30.f);
    alert.setLowValue(45.0f);
    final ResponseEntity<List<String>> response = pc.monitorAlertType("Alert1", alert);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void monitorLowAlert() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert1")).thenReturn(Mockito.mock(Alert.class));
    pc.setService(ps);
    final Alert alert = new Alert();
    alert.setHighValue(97.0f);
    alert.setMediumValue(100.f);
    alert.setLowValue(20.0f);
    final ResponseEntity<List<String>> response = pc.monitorAlertType("Alert1", alert);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void turnOffAlarmForNonExistingAlert() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert0")).thenReturn(null);
    pc.setService(ps);
    final ResponseEntity<Alert> response = pc.turnOffAlarm("Alert0","high");
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void turnOffHighAlertAlarm() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert2")).thenReturn(Mockito.mock(Alert.class));
    pc.setService(ps);
    final ResponseEntity<Alert> response = pc.turnOffAlarm("Alert2","high");
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void turnOffMediumAlarm() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert2")).thenReturn(Mockito.mock(Alert.class));
    pc.setService(ps);
    final ResponseEntity<Alert> response = pc.turnOffAlarm("Alert2","medium");
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void turnOffLowAlarm() {
    final AlertController pc = new AlertController();
    final AlertService ps = Mockito.mock(AlertService.class);
    Mockito.when(ps.findById("Alert2")).thenReturn(Mockito.mock(Alert.class));
    pc.setService(ps);
    final ResponseEntity<Alert> response = pc.turnOffAlarm("Alert2","low");
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
}
