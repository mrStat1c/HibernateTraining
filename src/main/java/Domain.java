import businessLogic.DbConnectionProvider;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("dfgdfg");
        address.setCity("gdgdf");
        address.setStreet("gdfgg");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("dsfsdf");

        Employee employee = new Employee();
        employee.setFirstName("gdgdfg");
        employee.setSecondName("dgdfgdfg");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1955, Calendar.MAY, 4);
        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmplyees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        Address address1 = addressService.getById(1);
        System.out.println(address1);

        DbConnectionProvider.shutdown();
    }
}
