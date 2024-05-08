package com.seproject.seproject.dao;

import com.seproject.seproject.model.Role;
import com.seproject.seproject.model.Teacher;
import com.seproject.seproject.model.User;
import com.seproject.seproject.service.AuthenticationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeacherDAOImpl implements TeacherDAO{


    //    define field for entity manger
    private EntityManager entityManager ;
    private AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

//   constractor for inject entitymanager



    public TeacherDAOImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }




    @Autowired
    public TeacherDAOImpl(PasswordEncoder passwordEncoder, AuthenticationService authenticationService, EntityManager entityManager) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
        this.entityManager = entityManager;
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
        User user = new User();
        user.setFirstName(teacher.getFirstName());
        user.setLastName(teacher.getLastName());
        user.setRole(Role.TEACHER);
        user.setUsername(teacher.getEmail());
        user.setPassword(passwordEncoder.encode(teacher.getPassword()));
        authenticationService.register(user);
        return dbeteacher;

    }

    @Override
    public void deleteTeacher(int theId) {
        Teacher dbeteacher = entityManager.find(Teacher.class, theId);
        entityManager.remove(dbeteacher);
    }
}
