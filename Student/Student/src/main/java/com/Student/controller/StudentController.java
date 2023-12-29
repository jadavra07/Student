package com.Student.controller;

import com.Student.entity.Student;
import com.Student.payload.StudentDto;
import com.Student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student", description = "Student management APIs")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //http://localhost:8080/api/student
    @Operation(summary = "Create a new Student Record", tags = {"Student", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = StudentDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto studentDto) {
        StudentDto dto = studentService.Create(studentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }

    //http://localhost:8080/api/student/7

    @Operation(summary = "Delete a Student by Id", tags = {"student", "delete"})
    @ApiResponses({@ApiResponse(responseCode = "204", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable long id) {
        studentService.DeleteRecord(id);
        return new ResponseEntity<>("post is delete", HttpStatus.OK);

    }


    @Operation(summary = "Retrieve all Student", tags = {"student", "get", "filter"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = StudentDto.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "There are no student", content = {
                    @Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping
    public List<StudentDto> getAllRecord() {
        List<StudentDto> studentDtos = studentService.GetAllRecord();
        return studentDtos;
    }

}
