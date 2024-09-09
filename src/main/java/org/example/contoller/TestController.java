package org.example.contoller;

import org.example.model.MyUser;
import org.example.model.TestDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping
    public String test(){
        return "dsadsadsa";
    }

    @GetMapping("/dto")
    public TestDto test1(){
        return new TestDto("test","dasdasdas");
    }

    @GetMapping("/save")
    public void test2(@RequestParam(name = "username") String username, @RequestParam(name = "username") String email){
        MyUser user = new MyUser();
        user.setEmail(email);
        user.setName(username);

        userService.saveUser(user);
    }

    @GetMapping("/get")
    public MyUser test3(){


        return userService.findAllUsers().get(0);
    }


}
