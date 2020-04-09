package com.pankaj.task.service;

public interface AlertTypeService {
  boolean checkRange(float value);
  String alertMessage(float value);
}