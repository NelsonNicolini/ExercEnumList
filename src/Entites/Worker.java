package Entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		for (HourContract c: contracts) {
			cal.setTime(c.getDate());
			int year_c = cal.get(Calendar.YEAR);
			int month_c = 1+cal.get(Calendar.MONTH); // o mes do Calendar comeca com zero, por isso soma 1
			//System.out.println("\nyear_c: "+year_c+", month_c: "+month_c+", year: "+year+", month: "+month);
			if(year == year_c && month == month_c) {
			sum = sum + c.totalValue();
			}
		}
		return sum;
	}
	
	public String toString() {
		
		for (HourContract c : contracts) {
			System.out.println();
			System.out.println("\n Date: "+c.getDate()
			+"\n Hours: "+ c.getHours()
			+"\n Value per hour: "+ c.getValuePerHour());
		}
		return name;
	}

}
