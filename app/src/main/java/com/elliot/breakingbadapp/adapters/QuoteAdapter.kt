package com.elliot.breakingbadapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.databinding.CardQuotesBinding
import com.elliot.breakingbadapp.models.Quote

class QuoteAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val listQuote = mutableListOf<Quote>()


    fun addResults(data: List<Quote>) {
        listQuote.addAll(data);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardBinding = CardQuotesBinding.inflate(layoutInflater, parent, false)
        return QuoteViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is QuoteViewHolder){
            val quoteView = listQuote[position]
            holder.onBind(quoteView)

        }

    }
    override fun getItemCount(): Int {
        return listQuote.size
    }

    inner class QuoteViewHolder(private val cardQuoteBinding: CardQuotesBinding) : RecyclerView.ViewHolder(cardQuoteBinding.root) {

        fun onBind(quoteView: Quote) {
            cardQuoteBinding.quote = quoteView
            cardQuoteBinding.executePendingBindings()
        }

    }
}