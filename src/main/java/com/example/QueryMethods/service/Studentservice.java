package com.example.QueryMethods.service;

import com.example.QueryMethods.dao.Studentrepo;
import com.example.QueryMethods.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {
    @Autowired
    Studentrepo studentrepo;
    public Integer addStudent(Student student) {

        return studentrepo.save(student).getId();
    }

    public List<Student> getStudent(String lastname,String name) {
//        return studentrepo.findDistinctByLastNameAndFirstName(lastname,name);

        //------------firstname and last name
        //return studentrepo.findByLastNameAndFirstName(lastname,name);
         //return studentrepo.findstudentbyfirsandlastname(lastname,name);

        //------------firstname or last name
         return studentrepo.findByLastNameOrFirstName(lastname, name);
//        return studentrepo.findstudentbyfirstorlastname(lastname, name);

        //----------------by firstname
       //return studentrepo.findByFirstName(name);
        //return studentrepo.findstudentbyname(name);

             //return null;
}

////---filtering data according to age
    public List<Student> getstudentbyAge(Integer age) {
//        return studentrepo.findByAgeLessThan(age);
        return studentrepo.findstudentagelessthan(age);
    }

}
