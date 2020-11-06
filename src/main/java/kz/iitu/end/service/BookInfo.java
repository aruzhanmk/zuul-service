//package kz.iitu.end.service;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import kz.iitu.end.entity.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//public class BookInfo {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/books/")
//    @HystrixCommand(fallbackMethod = "getAllBooksFallback")
//    public List<Book> getAllBooks() { ResponseEntity<List<Book>> response = restTemplate.exchange(
//            "http://book-service/books/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() { });
//        List<Book> books = response.getBody();
//        return books;
//    }
////    public List<Book> getAllBooksFallback() { restTemplate.exchange(null, null, null, (ParameterizedTypeReference<List<Book>>) null);
//    public List<Book> getAllBooksFallback() { ResponseEntity<List<Book>> response = restTemplate.exchange(
//        null, HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() { });
//        List<Book> books = response.getBody();
//        return (List<Book>) new Book("No book", (double) 0);
//    }
//
//    @RequestMapping("/books/delete/{id}")
//    public Book deleteBookById(@PathVariable("id") Long id) {
//        Book book = restTemplate.getForObject("http://book-service/books/delete/" + id, Book.class);
////        return getAllBooks();
//        return book;
//    }
//
//    @RequestMapping("/books/{id}")
//    @HystrixCommand(fallbackMethod = "getBookByIdFallback")
//    public Book getBookById(@PathVariable("id") Long id) {
//        Book book = restTemplate.getForObject("http://book-service/books/" + id, Book.class);
//        return book;
//    }
//    public Book getBookByIdFallback(@PathVariable("id") Long id) {
//        return new Book("No book", (double) 0);
//    }
//
//}
