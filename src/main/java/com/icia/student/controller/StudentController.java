package com.icia.student.controller;

import com.icia.student.dto.StudentDTO;
import com.icia.student.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/save")
    public String save() {
        return "save";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @PostMapping("/req1")
    public String req1(@ModelAttribute StudentDTO studentDTO) {
        studentService.save(studentDTO);
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<StudentDTO> studentDTOList = studentService.findAll();
        System.out.println("studentDTOList = " + studentDTOList);
        model.addAttribute("studentList", studentDTOList); // 화면에 가져갈 데이터
        return "list";// 브라우저에 출력할 jsp 파일 이름
    }

    @GetMapping("/find")
    public String find(@RequestParam("id") Long id, Model model) {
        StudentDTO studentDTO = studentService.findById(id);
        model.addAttribute("student", studentDTO);
        return "detail";
    }

    @GetMapping("/findId")
    public String findId(@RequestParam("id") Long id, Model model) {
        StudentDTO studentDTO = studentService.findId(id);
        model.addAttribute("student", studentDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute StudentDTO studentDTO) {
        studentService.update(studentDTO);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        studentService.delete(id);
        return "index";
    }
}

