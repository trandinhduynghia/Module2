package services;
import models.Employee;

import java.util.List;

public interface EmployeeService extends ServiceInterface{
    List<Employee> getAllListEmployee();
}
