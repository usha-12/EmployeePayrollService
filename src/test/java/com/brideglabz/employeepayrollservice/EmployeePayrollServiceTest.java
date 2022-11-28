package com.brideglabz.employeepayrollservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayrollServiceTest<EmployeePayrollService> {
    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployees() throws Exception {
        EmployeePayrollData[] arrayOfEmployees =  {
                new EmployeePayrollData(1,"vinay",1000),
                new EmployeePayrollData(2, "Harika",2000),
                new EmployeePayrollData(3, "Chandu", 3000),
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        Object IOService = null;
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_1O);
        employeePayrollService.printData(IOService.FILE_1O);
        assertEquals(employeePayrollService.countEntries(IOService.FILE_1O), 3);
    }

    @Test
    public void testForReadFileIO() throws Exception {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        Object IOService = null;
        employeePayrollService.readEmployeePayrollData(IOService.FILE_1O);
        assertEquals(employeePayrollService.employeePayRollList.size(), 3);
    }
}
