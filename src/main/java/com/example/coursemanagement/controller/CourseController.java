package com.example.coursemanagement.controller;

import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Object> addCourse(@RequestBody Course course) {
        try {
            Course newCourse = courseService.addCourse(course);
            Object response = new Object() {
                public final String message = "Course added successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.CREATED.value();
                public final Course data = newCourse;
            };
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to add course: " + e.getMessage();
                public final String statusMessage = "ERROR";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final Course data = null;
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<Object> getAllCourses() {
        try {
            List<Course> courses = courseService.getAllCourses();
            if (!courses.isEmpty()) {
                Object response = new Object() {
                    public final String message = "All Courses";
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final List<Course> data = courses;
                };
                return ResponseEntity.ok(response);
            } else {
                Object response = new Object() {
                    public final String message = "No courses found";
                    public final String statusMessage = "ERROR";
                    public final int status = HttpStatus.NOT_FOUND.value();
                    public final List<Course> data = new ArrayList<>();
                };
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to get courses: " + e.getMessage();
                public final String statusMessage = "ERROR";
                public final int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                public final List<Course> data = new ArrayList<>();
            };
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
        try {
            Optional<Course> courseOptional = courseService.getCourseById(id);
            if (courseOptional.isPresent()) {
                Object response = new Object() {
                    public final String message = "Course details for ID: " + id;
                    public final String statusMessage = "SUCCESS";
                    public final int status = HttpStatus.OK.value();
                    public final Course data = courseOptional.get();
                };
                return ResponseEntity.ok(response);
            } else {
                Object response = new Object() {
                    public final String message = "Course not found with ID: " + id;
                    public final String statusMessage = "ERROR";
                    public final int status = HttpStatus.NOT_FOUND.value();
                    public final Course data = null;
                };
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to get course: " + e.getMessage();
                public final String statusMessage = "ERROR";
                public final int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                public final Course data = null;
            };
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        try {
            Course updatedCourse = courseService.updateCourse(id, course);
            Object response = new Object() {
                public final String message = "Course updated successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
                public final Course data = updatedCourse;
            };
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to update course: " + e.getMessage();
                public final String statusMessage = "ERROR";
                public final int status = HttpStatus.BAD_REQUEST.value();
                public final Course data = null;
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            Object response = new Object() {
                public final String message = "Course deleted successfully";
                public final String statusMessage = "SUCCESS";
                public final int status = HttpStatus.OK.value();
            };
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Object response = new Object() {
                public final String message = "Failed to delete course: " + e.getMessage();
                public final String statusMessage = "ERROR";
                public final int status = HttpStatus.BAD_REQUEST.value();
            };
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
