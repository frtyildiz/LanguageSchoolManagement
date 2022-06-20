package com.firatyildiz.LanguageSchoolManagement.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (AuthenticationManagerBuilder authenticationMB) throws Exception
    {
        authenticationMB.inMemoryAuthentication()
                .withUser("teacher").password("{noop}firat").roles("TEACHER")
                .and()
                .withUser("manager")
                .password("{noop}firat")
                .roles("MANAGER", "TEACHER");

    }

    @Override
    protected void configure (HttpSecurity httpSec) throws Exception
    {
        httpSec.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/student/saveStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/student/findStudent/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET, "/student/findStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/student/updateStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/student/updateStudent/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.POST, "/student/addCourseToStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/student/deleteStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/student/findAllStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/student/findAllStudent/**").hasRole("TEACHER")

                .antMatchers(HttpMethod.POST, "/Classroom/saveClassroom/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/Classroom/findClassroom/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/Classroom/updateClassroom/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/Classroom/addCourseToClassroom/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/Classroom/deleteClassroom/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/Classroom/findAllClassroom/**").hasRole("MANAGER")

                .antMatchers(HttpMethod.POST, "/course/saveCourse/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/course/saveCourseWithoutStudent/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/course/findCourses/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/course/updateCourse/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/course/saveStudentToCourse/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/course/deleteCourse/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/course/findAllCourse/**").hasRole("MANAGER")

                .antMatchers(HttpMethod.POST, "/teacher/saveTeacher/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/teacher/findTeacher/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/teacher/updateTeacher/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/teacher/addCourseToTeacher/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/teacher/deleteTeacher/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/teacher/findAllTeacher/**").hasRole("MANAGER")

                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
