package com.example.project1.Controllers;

import com.example.project1.DTO.StudentResponseDTO;
import com.example.project1.Entity.Student;
import com.example.project1.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    StudentRepository sturep;
//
//    @Autowired
//    CourseRepository courep;

    @Autowired
    StudentService stuservice;

    //===================== addstudent =================//
    @PostMapping
    public Student addstudent(@Valid @RequestBody Student body)
    {
        return  stuservice.addstudent(body);
                //sturep.save(body);
    }
    //============= getallstudent =================//
    @GetMapping
    public List<Student> getallstudents()
    {
        return stuservice.getallstudents();
                //sturep.findAll();
    }

    //============== getalselected student column ==============//
    @GetMapping("/all/selects")
    public List<StudentResponseDTO> getallselectedcolumns()
    {
        return  stuservice.getallstuselectedcolums();
    }

    //============== getstudent by id ====================//

    @GetMapping("/{id}")
    public Optional<Student> getstubyid(@PathVariable int id)
    {
       return stuservice.getstubyid(id);

        //sturep.findById(id);

    }
    //================ deletestudent ==============//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletestudentbyid(@PathVariable int id)
    {

        return  stuservice.deletestudentbyid(id);
//        Student s1= sturep.findById(id).orElse(null);
//
//        if(s1 ==null)
//        {
//            return  ResponseEntity.status(200).body("Student Not Found by this id ");
//        }
//        sturep.deleteById(id);
//        return ResponseEntity.status(200).body("Student Deleted sucessfully!");
    }

    //===================updatestudent by id ===================//

    @PutMapping("/{id}")
    public ResponseEntity<?> updatestubyid(@PathVariable int id,@RequestBody Student body)
    {

        return  stuservice.updatestubyid(id,body);
//        Student s1=sturep.findById(id).orElse(null);
//
//        if(s1==null)
//        {
//          return  ResponseEntity.status(200).body("Student not found by this id");
//        }
//
//        s1.setName(body.getName());
//        s1.setEmail(body.getEmail());
//        s1.setPhone(body.getPhone());
//
//        sturep.save(s1);
//
//       return ResponseEntity.status(200).body("Student update Sucessfully!");
   }

    //=========== assign student with multiple courses ==================//
    @PostMapping("/insert/student/{studentid}/course/{courseid}")

    public ResponseEntity<?> assigncoursetostudent(@PathVariable int studentid,@PathVariable int courseid)
    {

     return   stuservice.assigncoursetostudent(studentid,courseid);
//     Student s = sturep.findById(studentid).orElse(null);
//
//     Course c= courep.findById(courseid).orElse(null);
//
//     if(s == null || c==null)
//     {
//         return  ResponseEntity.status(404).body("Student or Course are not found");
//     }
//
//     s.getCourses().add(c);
//
//     sturep.save(s);
//
//     return ResponseEntity.status(200).body("Course Succesfully assigned to the studemt");

    }



}
