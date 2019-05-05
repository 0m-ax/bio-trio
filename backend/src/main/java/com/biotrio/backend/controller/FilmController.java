package com.biotrio.backend.controller;


import com.biotrio.backend.model.Film;
import com.biotrio.backend.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> films(){
        List<Film> filmList = (List<Film>) filmRepository.findAll();
        return filmList;
    }

    @PostMapping("/films")
    public Film filmAdd(@RequestBody Film film) {
        filmRepository.save(film);
        return film;
    }

    @RequestMapping(value = "/films/{index}/delete")
    public int film(@PathVariable int index) {
        filmRepository.deleteById(index);
        return index;
    }

    @RequestMapping(value = "/films/{index}")
    public Film filmDelete(@PathVariable int index) {
        return filmRepository.findById(index).get();
    }

    @RequestMapping(value="/films/{index}/edit", method = RequestMethod.POST)
    public Film filmEdit(@PathVariable int index, @RequestBody Film film) {
        film.setId(index);
        filmRepository.save(film);
        return film;
    }
}