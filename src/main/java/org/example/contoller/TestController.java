package org.example.contoller;

import org.example.dto.SaveUserRequestDto;
import org.example.model.MyUser;
import org.example.model.TestDto;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping
    public String test() {
        return "zmiana";
    }

    @GetMapping("/dto")
    public TestDto test1() {
        return new TestDto("test", "dasdasdas");
    }

    //http://localhost:8080/Spring/save?name=Iza&email=dasdasda
    @PostMapping("/save")
    public void createUser(@RequestParam("name") String name,
                           @RequestParam(value = "email",
                                   required = false,
                                   defaultValue = "NieMaMaila@jdadjo")
                           String email)
    {
        MyUser user = new MyUser();
        user.setEmail(email);
        user.setName(name);
        userService.saveUser(user);
    }

//http://localhost:8080/Spring-1.0-SNAPSHOT/saveBigData?name=Maciek&email=testemail
    //wrzuca wszyskie parametry z linku (te po ? ) do obiektu java, nie jest potrzebna anotacja zadna
    @PostMapping("/saveBigData")
    public void createUserBig(SaveUserRequestDto requestDto) {
        MyUser user = new MyUser();
        user.setEmail(requestDto.email());
        user.setName(requestDto.name());
        userService.saveUser(user);
    }

    //RequestBody
    //http://localhost:8080/Spring/get/Iza
    @GetMapping("/get/{username}")
    public MyUser getUserByName(@PathVariable("username") String username) {
        return userService.findUserByName(username);
    }

    // body przechwytuje informacje z body requesta - zeby tego uzyc musisz uzyc zewnetrznej aplickajci
    @PostMapping("/saveBody")
    public void createSecureUser(@RequestBody SaveUserRequestDto requestDto) {
        MyUser user = new MyUser();
        user.setEmail(requestDto.email());
        user.setName(requestDto.name());
        userService.saveUser(user);
    }

    @PostMapping("/saveQuery")
    public void saveUserQuery(MyUser user){
        userService.saveUser(user);
    }

    @GetMapping("/get")
    public MyUser test3() {
        return userService.findAllUsers().get(0);
    }

    @GetMapping("/getAll")
    public List<MyUser> getAll() {

        return userService.findAllUsers();
    }

}
