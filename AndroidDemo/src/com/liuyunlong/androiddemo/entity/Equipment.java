package com.liuyunlong.androiddemo.entity;

import android.graphics.Bitmap;

/** 
* @author  : liuyunlong
* @version ：2015-9-17 下午3:42:06 
* */
public class Equipment {

	/**产品Id*/
	private Integer deviceId;

	private String deviceName;

	private Integer deviceType;

	private Integer factoryId;

	/**设备Id*/
	private Integer productId;

	private String deviceIcon;

	private Bitmap bitmap;

	public Equipment() {
		super();
	}

	public Equipment(String deviceName, Bitmap bitmap) {
		super();
		this.deviceName = deviceName;
		this.bitmap = bitmap;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDeviceIcon() {
		return deviceIcon;
	}

	public void setDeviceIcon(String deviceIcon) {
		this.deviceIcon = deviceIcon;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	public String toString() {
		return "Equipment [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceType=" + deviceType + ", factoryId=" + factoryId + ", productId=" + productId
				+ ", deviceIcon=" + deviceIcon + ", bitmap=" + bitmap + "]";
	}
}
