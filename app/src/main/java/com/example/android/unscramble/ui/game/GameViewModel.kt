package com.example.android.unscramble.ui.game

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }
    private var _score = 0
    private var _currentWordCount = 0
    private lateinit var _currentScrambledWord: String

    val currentScrambledWord: String
        get() = _currentScrambledWord

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }
}