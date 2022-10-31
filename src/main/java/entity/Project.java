package entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name="title")
    private String title;
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> emplyees;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Project project = (Project) object;
        return id == project.id &&
                Objects.equals(title, project.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title);
    }
}
