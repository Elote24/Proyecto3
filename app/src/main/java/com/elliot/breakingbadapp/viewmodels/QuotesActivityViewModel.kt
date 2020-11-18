package com.elliot.breakingbadapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.models.QuoteView
import com.elliot.breakingbadapp.repositories.BreakingBadRepository
import kotlinx.coroutines.launch

class QuotesActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val breakingBadRepository = BreakingBadRepository();
    val listQuoteLiveData = MutableLiveData<List<Quote>>()

    fun getQuotesByAuthor(author:String) {
        viewModelScope.launch {
            listQuoteLiveData.postValue(breakingBadRepository.getQuoteByAuthory(author))
        }
    }

}