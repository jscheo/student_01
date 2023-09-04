package com.icia.student.repository;

import com.icia.student.dto.StudentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private SqlSessionTemplate sql;
    // insert 매서드는 기본적으로 int를 리턴받는데 insert 된 횟수만큼 int로 돌려받음 1번 성공하면 1 2번이면 2
    // 0 이면 안된거
    public void save(StudentDTO studentDTO) {
        sql.insert("Student.save", studentDTO);
    }

    public List<StudentDTO> findAll() {
       return sql.selectList("Student.findAll");
    }

    public StudentDTO findById(Long id) {
        return sql.selectOne("Student.findById", id);
    }

    public StudentDTO findId(Long id) {
        return sql.selectOne("Student.findId",id);
    }


    public void update(StudentDTO studentDTO) {
        System.out.println("studentDTO = " + studentDTO);
        sql.update("Student.update", studentDTO);
    }

    public void delete(Long id) {
        sql.delete("Student.delete", id);
    }
}

