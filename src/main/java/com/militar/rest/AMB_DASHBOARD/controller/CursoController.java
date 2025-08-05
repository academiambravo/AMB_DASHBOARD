package com.militar.rest.AMB_DASHBOARD.controller;

import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseListDto;
import com.militar.rest.AMB_DASHBOARD.dto.course.GetCourseSo;
import com.militar.rest.AMB_DASHBOARD.model.Curso;
import com.militar.rest.AMB_DASHBOARD.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CursoController {

    private final CursoService cursoService;

    @Operation(
            summary = "Get all courses",
            description = "Returns a list of all courses in the system.",
            tags = {"Course"}
    )
    @GetMapping("/list")
    public ResponseEntity<GetCourseListDto> getCourseList() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCourseList());
    }

    @Operation(
            summary = "Get course by ID",
            description = "Returns a specific course by its ID.",
            tags = {"Course"}
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetCourseDto> getCourseById(@PathVariable  Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCourseById(id));
    }

    @Operation(
            summary = "Delete course by ID",
            description = "Deletes a specific course by its ID.",
            tags = {"Course"}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        cursoService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Get course by name",
            description = "Returns a specific course by its name.",
            tags = {"Course"}
    )
    @GetMapping("/name/{name}")
    public ResponseEntity<GetCourseDto> getCourseByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCourseByName(name));
    }

    @Operation(
            summary = "Update course by ID",
            description = "Updates a specific course by its ID.",
            tags = {"Course"}
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Curso> updateCourse(@PathVariable Integer id, @RequestBody GetCourseDto courseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.updateCourse(id, courseDto));
    }

    @Operation(
            summary = "Create a new course",
            description = "Creates a new course in the system.",
            tags = {"Course"}
    )
    @PostMapping()
    public ResponseEntity<Curso> createCourse(@RequestBody GetCourseDto courseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCourse(courseDto));
    }

    @GetMapping("/so-course")
    public ResponseEntity<GetCourseSo> getCourseSo() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCourseSo());
    }


}
