package com.cleilsonandrade.menuapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleilsonandrade.menuapi.food.Food;
import com.cleilsonandrade.menuapi.food.FoodRepository;
import com.cleilsonandrade.menuapi.food.FoodRequestDTO;
import com.cleilsonandrade.menuapi.food.FoodResponseDTO;

@RestController
@RequestMapping("food")
public class FoodController {
  @Autowired
  private FoodRepository repository;

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @GetMapping
  public List<FoodResponseDTO> getAll() {
    List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

    return foodList;
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping
  public void saveFood(@RequestBody FoodRequestDTO data) {
    Food foodData = new Food(data);

    repository.save(foodData);
    return;
  }
}
