package com.pankaj.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Alert {
	@Id
	@Column(name = "alert_id")
	private String alertId;
	@Column
	private String name;
	@Column(name = "high_alert")
	private boolean highAlert;
	@Column(name = "medium_alert")
	private boolean mediumAlert;
	@Column(name = "low_alert")
	private boolean lowAlert;
	@Column(name = "app_id")
	private int appId;
	@Transient
	private float high;
	@Transient
	private float medium;
	@Transient
	private float low;

	public Alert() {

	}

	public Alert(String alertId, String name, int appId) {
		super();
		this.alertId = alertId;
		this.name = name;
		this.appId = appId;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public float getHighValue() {
		return high;
	}

	public float getMediumValue() {
		return medium;
	}

	public float getLowValue() {
		return low;
	}

	public void setHighValue(float high) {
		this.high = high;
	}

	public void setMediumValue(float medium) {
		this.medium = medium;
	}

	public void setLowValue(float low) {
		this.low = low;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public boolean isHighAlert() {
		return highAlert;
	}

	public void setHighAlert(boolean highAlert) {
		this.highAlert = highAlert;
	}

	public boolean isMediumAlert() {
		return mediumAlert;
	}

	public void setMediumAlert(boolean mediumAlert) {
		this.mediumAlert = mediumAlert;
	}

	public boolean isLowAlert() {
		return lowAlert;
	}

	public void setLowAlert(boolean lowAlert) {
		this.lowAlert = lowAlert;
	}

	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", name=" + name + ", high_alert_value=" + high + ", medium_alert_value="
				+ medium + ", low_alert_value=" + low + "]";
	}
}
