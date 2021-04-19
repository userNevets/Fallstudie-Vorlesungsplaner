package dhbw.vs.uniplaner.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse stellt einen Studiengang (z.B. Wirtschaftsinformatik) in der Hochschule dar.
 */
@Entity
@Table(name = "degree_program")
public class DegreeProgram implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deg_id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @OneToMany(mappedBy = "degreeProgram")
    private Set<Course> courses = new HashSet<>();

    protected DegreeProgram() {}

    public DegreeProgram(String name, String shortName, Set<Course> courses) {
        this.name = name;
        this.shortName = shortName;
    }

    public Long getDeg_id() {
        return this.deg_id;
    }

    public void setDeg_id(Long deg_id) {
        this.deg_id = deg_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public DegreeProgram addCourse(Course course) {
        this.courses.add(course);
        return this;
    }

    public DegreeProgram removeCourse(Course course) {
        this.courses.remove(course);
        return this;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DegreeProgram)) {
            return false;
        }
        return deg_id != null && deg_id.equals(((DegreeProgram) o).deg_id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "DegreeProgram{" +
            "id=" + getDeg_id() +
            ", name='" + getName() + "'" +
            ", shortName='" + getShortName() + "'" +
            "}";
    }
}
