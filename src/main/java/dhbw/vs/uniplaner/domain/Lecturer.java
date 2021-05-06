package dhbw.vs.uniplaner.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse dient dazu, Dozenten darzustellen
 */
@Entity
@Table(name = "lecturer")
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String LastName;
    private String email;

    // Set<LectureDate> lectureDates;

    @ManyToMany
    @JoinTable(
        name = "lecturer_lectures",
        joinColumns = @JoinColumn(
            name = "lecturer_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "lecture_id",
            referencedColumnName = "lecture_id"
        )
    )
    private Set<Lecture> lectures = new HashSet<>();
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public Set<LectureDate> getLectureDates() {
    //     return this.lectureDates;
    // }

    // public Lecturer addLectureDate(LectureDate lectureDate) {
    //     this.lectureDates.add(lectureDate);
    //     return this;
    // }

    // public Lecturer removeLectureDate(LectureDate lectureDate) {
    //     this.lectureDates.remove(lectureDate);
    //     return this;
    // }

    // public void setLectureDates(Set<LectureDate> lectureDates) {
    //     this.lectureDates = lectureDates;
    // }

    public Lecturer addLecture(Lecture lecture) {
        this.lectures.add(lecture);
        return this;
    }

    public Lecturer removeLecture(Lecture lecture) {
        this.lectures.remove(lecture);
        return this;
    }

    public Set<Lecture> getLectures() {
        return this.lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lecturer)) {
            return false;
        }
        return id != null && id.equals(((Lecturer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


    @Override
    public String toString() {
        return "Lecturer{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
