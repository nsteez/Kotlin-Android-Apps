package com.example.wordle

class Word {



    object FourLetterThings {
       val fourLetterThings = "Ball,Book,Card"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return FourLetterThings.fourLetterThings.split(",")
        }


        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].lowercase()
        }

    }
    object  FourLetterPlace{
        val fourLetterPlace = "Bank,City,East,Farm,Home,Pond,Lake,Moon,"
        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return FourLetterThings.fourLetterThings.split(",")
        }



        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].lowercase()
        }
    }

    object  FourLetterAnimals{
        val fourLetterAnimals = "Boar, Bird,Bull, Calf,Deer,Fawn,Goat,Hare,Hogg,Lamb, Mule,Mole,Musk,Seal,Wolf"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return FourLetterThings.fourLetterThings.split(",")
        }
        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].lowercase()
        }
    }
    object  FourLetterRandom{
        val fourLetterAnimals = "next, pull,ouch,buzz,fizz,java,yuzu,term"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return FourLetterThings.fourLetterThings.split(",")
        }
        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].lowercase()
        }
    }
}