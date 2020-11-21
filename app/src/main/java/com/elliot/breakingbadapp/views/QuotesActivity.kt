package com.elliot.breakingbadapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.adapters.QuoteAdapter
import com.elliot.breakingbadapp.databinding.ActivityQuotesBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.Quote
import com.elliot.breakingbadapp.viewmodels.QuotesActivityViewModel
import com.google.android.material.button.MaterialButton

class QuotesActivity : AppCompatActivity() {
    private lateinit var editAuthor: EditText
    val QuotesActivityViewModel : QuotesActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityQuotesBinding = DataBindingUtil.setContentView(this,R.layout.activity_quotes)

        editAuthor = findViewById<EditText>(R.id.EditAuthor)


        val  buttonSave = findViewById<MaterialButton>(R.id.button_seach)
        buttonSave.setOnClickListener {
            


            QuotesActivityViewModel.listQuoteLiveData.observe(this,
                Observer<List<Quote>> {
                    val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewQuote)
                    val QuoteAdapter = QuoteAdapter()

                    recyclerViewData.layoutManager = LinearLayoutManager(this)
                    recyclerViewData.adapter = QuoteAdapter
                    QuoteAdapter.addResults(it)
                    QuoteAdapter.notifyDataSetChanged()
                })

            QuotesActivityViewModel.characterLiveData.observe(this,
                Observer<List<Character>> { character ->
                    if(character.isEmpty()){
                        Toast.makeText(this,"NO HAY PERSONAJE CON ESE NOMBRE", Toast.LENGTH_LONG).show()
                        return@Observer
                    }
                    binding.character = character[0]
                    binding.executePendingBindings()
                }
            )

            QuotesActivityViewModel.getCharacterByName(editAuthor.text.toString())


            QuotesActivityViewModel.getQuotesByAuthor(editAuthor.text.toString())

        }
    }
}