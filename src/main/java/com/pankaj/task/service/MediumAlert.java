package com.pankaj.task.service;

public class MediumAlert implements AlertTypeService {

	@Override
	public boolean checkRange(float value) {
		boolean isCritical = false;
		if (value >= 66 && value < 75) {
			isCritical = true;
		}
		return isCritical;
	}

	@Override
	public String alertMessage(float value) {
		String alertMessage = "";
		if (value >= 66 && value <= 70) {
			alertMessage = "Medium alert Green. Still its safe. Please monitor the application performance!!";
		} else if (value >= 71 && value < 75) {
			alertMessage = "Medium alert Orange. Not safe. Please monitor the application performance!!";
		}
		return alertMessage;
	}
}