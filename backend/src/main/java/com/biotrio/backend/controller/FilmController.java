package com.biotrio.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//
//@RestController
//@RequestMapping("/films")
//public class FilmController {
//
//    @Autowired
//    private FilmRepository filmRepository;
//
//    @GetMapping("/")
//    public List<Film> films(){
//        List<Film> filmList = (List<Film>) filmRepository.findAll();
//        return filmList;
//    }
//
//    @PostMapping("/")
//    public Film filmAdd(@RequestBody Film film) {
//        filmRepository.save(film);
//        return film;
//    }
//
//    @RequestMapping(value = "/{index}/delete")
//    public int film(@PathVariable int index) {
//        filmRepository.deleteById(index);
//        return index;
//    }
//
//    @RequestMapping(value = "/{index}")
//    public Film filmDelete(@PathVariable int index) {
//        return filmRepository.findById(index).get();
//    }
//
//    @RequestMapping(value="/{index}/edit", method = RequestMethod.POST)
//    public Film filmEdit(@PathVariable int index, @RequestBody Film film) {
//        film.setId(index);
//        filmRepository.save(film);
//        return film;
//    }
//}