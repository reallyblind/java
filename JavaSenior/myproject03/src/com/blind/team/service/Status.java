package com.blind.team.service;
/**
 * 
 * @Description 表示员工状态
 * @author kasssa	
 * @version
 * @date 2022年8月14日上午11:25:17
 *
 */
public class Status {
	private final String NAME;
	
	private Status(String name) {
		this.NAME = name;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VACATION");

	public String getNAME() {
		return NAME;
	}
	
	@Override
	public String toString() {
			// TODO Auto-generated method stub
		return NAME;
	}
	
}
