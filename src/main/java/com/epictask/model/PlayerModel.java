package com.epictask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "player_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer level;
    private Integer current_xp;
    private Integer current_hp;
    private Integer max_hp;

    @PrePersist
    protected void onCreate() {
        if (this.level == null) this.level = 1;
        if (this.current_xp == null) this.current_xp = 0;
        if (this.current_hp == null) this.current_hp = 100;
        if (this.max_hp == null) this.max_hp = 100;
    }
}
