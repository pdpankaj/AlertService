package com.pankaj.task.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.task.domain.Alert;
import com.pankaj.task.service.AlertService;
import com.pankaj.task.service.HighAlert;
import com.pankaj.task.service.MediumAlert;
import com.pankaj.task.service.LowAlert;

@RestController
public class AlertController {
  AlertService service;

  @Autowired
  public void setService(AlertService service) {
    this.service = service;
  }

  @PostMapping(value = "/api/alert")
  public ResponseEntity<Alert> addAlert(@RequestBody Alert toBeAdded) {
    try {
      final String id = service.addNewAlert(toBeAdded);
      final HttpHeaders headers = new HttpHeaders();
      headers.setLocation(URI.create("/api/alert/" + id));
      return new ResponseEntity<>(headers, HttpStatus.CREATED);
    } catch (final IllegalArgumentException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/api/alert/app/{alertId}")
  public int findAlertApplication(@PathVariable("alertId") String alertId) {
    return service.findApplication(alertId);
  }

  @GetMapping(value = "/api/alert")
  public List<Alert> displayRecords() {
    return service.findAll();
  }

  @DeleteMapping(value = "/api/alert/{alertId}")
  public ResponseEntity<Alert> deleteAlert(@PathVariable("alertId") String alertId) {
    final Alert alert = service.findById(alertId);
    if (alert != null) {
      service.deleteAlert(alertId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value = "/api/alert/{alertId}/alerttype")
  public ResponseEntity<List<String>> monitorAlertType(@PathVariable("alertId") String alertId,
      @RequestBody Alert alerttype) {
    final HighAlert highAlert = new HighAlert();
    final MediumAlert mediumAlert = new MediumAlert();
    final LowAlert lowAlert = new LowAlert();
    final Alert alert = service.findById(alertId);
    final List<String> alerts = new ArrayList<>();
    if (alert != null) {
      if (highAlert.checkRange(alerttype.getHighValue())) {
        service.alarmSwitch("high", true, alertId);
        alerts.add(highAlert.alertMessage(alerttype.getHighValue()));
      }
      if (mediumAlert.checkRange(alerttype.getMediumValue())) {
        service.alarmSwitch("medium", true, alertId);
        alerts.add(mediumAlert.alertMessage(alerttype.getMediumValue()));
      }
      if (lowAlert.checkRange(alerttype.getLowValue())) {
        service.alarmSwitch("low", true, alertId);
        alerts.add(lowAlert.alertMessage(alerttype.getLowValue()));
      }
      return new ResponseEntity<>(alerts, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/api/alert/{alertId}/alarm/{type}")
  public ResponseEntity<Alert> turnOffAlarm(@PathVariable String alertId,
      @PathVariable String type) {
    final Alert alert = service.findById(alertId);
    if (alert != null) {
      if (type.equals("high")) {
        service.alarmSwitch("high", false, alertId);
        return new ResponseEntity<>(HttpStatus.OK);
      } else if (type.equals("medium")) {
        service.alarmSwitch("medium", false, alertId);
        return new ResponseEntity<>(HttpStatus.OK);
      } else if (type.equals("low")) {
        service.alarmSwitch("low", false, alertId);
        return new ResponseEntity<>(HttpStatus.OK);
      }
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

}
