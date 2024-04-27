package com.seproject.seproject.service;

import com.seproject.seproject.dao.TeacherDAO;
import com.seproject.seproject.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TreacherServiceImpl implements TeacherService{


    private TeacherDAO teacherDAO;

    public TreacherServiceImpl() {
    }

    @Autowired
    public TreacherServiceImpl(TeacherDAO theTeacherDAO) {
        this.teacherDAO = theTeacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }



    @Override
    public Teacher findById(int theId) {
       return teacherDAO.findById(theId);
    }
@Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return teacherDAO.save(teacher);
    }
    @Transactional
    @Override
    public void deleteTeacher(int theId) {
        teacherDAO.deleteTeacher(theId);
    }
}
