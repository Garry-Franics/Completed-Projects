# Simple Card Game

This program simulates a three-card hand entered by the user to determine the winner between two players. The user inputs three cards in the form `RS` (e.g., `10H`, `AS`, `3D`), where `R` is the rank (`2`–`10`, `J`, `Q`, `K`, `A`) and `S` is the suit (`C`, `D`, `H`, `S`). The first card is for Player 1, and the next two are for Player 2. The program validates input, converts face cards to numeric values (`J=11`, `Q=12`, `K=13`, `A=14`), and compares ranks to determine the winner. It prints which card Player 2 plays and who wins the round. Invalid inputs (bad rank or suit) result in an error and exit.

**Example:**

Enter three cards (in form of RS): 10H 9D AS
Player 2 plays the AS.
Player 2 wins the round.
