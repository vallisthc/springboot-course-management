package com.example.project1.Service;

import com.example.project1.DTO.StudentResponseDTO;
import com.example.project1.Entity.Course;
import com.example.project1.Entity.Student;
import com.example.project1.Respository.CourseRepository;
import com.example.project1.Respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository sturep;

    @Autowired
    CourseRepository courep;

    //============== Add student ==================//

    public Student addstudent(Student body)
    {
        return  sturep.save(body);
    }

    //============= getallstudent =================//
    public List<Student> getallstudents()
    {
        return  sturep.findAll();
    }

    //================ getallstudentparticularcolumns ========================//
    public List<StudentResponseDTO> getallstuselectedcolums()
    {
        List<Student> stu= sturep.findAll();

        List<StudentResponseDTO> studto=new ArrayList<>();
        for(Student s : stu)
        {
            StudentResponseDTO studdtoobj=new StudentResponseDTO();

            studdtoobj.setId(s.getId());
            studdtoobj.setName(s.getName());
            studdtoobj.setEmail(s.getEmail());

             studto.add(studdtoobj);
        }

        return studto;

    }


    //================= get student by id =====================//
    public Optional<Student> getstubyid( int id)
    {
        return sturep.findById(id);
    }

    ///===========delete student by id ===========//

    public ResponseEntity<?> deletestudentbyid(int id)
    {
        Student s1= sturep.findById(id).orElse(null);

        if(s1 ==null)
        {
            return  ResponseEntity.status(200).body("Student Not Found by this id ");
        }
        sturep.deleteById(id);
        return ResponseEntity.status(200).body("Student Deleted sucessfully!");

    }

    //================= update by id ================//
    public ResponseEntity<?> updatestubyid( int id,Student body)

    {
        Student s1=sturep.findById(id).orElse(null);

        if(s1==null)
        {
            return  ResponseEntity.status(200).body("Student not found by this id");
        }

        s1.setName(body.getName());
        s1.setEmail(body.getEmail());
        s1.setPhone(body.getPhone());

        sturep.save(s1);

        return ResponseEntity.status(200).body("Student update Sucessfully!");

    }

    //=============  asign the courses to students ====================//

    public ResponseEntity<?> assigncoursetostudent( int studentid, int courseid)
    {

        Student s = sturep.findById(studentid).orElse(null);

        Course c= courep.findById(courseid).orElse(null);

        if(s == null || c==null)
        {
            return  ResponseEntity.status(404).body("Student or Course are not found");
        }

        s.getCourses().add(c);

        sturep.save(s);

        return ResponseEntity.status(200).body("Course Succesfully assigned to the studemt");

    }



}
