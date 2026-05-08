# ⚔️ EpicTask API - O Núcleo do RPG

O backend do EpicTask é uma API REST responsável por gerenciar o progresso do jogador, aplicar as regras de RPG e automatizar eventos do sistema.

Swagger: https://epictask-backend-40m0.onrender.com/swagger-ui/index.html

---

Repositório do Frontend: https://github.com/AndersonKN011/EpicTask-Frontend

---

## 🛠️ Tecnologias e Ferramentas

- Java 21
- Spring Boot 3
- PostgreSQL
- Flyway / Liquibase
- Spring Events
- Spring Scheduling

---

## 📜 Regras de Negócio Implementadas

### ⏰ Sistema Diário (Cron Job)

Executa automaticamente à meia-noite (`00:00`) para verificar hábitos não concluídos.

### 💥 Cálculo de Dano

Soma o `hp_damage` das tarefas pendentes e reduz o HP atual do jogador.

### ☠️ Penalidade de Morte

Caso o HP chegue a zero, o jogador perde um nível.

### 🛡️ Validação de Raridade

O backend valida os valores enviados pelo frontend, garantindo que os atributos estejam dentro dos valores permitidos.

### ⭐ Sistema de Evolução

Gerencia:
- ganho de experiência
- subida de nível
- restauração de vida ao evoluir
