package mb;

import fasade.EmployeeFacade;
import model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean
public class EmployeeMB implements Serializable {

    private static final long serialVersionID = 1L;

    private Employee employee;
    private List<Employee> employeeList;

    private EmployeeFacade employeeFacade;

    public EmployeeFacade getEmployeeFacade() {
        if (employeeFacade == null) {
            employeeFacade = new EmployeeFacade();
        }
        return employeeFacade;
    }


    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }

        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void createEmployee() {
        try {
            getEmployeeFacade().createEmployee(employee);
            loadEmployeeList();
            resetEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            loadEmployeeList();
        }
        return employeeList;
    }

    public void loadEmployeeList() {
        employeeList = getEmployeeFacade().getEmployeeList();
    }

    public void resetEmployee() {
        employee = new Employee();
    }

    public void updateEmployee() {
        try {
            getEmployeeFacade().updateEmployee(employee);
            loadEmployeeList();
            resetEmployee();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
