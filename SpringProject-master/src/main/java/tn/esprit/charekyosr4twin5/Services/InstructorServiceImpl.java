package tn.esprit.charekyosr4twin5.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.entities.Course;
import tn.esprit.charekyosr4twin5.entities.Instructor;
import tn.esprit.charekyosr4twin5.Repositories.ICourseRepository;
import tn.esprit.charekyosr4twin5.Repositories.IInstructorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements IInstructorService {

    private final IInstructorRepository instructorRepository;
    private final ICourseRepository courseRepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void removeInstructor(Long numInstructor) {
        instructorRepository.deleteById(numInstructor);
    }

    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructorToCourse(Instructor instructor, List<Long> numCourses) {
        // Check if the instructor already exists
        Optional<Instructor> existingInstructorOpt = instructorRepository.findById(instructor.getNumInstructor());
        Instructor savedInstructor;

        if (existingInstructorOpt.isPresent()) {
            // If the instructor exists, use the existing instructor
            savedInstructor = existingInstructorOpt.get();
        } else {
            // Save the new instructor
            savedInstructor = instructorRepository.save(instructor);
        }

        for (Long numCourse : numCourses) {
            Optional<Course> courseOpt = courseRepository.findById(numCourse);
            if (courseOpt.isPresent()) {
                Course course = courseOpt.get();
                savedInstructor.getCourses().add(course);
                course.setInstructor(savedInstructor);
                courseRepository.save(course);
            }
        }
        return savedInstructor;
    }
    @Override
    public Instructor addInstructorAndAssignToCourses(Instructor instructor) {
        Set<Course> courseSet = new HashSet<>();
        for(Course c : instructor.getCourses()){
            Course course = courseRepository.findById(c.getNumCourse()).orElse(null);
            courseSet.add(course);
        }
        instructor.setCourses(courseSet);
        return instructorRepository.save(instructor);
    }

}