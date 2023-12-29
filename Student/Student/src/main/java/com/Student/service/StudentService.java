package com.Student.service;


import com.Student.Exception.ResourceNotFound;
import com.Student.entity.Student;
import com.Student.payload.StudentDto;
import com.Student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto Create(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setCity(studentDto.getCity());

        Student saved = studentRepository.save(student);

        StudentDto dto = new StudentDto();
        dto.setName(saved.getName());
        dto.setSurname(saved.getSurname());
        dto.setCity(saved.getCity());
        return dto;

    }

    public void DeleteRecord(long id) {
        studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Id is not Fount"+id)
        );
        studentRepository.deleteById(id);
    }
// here we convert entity to dto
    public List<StudentDto> GetAllRecord() {
        List<Student> student = studentRepository.findAll();
        List<StudentDto> collect = student.stream().map(x -> maToDto(x)).collect(Collectors.toList());
        return collect;
    }
    StudentDto maToDto(Student student){
        StudentDto dto = new StudentDto();
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setCity(student.getCity());
        dto.setId(student.getId());
        return dto;
    }
}
