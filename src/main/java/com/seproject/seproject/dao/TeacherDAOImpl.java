package com.seproject.seproject.dao;

import com.seproject.seproject.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeacherDAOImpl implements TeacherDAO{


    //    define field for entity manger
    private EntityManager entityManager ;

//   constractor for inject entitymanager


    public TeacherDAOImpl() {
    }

    @Autowired
    public TeacherDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }


    @Override
    public List<Teacher> findAll() {

        TypedQuery<Teacher> thequery = entityManager.createQuery("from Teacher",Teacher.class);
        List<Teacher> teachers = thequery.getResultList();

        return teachers ;

    }
    @Override
    public Teacher findById(int theId) {

        Teacher dbeteacher = entityManager.find(Teacher.class,theId);

        return dbeteacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        Teacher dbeteacher = entityManager.merge(teacher);
        return dbeteacher;

    }

    @Override
    public void deleteTeacher(int theId) {
        Teacher dbeteacher = entityManager.find(Teacher.class, theId);
        entityManager.remove(dbeteacher);
    }
}
