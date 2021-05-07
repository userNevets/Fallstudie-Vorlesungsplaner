package dhbw.vs.uniplaner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse stellt eine Vorlesung dar.
 */
@Entity
@Table(name = "lecture")
public class Lecture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecture_id;
    private String lectureName;
    private String modulName;
    private Long duration;
    private Course course;

    @OneToMany()
    @JoinTable(
        name = "lecture_lectureDates",
        joinColumns = @JoinColumn(
            name = "lecture_id",
            referencedColumnName = "lecture_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "lectureDates_id",
            referencedColumnName = "id"
        )
    )
    private Set<LectureDate> lectureDates = new HashSet<>();

    @ManyToMany()
    @JoinTable(
        name = "lecture_lectures",
        joinColumns = @JoinColumn(
            name = "lecture_id",
            referencedColumnName = "lecture_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "lecturer_id",
            referencedColumnName = "id"
        )
    )
   private Set<Lecturer> lecturers;
    
    public Lecture() {}

    public Lecture(String lectureName, String modulName, Long duratioon) {
        this.lectureName = lectureName;
        this.modulName = modulName;
        this.duration = duratioon;
    }


    public Long getLecture_id() {
        return this.lecture_id;
    }

    public void setLecture_id(Long lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLectureName() {
        return this.lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getModulName() {
        return this.modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Set<LectureDate> getLectureDates() {
        return this.lectureDates;
    }

    public Lecture addLectureDate(LectureDate lectureDate) {
       lectureDates.add(lectureDate);
       return this;
    }

    public Lecture removeLectureDate(LectureDate lectureDate) {
        lectureDates.remove(lectureDate);
        return this;
    }

    public void setLectureDates(Set<LectureDate> lectureDates) {
        this.lectureDates = lectureDates;
    }

    public Set<Lecturer> getLecturers() {
        return this.lecturers;
    }

    public Lecture addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
        return this;
     }
 
     public Lecture removeLecturer(Lecturer lecturer) {
         lecturers.remove(lecturer);
         return this;
     }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lecture)) {
            return false;
        }
        return lecture_id != null && lecture_id.equals(((Lecture) o).lecture_id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Lecture{" +
            "id=" + getLecture_id() +
            ", lectureName='" + getLectureName() + "'" +
            ", modulName='" + getModulName() + "'" +
            ", duration=" + getDuration() +
            "}";
    }
}
