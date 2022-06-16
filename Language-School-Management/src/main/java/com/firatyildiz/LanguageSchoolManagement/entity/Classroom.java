package com.firatyildiz.LanguageSchoolManagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "classroom_name", length = 40)
    private String classroomName;

    @Column(name = "capacity")
    private byte capacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classroom")
    private List<Course> courses = new ArrayList<>();

}
