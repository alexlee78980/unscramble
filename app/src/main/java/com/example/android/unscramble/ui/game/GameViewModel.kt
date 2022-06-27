package com.example.android.unscramble.ui.game

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.util.Log
import androidx.lifecycle.ViewModel
import java.net.HttpURLConnection

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
        Can't finish GitHub sharing process
        Successfully created project 'unscramble' on GitHub, but initial push failed:
        Invocation failed Unexpected end of file from server
                java.lang.RuntimeException: Invocation failed Unexpected end of file from server
        at git4idea.GitAppUtil.sendXmlRequest(GitAppUtil.java:30)
        at git4idea.http.GitAskPassApp.main(GitAskPassApp.java:58)
        Caused by: java.net.SocketException: Unexpected end of file from server
        at java.base/sun.net.www.http.HttpClient.parseHTTPHeader(HttpClient.java:866)
        at java.base/sun.net.www.http.HttpClient.parseHTTP(HttpClient.java:689)
        at java.base/sun.net.www.http.HttpClient.parseHTTPHeader(HttpClient.java:863)
        at java.base/sun.net.www.http.HttpClient.parseHTTP(HttpClient.java:689)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1615)
        at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1.    val tempWord = currentWord.toCharArray()
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