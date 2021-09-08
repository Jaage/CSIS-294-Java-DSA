This applicatoin is an interactive game where a user enters the merkle root of 4 words, and then must enter the 4 words one at a time while a Merkle and Rogue thread 
simlutaneously attempt to grab the words. If the rogue thread grabs a word, the player receives a strike. 3 Strikes and you lose. Once the merkle thread grabs four words the
program will check to see if the merkle root created by the 4 words matches the merkle root provided at the start.

Each thread periodically checks if there is a word in the queue and if not, sleeps for a random amount of time between 3 and 7 seconds before checking again. The user must
properly time when they enter a word to ensure the merkle thread grabs the word and not the rogue thread.
