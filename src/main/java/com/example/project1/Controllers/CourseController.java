package com.example.project1.Controllers;

import com.example.project1.Entity.Course;
import com.example.project1.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

//    @Autowired
//    CourseRepository courrep;
    @Autowired
    CourseService coursevice;
    //================= post mapping =================//
    @PostMapping
    public Course insertcourse(@RequestBody Course body)
    {
        return coursevice.insertcourse(body);

                //courrep.save(body);
    }

    //================== get allcourse ==================//
    @GetMapping
    public List<Course> getallcourse()
    {
        return coursevice.getallcourse();
                //courrep.findAll();
    }

    //==================== getone course ===========//
    @GetMapping("/{id}")
    public Optional<Course> getonecourse(@PathVariable int id)
    {
        return coursevice.getonecourse(id);
                //courrep.findById(id);
    }

    //================== update course ================//
    @PutMapping("/{id}")
    public ResponseEntity<?> updatecourse(@PathVariable int id,@RequestBody Course body)
    {

        return coursevice.updatecourse(id,body);
//        Course c1 = courrep.findById(id).orElse(null);
//
//        if(c1 ==null)
//        {
//            return  ResponseEntity.status(404).body("Course not found by this id");
//        }
//        c1.setCourseName(body.getCourseName());
//        c1.setFees(body.getFees());
//        c1.setDuration(body.getDuration());
//
//        courrep.save(c1);
//        return ResponseEntity.status(200).body("Course update Sucessfully!");
    }
   //================ deletemapping ======================//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletecourse(@PathVariable int id)
    {
        return coursevice.deletecourse(id);
//        Course c1 = courrep.findById(id).orElse(null);
//
//        if(c1==null)
//        {
//            return  ResponseEntity.status(404).body("Course Not Found by this id");
//        }
//
//        courrep.deleteById(id);
//
//        return  ResponseEntity.status(200).body("Course Deleted Sucessfully!");
    }




}
