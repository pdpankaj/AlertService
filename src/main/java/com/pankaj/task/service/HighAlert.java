package com.pankaj.task.service;

public class HighAlert implements AlertTypeService {

  @Override
  public boolean checkRange(float value) {
    boolean isCritical = false;
    if (value >= 76 && value <= 100) {
      isCritical = true;
    }
    return isCritical;
  }

  @Override
  public String alertMessage(float value) {
    String alertMessage = "";
	if (value >= 76 && value <= 80) {
		alertMessage = "High alert Red. Not safe. Please monitor the application performance!!";
	} else if (value > 80) {
		alertMessage = "High alert Red. System is going down. Please monitor the application performance!!";
	}
    return alertMessage;
  }
}
