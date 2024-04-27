package com.seproject.seproject.dao;

import com.seproject.seproject.model.Teacher;

import java.util.List;

public interface TeacherDAO {

    public List<Teacher> findAll();

    public Teacher findById(int theId);

    public Teacher save(Teacher teacher);

    public void deleteTeacher(int theId) ;
}
