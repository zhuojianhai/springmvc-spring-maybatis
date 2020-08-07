package com.zjh.demo.dao;

import com.zjh.demo.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao {
    @Select("select * from student")
    List<Student> findAll();
}
