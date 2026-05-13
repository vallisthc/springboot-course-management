package com.example.project1.Service;

import com.example.project1.Entity.Course;
import com.example.project1.Respository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service

public class CourseService {

    @Autowired
    CourseRepository courrep;
    //================= post mapping =================//

    public Course insertcourse( Course body)
    {
        return courrep.save(body);
    }

    //================== get allcourse ==================//

    public List<Course> getallcourse()
    {
        return courrep.findAll();
    }

    //==================== getone course ===========//

    public Optional<Course> getonecourse( int id)
    {
        return courrep.findById(id);
    }

    //================== update course ================//

    public ResponseEntity<?> updatecourse( int id,  Course body)
    {
        Course c1 = courrep.findById(id).orElse(null);

        if(c1 ==null)
        {
            return  ResponseEntity.status(404).body("Course not found by this id");
        }
        c1.setCourseName(body.getCourseName());
        c1.setFees(body.getFees());
        c1.setDuration(body.getDuration());

        courrep.save(c1);
        return ResponseEntity.status(200).body("Course update Sucessfully!");
    }
    //================ deletemapping ======================//

    public ResponseEntity<?> deletecourse(int id)
    {
        Course c1 = courrep.findById(id).orElse(null);

        if(c1==null)
        {
            return  ResponseEntity.status(404).body("Course Not Found by this id");
        }

        courrep.deleteById(id);

        return  ResponseEntity.status(200).body("Course Deleted Sucessfully!");
    }

}
