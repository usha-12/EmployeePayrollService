package com.brideglabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceTest {
    public static Scanner userInputScanner = new Scanner(System.in);
    private enum IOService {
        CONSOLE_IO, FILE_1O, DB_IO, REST_IO
    }

    public List<EmployeePayrollData> employeePayRollList;

    public  EmployeeServiceTest() {
    }

    public EmployeeServiceTest(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayRollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeeServiceTest employeePayrollService = new  EmployeeServiceTest(employeePayrollList);
        employeePayrollService.readEmployeePayrollData();
        employeePayrollService.writeEmployeePayrollData();
    }

    public void readEmployeePayrollData() {
        System.out.println("Enter Employee Id : ");
        int id = userInputScanner.nextInt();
        userInputScanner.nextLine();
        System.out.println("Enter Employee Name : ");
        String name = userInputScanner.nextLine();
        System.out.println("Enter salary");
        int salary = userInputScanner.nextInt();
        employeePayRollList.add(new EmployeePayrollData(id, name, salary));

    }
    public void writeEmployeePayrollData() {
        System.out.println("Writing Employee Payroll Roaster to console :" + employeePayRollList);
    }

}
