package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "birthday")
    private Date birthday;
    //employee - название поля (FK) из Address
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;
    //owner - название поля (FK) из Order
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Item> items;

    //FetchType.LAZY - при загрузке Employee не будут загружаться в память projects. Они будут загружены только по
    //требованию, например при getProjects()
    //в данном случае указывать FetchType.LAZY не обязательно т.к. для ManyToMany загрузка по умолчанию LAZY
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "empl_proj",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Employee employee = (Employee) object;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(secondName, employee.secondName) &&
                Objects.equals(birthday, employee.birthday) &&
                Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, secondName, birthday, address);
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        item.setOwner(this);
    }

    public void setAddress(Address address){
        this.address = address;
        this.address.setEmployee(this);
    }
}
