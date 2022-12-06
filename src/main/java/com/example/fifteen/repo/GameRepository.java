package com.example.fifteen.repo;

import com.example.fifteen.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Integer> {

}
