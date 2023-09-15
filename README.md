# Blackjack

For my Object Oriented Design final project, I created a BlackJack game. BlackJack is a game where a player starts with
2 cards, and keeps being dealt cards until he/she wants to stop, with the goal of getting as close
to 21 as possible. Face cards count as 10 while Aces can be either 1 or 11 (the player can decide
which one). If the player’s card total goes over 21, they “Bust” and automatically lose. The
player is playing against the dealer who has the same goal, and the dealer’s turn is after the
player.

To run my program, simply clone the repository, open the Driver file and run the main method. A run through will
look something like this:

<img width="713" alt="image" src="https://github.com/liampotts/Blackjack/assets/90870685/3bfdad3d-e8e9-4e34-9f3e-54f8d6cbc59b">


I used 3 design patterns in my project. The first design pattern is in the Deck class where I used
singleton. I decided this was an appropriate use because I wanted to restrict the deck to only the
one that was in play. This helps to ensure it was shuffled properly and to ensure that the
player/client could not manipulate the deck.

The next pattern I used was the Facade pattern. I used this pattern as a way to have difficulty
levels without making the program too complex. Depending on the difficulty level, the player can
either see both of the dealers first 2 cards (if on Easy) or only 1 of the dealers first 2 cards (if on
Hard). Additionally, if on Easy a tie goes to the player while on Hard a tie goes to the dealer. The
Facade pattern allowed me to have these separate functions in the same GameFacade be
independent of the actual implementation in the EasyGame and HardGame classes. Using the
facade pattern in this way also made my code a lot more readable.

Finally, I used the State pattern to keep track of if the Game was still active or not. I used this
pattern because the behavior of the driver program is determined by if the game is still running or
not, so it made sense to keep track of this with a State pattern. Additionally, if I want to add
something like betting to my code, I will not have to change it as much since I can simply add
more states for the player having enough money etc. When the game is over, the GameState is
changed from ActiveGameState to GameOverState and “Game Over” is printed by calling the
getState() method.

Finally, here is my UML diagram:

<img width="716" alt="image" src="https://github.com/liampotts/Blackjack/assets/90870685/e5cf9cdb-9237-466b-92d6-0783d8a12d20">

