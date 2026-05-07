package com.epictask.service;

import com.epictask.model.HabitModel;
import com.epictask.model.PlayerModel;
import com.epictask.repository.HabitRepository;
import com.epictask.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final HabitRepository habitRepository;
    private final PlayerRepository playerRepository;

    public PlayerService(HabitRepository habitRepository, PlayerRepository playerRepository) {
        this.habitRepository = habitRepository;
        this.playerRepository = playerRepository;
    }

    public void habitDone (Long id){
        HabitModel habit = habitRepository.findById(id).orElseThrow();
        PlayerModel player = playerRepository.findById(5L).orElseThrow();

        int newXp = player.getCurrent_xp() + habit.getXp_reward();

        if (newXp >= 100){
            player.setLevel(player.getLevel() + 1);
            player.setCurrent_xp(newXp - 100);
            player.setCurrent_hp(player.getMax_hp());
        } else {
            player.setCurrent_xp(newXp);
        }

        habit.setIsCompletedToday(true);
        habitRepository.save(habit);
        playerRepository.save(player);
    }
}
