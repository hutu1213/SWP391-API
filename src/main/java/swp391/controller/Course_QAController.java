package swp391.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swp391.dto.blog.ModifiBlogDto;

import swp391.dto.course_qa.ModifiCourse_qa;
import swp391.entity.Course_QA;
import swp391.service.CourseService;
import swp391.service.Course_QAService;

import java.util.List;

@RestController
@RequestMapping("/api/course-q&a")
public class Course_QAController {
    private Course_QAService course_qaService;
    private CourseService courseService;

    public Course_QAController(Course_QAService course_qaService, CourseService courseService) {
        this.course_qaService = course_qaService;
        this.courseService = courseService;
    }

    @GetMapping
    private ResponseEntity getAll() {
        List<Course_QA> course_qaList = course_qaService.getAll();
        return ResponseEntity.ok().body(course_qaList);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ModifiCourse_qa dto) {
        if (course_qaService.isExisted(dto.getId())) {
            return ResponseEntity.badRequest().body("Course_QA Id is duplicated");
        }
        if (!courseService.isExisted(dto.getCourseId())) {
            return ResponseEntity.badRequest().body("Course Id is not found");
        }
        Course_QA course_qa = course_qaService.create(dto);

        return ResponseEntity.ok().body(course_qa);
    }

    @PutMapping
    private ResponseEntity update(@RequestBody ModifiCourse_qa dto) {
        if (!courseService.isExisted(dto.getCourseId())) {
            return ResponseEntity.badRequest().body("Course Id is not found");
        }
        Course_QA course_qa = course_qaService.update(dto.getId(), dto);
        return ResponseEntity.ok().body(course_qa);
    }

    @DeleteMapping()
    private ResponseEntity delete(@RequestParam String id) {
        course_qaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id")
    private ResponseEntity getById(@RequestParam String id) {
        Course_QA course_qa = course_qaService.getById(id);
        return ResponseEntity.ok().body(course_qa);
    }
}