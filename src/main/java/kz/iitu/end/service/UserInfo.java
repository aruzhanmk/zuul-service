//package kz.iitu.end.service;
//
//import kz.iitu.end.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Service
//public class UserInfo {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/users/")
//    public ModelAndView getAllUsers() {
//        ResponseEntity<List<Users>> response = restTemplate.exchange(
//                "http://user-service/users/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Users>>() {
//                });
//        List<Users> users = response.getBody();
//        ModelAndView modelAndView = new ModelAndView("users");
//        modelAndView.addObject("userlist", users);
//        return modelAndView;
//    }
//
//    @RequestMapping("/users/delete/{id}")
//    public ModelAndView deleteUserById(@PathVariable("id") Long id) {
//        Users users = restTemplate.getForObject("http://user-service/users/delete/" + id, Users.class);
//        return getAllUsers();
//    }
//
//    @RequestMapping("/users/{id}")
//    public Users getUserById(@PathVariable("id") Long id) {
//        Users users = restTemplate.getForObject("http://user-service/users/" + id, Users.class);
//        return users;
//    }
//}
