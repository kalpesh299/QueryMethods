package com.example.QueryMethods.dao;

import com.example.QueryMethods.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Studentrepo extends JpaRepository<Student,Integer> {

    //using default querymethods
    List<Student> findDistinctByLastNameAndFirstName(String lastName,String firstName);


    //---------------findbyfirstandlastname
    List<Student>findByLastNameAndFirstName(String lastName,String firstName);
    @Query(value = "select * from tbl_student where first_name=:firstname and last_name=:lastname",nativeQuery = true)
    public List<Student> findstudentbyfirsandlastname(String lastname,String firstname);


    //--------------------name or lastname
    //using default querymethods
    List<Student>findByLastNameOrFirstName(String lastName,String firstName);
    @Query(value="select * from tbl_student where first_name=:firstname or last_name=:lastname",nativeQuery = true)
    public List<Student>findstudentbyfirstorlastname(String lastname,String firstname);


    //--------------------by firstname----
    List<Student>findByFirstName(String name);
    @Query(value="select * from tbl_student where first_name= :firstname",nativeQuery = true)
    public List<Student> findstudentbyname(String firstname);

    //---------------by age

    List<Student>findByAgeLessThan(Integer age);

    @Query(value="select * from tbl_student where age<:age",nativeQuery = true)
    public List<Student>findstudentagelessthan(Integer age);




}
