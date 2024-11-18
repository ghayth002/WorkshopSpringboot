package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Instructor;
import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    void removeInstructor(Long numInstructor);
    Instructor retrieveInstructor(Long numInstructor);
    List<Instructor> getAllInstructors();
    Instructor addInstructorToCourse( Instructor instructorn,List<Long>numCourses);

    Instructor addInstructorAndAssignToCourses(Instructor instructor);
}
