package com.blind.team.service;

import com.blind.team.domain.*;


import static com.blind.team.service.Data.*;
/**
 * 
 * @Description 负责将Data中的数据封装到Employee【】数组中，同时提供操作Employee【】方法
 * @author kasssa
 * @version v1.0
 * @date 2022年8月14日下午5:08:11
 *
 */
public class NameListService {
	
	private Employee[] employees;
	/*
	 * 给employees及数组元素进行初始化
	 */
	
	
	public NameListService() {
		
		employees = new Employee[EMPLOYEES.length];
		
		for(int i = 0;i<employees.length;i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus =Double.parseDouble(EMPLOYEES[i][5]); 
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus =Double.parseDouble(EMPLOYEES[i][5]); 
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
		
	}
	/**
	 * 
	 * @Description 获取指定index位置上员工的设备
	 * @author blind
	 * @date 2022年8月15日上午11:25:57
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]) ;
		String modelOrName = EQUIPMENTS[index][1];
		
		switch(key) {
		case PC:
			
			return new PC(modelOrName,EQUIPMENTS[index][2]);
		case NOTEBOOK:
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName,price);
		case PRINTER:
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName,type);
		}
		
		return null;
	}
	public Employee[] getAllEmployees() {
		return employees;
	}
	public Employee getEmployee (int id)throws TeamException {
		for(int i = 0;i<employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定员工");
	}
	
}
