package kz.iitu.end.controller;
import io.swagger.annotations.Api;
import kz.iitu.end.entity.Book;
import kz.iitu.end.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Api
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RestTemplate restTemplate;

        @GetMapping("/books/")
    public ModelAndView getAllBooks() { ResponseEntity<List<Book>> response = restTemplate.exchange(
            "http://book-service/books/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() { });
        List<Book> books = response.getBody();
            ModelAndView modelAndView = new ModelAndView("books");
            modelAndView.addObject("booklist", books);
        return modelAndView;
    }
    @RequestMapping("/books/delete/{id}")
    public ModelAndView deleteBookById(@PathVariable("id") Long id) {
        Book book = restTemplate.getForObject("http://book-service/books/delete/" + id, Book.class);
        return getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
        return book;
    }

    @GetMapping("/users/")
    public ModelAndView getAllUsers() {
        ResponseEntity<List<Users>> response = restTemplate.exchange(
                "http://user-service/users/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Users>>() {
                });
        List<Users> users = response.getBody();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("userlist", users);
        return modelAndView;
    }

    @RequestMapping("/users/delete/{id}")
    public ModelAndView deleteUserById(@PathVariable("id") Long id) {
        Users users = restTemplate.getForObject("http://user-service/users/delete/" + id, Users.class);
        return getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Users getUserById(@PathVariable("id") Long id) {
        Users users = restTemplate.getForObject("http://user-service/users/" + id, Users.class);
        return users;
    }
}
