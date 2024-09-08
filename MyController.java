package mongodbexample.controller;

import mongodbexample.models.Student;
import mongodbexample.rep.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class MyController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student)
    {
        Student save = this.studentRepository.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudent() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
}
