package com.pankaj.task.service;

import java.util.List;

import com.pankaj.task.domain.Alert;

public interface AlertService {
  String addNewAlert(Alert toBeAdded);

  Alert findById(String alertId);

  List<Alert> findAll();

  int findApplication(String alertId);

  void alarmSwitch(String vital, boolean isCritical, String alertId);

  void deleteAlert(String alertId);

}
