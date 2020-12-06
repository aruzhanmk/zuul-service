//package kz.iitu.end.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import kz.iitu.end.entity.Users;
//import kz.iitu.end.repository.UserRepository;
//import kz.iitu.end.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private UserRepository userRepository;
//
//    @ApiOperation(value	= "List all users", response = Users.class, responseContainer = "List")
//    @GetMapping("")
//    public List<Users> getAllUsers()
//    {
//        return userService.getAllUsers();
//    }
//
//    @ApiOperation(value	= "Get user by ID", response = Users.class)
//    @GetMapping("/{id}")
//    public Users getUserById(@PathVariable("id") Long id)
//    {
//        return userService.getUserByID(id);
//    }
//
//    @ApiOperation(value	= "Find user by username", response = Users.class)
//    @GetMapping("/find/")
//    public Users findByUsername(@RequestParam String username)
//    {
//        return (Users) userService.loadUserByUsername(username);
//    }
//
//    @ApiOperation(value	= "Register new user with username and password", response = Users.class)
//    @PostMapping("/register/")
//    public Users createUserByUsernamePassword(@RequestParam String username, @RequestParam String password)
//    {
//        Users user = new Users();
//        user.setPassword(password);
//        user.setUsername(username);
//
//        userService.createUser(user);
//        Users newUser = (Users) userService.loadUserByUsername(username);
//        return newUser;
//    }
//
//    @ApiOperation(value	= "Add new user", response = Users.class)
//    @PostMapping("/create")
//    public Users createUser(@RequestBody Users user)
//    {
//        userService.createUser(user);
//        System.out.println(user);
//        Users newUser = (Users) userService.loadUserByUsername(user.getUsername());
//        return newUser;
//    }
//
//    @ApiOperation(value	= "Update user", response = Users.class)
//    @PutMapping("/update/{id}")
//    public Users updateUser(@PathVariable Long id,
//                            @RequestBody Users user)
//    {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("authentication.getName() = " + authentication.getName());
//
//        userService.updateUser(id, user);
//        Users userDB = (Users) userService.loadUserByUsername(user.getUsername());
//        return userDB;
//    }
//
//    @ApiOperation(value	= "Delete user")
//    @GetMapping("/delete/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id" + id));
//        userRepository.delete(user);
//    }
//}
//
