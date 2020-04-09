package com.pankaj.task.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.task.dao.AlertDAO;
import com.pankaj.task.domain.Alert;

@Service
public class AlertServiceImpl implements AlertService {
  @Autowired
  AlertDAO alertDAO;

  @Override
  public String addNewAlert(Alert toBeAdded) {
    final Alert added = alertDAO.add(toBeAdded);
    return added.getAlertId();
  }

  @Override
  public Alert findById(String alertId) {
    return alertDAO.findById(alertId);
  }

  @Override
  public List<Alert> findAll() {
    return alertDAO.findAll();
  }

  @Override
  public int findApplication(String alertId) {
    return alertDAO.findApplicationId(alertId);
  }

  @Override
  public void alarmSwitch(String type, boolean isCritical, String patientId) {
    alertDAO.alarmSwitch(type, isCritical, patientId);
  }

  @Override
  public void deleteAlert(String alertId) {
    alertDAO.deleteById(alertId);
  }

}
