package com.icia.student.service;

import com.icia.student.dto.StudentDTO;
import com.icia.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void save(StudentDTO studentDTO) {
        studentRepository.save(studentDTO);
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll();
    }

    public StudentDTO findById(Long id) {
        return studentRepository.findById(id);
    }

    public StudentDTO findId(Long id) {
        return studentRepository.findId(id);
    }

    public void update(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
        studentRepository.update(studentDTO);
    }

    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
