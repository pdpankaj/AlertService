package com.pankaj.task.service;

public class LowAlert implements AlertTypeService {

  @Override
  public boolean checkRange(float value) {
    boolean isCritical = false;
    if (value >= 50 && value < 65) {
      isCritical = true;
    }
    return isCritical;
  }

  @Override
  public String alertMessage(float value) {
    String alertMessage = "";
    if (value >= 50 && value <= 60) {
      alertMessage = "Low alert Green. Still its safe. Please monitor the application performance!!";
    } else if (value >= 61 && value < 65) {
      alertMessage = "Low alert Orange. Still its safe. Please monitor the application performance!!.";
    }
    return alertMessage;
  }
}
