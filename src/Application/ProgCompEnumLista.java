package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


import Entites.Department;
import Entites.HourContract;
import Entites.Worker;
import entities.enums.WorkerLevel;

public class ProgCompEnumLista {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter Department's name: ");
		String DepName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String WorkName = sc.nextLine();
		System.out.print("Level: ");
		String Level = sc.nextLine();
		System.out.print("Base Salary: ");
		Double BaseSalary = sc.nextDouble();
		
		
		Worker worker = new Worker(WorkName,WorkerLevel.valueOf(Level),BaseSalary,new Department(DepName));
		
		System.out.print("How many contracts to this worker?: ");
		Integer numContr = sc.nextInt();
		
		for (int i=0; i<numContr; i++) {
			
			System.out.println("Enter contract #"+(i+1)+" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contrDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double hourValue = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer dur = sc.nextInt();
			
			HourContract hc = new HourContract(contrDate, hourValue, dur);
			worker.addContract(hc);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String my = sc.next();
		Integer month = Integer.parseInt(my.substring(0,2));
		Integer year = Integer.parseInt(my.substring(3,7)); // poderia ser substring(3) somente, pois pegaria ateh o final
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+my+": R$ "+String.format("%.2f", worker.income(year, month)));
		
		
		//System.out.println(worker.toString());
	
		sc.close();

	}

}
