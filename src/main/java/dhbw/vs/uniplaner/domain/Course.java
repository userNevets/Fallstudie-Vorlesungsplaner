package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse stellt Kurs (z.B. WWI2020D) in der Hochschule dar.
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private Date startDate;
    private Date endDate;

    @ManyToMany
    @JoinTable(
        name = "course_degree",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "degree_id",
            referencedColumnName = "deg_id"
        )
    )
    Set<DegreeProgram> degreePrograms = new HashSet<>();

    @OneToMany()
    @JoinTable(
        name = "course_lectures",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "lecture_id",
            referencedColumnName = "lecture_id"
        )
    )
    Set<Lecture> lectures = new HashSet<>();
    
    @OneToMany()
    @JoinTable(
        name = "course_semester",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "semester_id",
            referencedColumnName = "id"
        )
    )
    Set<Semester> semesters = new HashSet<>();
    
    // @ManyToOne
    // @JoinColumn(name = "id", nullable = false)
    private DegreeProgram degreeProgram;

    public Course(){}

    public Course(String courseName, Date startDate, Date endDate) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long course_id) {
        this.id = course_id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Lecture> getLectures() {
        return this.lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Set<Semester> getSemesters() {
        return this.semesters;
    }

    public void setSemesters(Set<Semester> semesters) {
        this.semesters = semesters;
    }

    public DegreeProgram getDegreeProgram() {
        return this.degreeProgram;
    }

    public void setDegreeProgram(DegreeProgram degreeProgram) {
        this.degreeProgram = degreeProgram;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Course)) {
            return false;
        }
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Course{" +
            "id=" + getId() +
            ", courseName='" + getCourseName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }

    public void setStartingYear(long l) {
    }
}
