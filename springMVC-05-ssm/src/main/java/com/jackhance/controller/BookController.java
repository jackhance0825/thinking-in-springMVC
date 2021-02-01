package com.jackhance.controller;

import com.alibaba.fastjson.JSON;
import com.jackhance.pojo.Books;
import com.jackhance.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    @ResponseBody
    public String list0() {
        return JSON.toJSONString(bookService.queryAllBook());
    }

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(@RequestParam("id") int bookID, Model model) {
        Books b = bookService.queryBookById(bookID);
        model.addAttribute("book", b);
        return "updateBook";
    }

    @RequestMapping(path = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Books book) {
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookID}")
    public String del(@PathVariable("bookID") int bookID) {
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }


}
