package com.elliot.breakingbadapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.repositories.BreakingBadRepository
import kotlinx.coroutines.launch
import java.util.*

class CategoryCharacterViewModel (application: Application) : AndroidViewModel(application) {
    private val breakingBadRepository = BreakingBadRepository();
    val listCharacterLiveData = MutableLiveData<List<Character>>()

    fun getCharactersByCategory(category:String) {
        viewModelScope.launch {
            listCharacterLiveData.postValue(breakingBadRepository.getCharactersByCategory(category))
        }
    }

}