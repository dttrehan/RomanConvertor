package com.adobe.pojo;

public class RomanPair {

	private int key;
	private String value;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public RomanPair(int key, String value) {
        this.key = key;
        this.value = value;
    }
	
}
