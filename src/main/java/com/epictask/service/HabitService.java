package com.epictask.service;

import java.util.List;

import com.epictask.model.HabitModel;
import com.epictask.model.PlayerModel;
import com.epictask.repository.HabitRepository;
import com.epictask.repository.PlayerRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final PlayerRepository playerRepository;

    public HabitService(HabitRepository habitRepository, PlayerRepository playerRepository) {
        this.habitRepository = habitRepository;
        this.playerRepository = playerRepository;
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "America/Sao_Paulo")
    public void finishHabit() {
        List<HabitModel> missedHabits = habitRepository.findByIsCompletedToday(false);

        int totalDamage = missedHabits.stream().mapToInt(HabitModel::getHp_damage).sum();

        PlayerModel player = playerRepository.findById(5L).orElseThrow();
        player.setCurrent_hp(player.getCurrent_hp() - totalDamage);

        playerRepository.save(player);

        List<HabitModel> completedHabits = habitRepository.findByIsCompletedToday(true);

        for (HabitModel habit : completedHabits) {
            habit.setIsCompletedToday(false);
        }

        System.out.println("Dano aplicado: " + totalDamage);
    }
}
