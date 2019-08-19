package com.pomodori.pomodori.data.webservices;


import com.pomodori.pomodori.data.entity.Pomodori;
import com.pomodori.pomodori.data.repository.PomodoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(PomodoriController.POMODORI_END_POINT)
public class PomodoriController {
    public static final String POMODORI_END_POINT = "pomodori";

    @Autowired
    private PomodoriRepository repository;

    @GetMapping(value = "")
    List<Pomodori> findAll() {
        List<Pomodori> pomodoris = new ArrayList<>();
        Iterable<Pomodori> results = this.repository.findAll();
        results.forEach(pomodoris::add);
        return pomodoris;
    }

    @GetMapping(value = "/{id}")
    Optional<Pomodori> findById(@PathVariable Integer id) {
        return this.repository.findById(id);
    }

    @PostMapping("")
    Pomodori save(@RequestBody Pomodori pomodori) {
        return this.repository.save(pomodori);
    }

    @PutMapping("/{id}")
    Pomodori updatePomodori(@RequestBody Pomodori pomodori, @PathVariable Integer id) {
        return repository.save(pomodori);
    }

    @DeleteMapping("/{id}")
    void deletePomodori(@PathVariable Integer id) {
        repository.deleteById(id);
    }


}
