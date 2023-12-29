package it.controller;

import it.model.Student;
import it.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("find",studentRepository.findAll());
        return "menu";
    }
    @GetMapping("form")
    public String from(){
        return "saveFrom";
    }
     @PostMapping("save")
        public String save(
                @RequestParam("name") String name,
                @RequestParam("age") int age
     ){
         Student student = new Student();
         student.setName(name);
         student.setAge(age);
         studentRepository.save(student);
         return "redirect:/";
     }
     @GetMapping("find/by/{id}")
         public String findById(
                @PathVariable Long id,
                Model model
         ){
        model.addAttribute("e",studentRepository.findById(id));
        return "find";
     }
     @GetMapping("update/form/{id}")
    public String updateFrom(
            @PathVariable Long id,
            Model model
     ){
        Student student = studentRepository.findById(id);
        model.addAttribute("key",student);
        return "fromUpdate";
     }
     @PostMapping("update/{id}")
    public String update(
            @PathVariable Long id,
            @RequestParam String name,
             @RequestParam int age
     ) {
        Student student = studentRepository.findById(id);
        student.setAge(age);
        student.setName(name);
        studentRepository.update(student,id);
        return "redirect:/";
     }
     @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Long id){
        studentRepository.deleteById(id);
        return "redirect:/";
     }
}
