package com.example.QueryMethods.studentcontroller;

import com.example.QueryMethods.model.Student;
import com.example.QueryMethods.service.Studentservice;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    @Autowired
    Studentservice studentservice;

    @PostMapping("/add-student")
    public ResponseEntity<String>addStudent(@RequestBody String student){
        Student _student=setStudent(student);
        int id=studentservice.addStudent(_student);
        return new ResponseEntity<>("studet added with id= "+id, HttpStatus.CREATED);

    }

    @GetMapping("/get-student")
    public List<Student>getStudent(@Nullable @RequestParam String name,@Nullable @RequestParam String lastname){

        return studentservice.getStudent(lastname,name);
    }

    @GetMapping("get-student/age")
    public List<Student>getstudentbyAge(@RequestParam Integer age){
        return studentservice.getstudentbyAge(age);
    }


    public Student setStudent(String student_){
        JSONObject studentObj=new JSONObject(student_);
        Student student=new Student();
        student.setFirstName(studentObj.getString("firstName"));
        student.setLastName(studentObj.getString("lastName"));
        student.setAge(studentObj.getInt("age"));
        student.setActive(studentObj.getBoolean("active"));
        Date Admdate=new Date();
        student.setAdmissionDate(Admdate);
        return student;
    }

}
