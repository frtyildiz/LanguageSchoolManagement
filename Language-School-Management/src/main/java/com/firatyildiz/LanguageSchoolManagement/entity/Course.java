package com.firatyildiz.LanguageSchoolManagement.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "course_name", length = 75)
    private String courseName;

    @NotNull
    @Column(name = "course_level", length = 75)
    private String courseLevel;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "capacity")
    private int capacity;

    @Lob
    @Column(name = "courses_materials")
    private byte[] materials;

    @ManyToOne
    @JoinColumn
    private Classroom classroom;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public int getCapacity() {
        return capacity - students.size();
    }

    public void setCapacity(int capacity) {
        Classroom classr = new Classroom();
        this.capacity = classr.getCapacity();
    }
}
