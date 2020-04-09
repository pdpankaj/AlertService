package com.pankaj.task.dao;

import java.util.List;

import com.pankaj.task.domain.Alert;


public interface AlertDAO {
  Alert add(Alert alert);

  Alert findById(String alertId);

  List<Alert> findAll();

  void deleteById(String alertId);

  int findApplicationId(String alertId);

  void alarmSwitch(String type, boolean isCritical, String alertId);
}
