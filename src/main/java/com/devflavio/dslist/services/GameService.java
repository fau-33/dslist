package com.devflavio.dslist.services;


import com.devflavio.dslist.dto.GameDTO;
import com.devflavio.dslist.dto.GameMinDTO;
import com.devflavio.dslist.entities.Game;
import com.devflavio.dslist.projections.GameMinProjection;
import com.devflavio.dslist.repositories.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public GameDTO findById(Long id) {
    Game result = gameRepository.findById(id).get();
    return new GameDTO(result);

  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long listId) {
    List<GameMinProjection> result = gameRepository.searchByList(listId);
    return result.stream().map(x -> new GameMinDTO(x)).toList();

  }
}
