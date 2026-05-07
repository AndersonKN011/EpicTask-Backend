package com.epictask.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "habit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer xp_reward;
    private Integer hp_damage;
    @Column(name = "is_completed_today")
    private Boolean isCompletedToday;

    @PrePersist
    protected void onCreate() {
        if (this.isCompletedToday == null) this.isCompletedToday = false;
    }
}
