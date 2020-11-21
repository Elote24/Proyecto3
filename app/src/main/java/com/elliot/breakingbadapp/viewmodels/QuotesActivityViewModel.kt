package com.elliot.breakingbadapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.repositories.BreakingBadRepository
import kotlinx.coroutines.launch

class QuotesActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val breakingBadRepository = BreakingBadRepository();
    val listQuoteLiveData = MutableLiveData<List<Quote>>()
    val characterLiveData = MutableLiveData<List<Character>>()

    fun getQuotesByAuthor(author:String) {
        viewModelScope.launch {
            listQuoteLiveData.postValue(breakingBadRepository.getQuoteByAuthory(author))
        }
    }

    fun getCharacterByName(name:String) {
        viewModelScope.launch {
            val character=breakingBadRepository.getCharacterByName(name)
            characterLiveData.postValue(character)
        }
    }

}