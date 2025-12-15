package Repository;

import Entity.Course;               // add this import
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> { // use Course, not CourseRepository
}
