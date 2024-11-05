package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Course;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void remouveCourse(Long numCourse);
    Course retrieveCourse(Long numCourse);
    List<Course> retriveAll();
}
