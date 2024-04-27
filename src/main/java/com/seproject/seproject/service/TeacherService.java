package com.seproject.seproject.service;

import com.seproject.seproject.model.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findAll();
//    done

    public Teacher findById(int theId);

    public Teacher save(Teacher teacher);

    public void deleteTeacher(int theId) ;
}
