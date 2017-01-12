package fasade;

import dao.EmployeeDAO;
import model.Employee;

import java.io.Serializable;
import java.util.List;

public class EmployeeFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void createEmployee(Employee employee) {
        employeeDAO.beginTransaction();
        employeeDAO.save(employee);
        employeeDAO.commitAndCloseTransaction();
    }

    public List<Employee> getEmployeeList() {
        employeeDAO.beginTransaction();
        List<Employee> employeeList = employeeDAO.findAll();
        employeeDAO.closeTransaction();

        return employeeList;
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.beginTransaction();
        Employee persistedEmployee = employeeDAO.find(employee.getId());
        persistedEmployee.setFirstName(employee.getFirstName());
        persistedEmployee.setLastName(employee.getLastName());
        persistedEmployee.setSalary(employee.getSalary());
        employeeDAO.commitAndCloseTransaction();
    }


}
