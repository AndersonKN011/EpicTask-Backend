package com.epictask.controller;

import java.util.List;

import com.epictask.model.HabitModel;
import com.epictask.repository.HabitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
@CrossOrigin(origins = "*")
public class HabitController {

    private final HabitRepository habitRepository;

    public HabitController(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @GetMapping
    public List<HabitModel> listAll(){
        return habitRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<HabitModel> save(@RequestBody HabitModel habitModel){
        return new ResponseEntity<>(habitRepository.save(habitModel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id){
        habitRepository.deleteById(id);
        System.out.println("Delete Habit with id: " + id);
    }

    @PutMapping("/{id}")
    public HabitModel update(@PathVariable Long id, @RequestBody HabitModel habitModel){
        HabitModel habit = habitRepository.findById(id).orElseThrow(() -> new RuntimeException("Hábito não encontrado com o ID: " + id));

        habit.setTitle(habitModel.getTitle());
        habit.setDescription(habitModel.getDescription());
        return habitRepository.save(habit);
    }

}
