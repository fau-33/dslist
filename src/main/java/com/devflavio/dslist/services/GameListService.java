package com.devflavio.dslist.services;


import com.devflavio.dslist.dto.GameListDTO;
import com.devflavio.dslist.entities.GameList;
import com.devflavio.dslist.repositories.GameListRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(x -> new GameListDTO(x)).toList();

  }
}
