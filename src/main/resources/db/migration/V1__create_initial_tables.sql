CREATE TABLE player_profile (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    level INTEGER DEFAULT 1,
    current_hp INTEGER DEFAULT 100,
    current_xp INTEGER DEFAULT 0,
    max_hp INTEGER DEFAULT 100
);

CREATE TABLE habit (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    xp_reward INTEGER NOT NULL,
    hp_damage INTEGER NOT NULL,
    is_completed_today BOOLEAN DEFAULT FALSE
)