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
        // model에 담은건 일회용이다 한번 보내고 나면 끝 다시쓰고 싶으면 다시 보내줘야함
        model.addAttribute("student", studentDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute StudentDTO studentDTO) {
        studentService.update(studentDTO);
        //list로 바로 보내면 그냥 단순히 list.jsp를 띄우는거라 데이터가 없는 껍데기상태로 이동한다.
        // redirect로 적은 주소는 컨트롤러에 적힌 주소를 찾아가는 의미 jsp로 바로 가는게 아님.
        return "redirect: /list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        studentService.delete(id);
        //redirect로 하지 않고 list를 만들어서 보내는 방식
        List<StudentDTO> studentDTOList = studentService.findAll();
        model.addAttribute("studentList", studentDTOList);
        return "list";
    }
}

