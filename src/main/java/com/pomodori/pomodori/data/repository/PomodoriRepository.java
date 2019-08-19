package com.pomodori.pomodori.data.repository;


import com.pomodori.pomodori.data.entity.Pomodori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PomodoriRepository extends CrudRepository<Pomodori, Integer> {

    Pomodori findById( int i);
}
