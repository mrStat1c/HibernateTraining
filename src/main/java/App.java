import businessLogic.DbConnectionProvider;
import entity.Address;
import entity.Employee;
import entity.Item;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ItemService;
import service.ProjectService;

import java.util.*;

public class App {

    public static void main(String[] args) {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        ItemService itemService = new ItemService();

        Employee employee = new Employee();
        employee.setFirstName("gdgdfg");
        employee.setSecondName("dgdfgdfg");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1955, Calendar.MAY, 4);
        employee.setBirthday(new Date(calendar.getTime().getTime()));

        Address address = new Address();
        address.setCountry("dfgdfg");
        address.setCity("gdgdf");
        address.setStreet("gdfgg");
        address.setPostCode("12345");
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("dsfsdf");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmplyees(employees);
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        Item item1 = new Item();
        item1.setName("item1");
        Item item2 = new Item();
        item2.setName("item2");
        Item item3 = new Item();
        item3.setName("item3");
        employee.addItem(item1);
        employee.addItem(item2);
        employee.addItem(item3);

        employeeService.add(employee);
        projectService.add(project);
//       Address и Items в бд создается в момент создания employee (каскадирование)

//      Удаление одного Item
        itemService.remove(item2);

//      Обновление объекта
        employee = employeeService.getById(employee.getId());
        employee.setFirstName("Neo");
        employeeService.update(employee);

// здесь будет ошибка т.к.
//        System.out.println(employee);

        DbConnectionProvider.shutdown();
    }
}
