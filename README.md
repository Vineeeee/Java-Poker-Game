# 🃏 Java-Poker-Game

Implementação em Java de um sistema de baralho de cartas completo com:
- Gerenciamento de baralho (criação, embaralhamento, distribuição)
- Sistema de avaliação de mãos de poker (Royal Flush, Straight, Pares, etc.)
- Lógica para jogador vs dealer (computador)
- Substituição de cartas e mecânicas básicas de jogo

## Funcionalidades Principais
✔️ Baralho completo de 52 cartas  
✔️ Algoritmo Fisher-Yates para embaralhamento  
✔️ Avaliação de 9 tipos diferentes de mãos de poker  
✔️ Interface simples via console  
✔️ Lógica para substituição de cartas  

## Tecnologias
- Java 11+
- SecureRandom para aleatoriedade segura
- Programação orientada a objetos

## Como Executar
1. Clone o repositório
2. Compile e execute `Main.java`
3. Siga as instruções no console

## Melhorias Futuras
- [ ] Adicionar interface gráfica
- [ ] Implementar apostas
- [ ] Adicionar mais jogadores

## Diagrama de classe
<img width="272" height="749" alt="PP9DJuGm48Rl9Fo7XfCVsOCcNZWjGdUfgwp2OaoCXmfb8PPkqWyJO_plTbhPe5uwypwTpjjEkbIQIcr67WODfqgXZ3LlsowbibNeCmmGMg3MeXW1UdxnfAUY_KrQHZcJ-J_U62cPq81YD0ZjgRHrXx4muokJAaOLisMiT10Apf7gJTTnTdBg9NI75dDDnA07oi5omkoTSaCrcxEUglBmGVc" src="https://github.com/user-attachments/assets/e1160240-6472-49b8-95aa-216caca67634" />

## 🎮 Exemplo de Partida

<img width="1165" height="282" alt="image" src="https://github.com/user-attachments/assets/1107abf4-a8fb-495b-9ea1-ba1279dbd55d" />

1. **Distribuição Inicial**:
   - Jogador recebe: 9♦, 4♣, 4♥, 8♠, 5♥
   - Dealer substitui 1 carta automaticamente
   - 
<img width="944" height="205" alt="image" src="https://github.com/user-attachments/assets/5b7c3a82-46a3-4696-88ca-f19f79efd2df" />

2. **Substituição de Cartas**:
   - Jogador opta por substituir as cartas nas posições 2 e 4
   - 
<img width="371" height="428" alt="image" src="https://github.com/user-attachments/assets/c8d5c604-401f-4441-96c4-2555c3064a27" />

3. **Mãos Finais**:



4. **Resultado**:
- Jogador vence com um par de 5s
- Dealer não formou combinações
