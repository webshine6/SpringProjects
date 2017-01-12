package dao;

import model.Employee;

public class EmployeeDAO extends GenericDAO<Employee> {

    public EmployeeDAO() {
        super(Employee.class);
    }

}
