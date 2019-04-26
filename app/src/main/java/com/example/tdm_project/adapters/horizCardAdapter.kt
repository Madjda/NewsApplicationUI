package com.example.tdm_project.adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.tdm_project.ArticleReadingActivity
import com.example.tdm_project.R
import com.example.tdm_project.data.news

class horizCardAdapter(val context: Context , val news : ArrayList<news>) : RecyclerView.Adapter<horizCardAdapter.ViewHolder> (){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val newsCard = LayoutInflater.from(context).inflate(R.layout.horiz_news_view,p0,false)
        return ViewHolder(newsCard)
    }

    override fun getItemCount(): Int {
        return  news.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val newsContent = news[p1]
        p0.bind(newsContent)
    }
    fun updateList(newlist: List<news>) {
        news.clear()
        news.addAll(newlist)
        this.notifyDataSetChanged()
    }

    inner class ViewHolder (private val objet: View) : RecyclerView.ViewHolder(objet){
        lateinit var btnShare : AppCompatImageButton
          fun bind(item : news){
              objet.findViewById<TextView>(R.id.news_title).text = item.Title
              objet.findViewById<TextView>(R.id.news_date).text = item.Date + " By"
              objet.findViewById<TextView>(R.id.news_descrp).text = item.Second_title
              objet.findViewById<TextView>(R.id.news_writer).text = item.Writer
              objet.findViewById<ImageView>(R.id.news_image)
               btnShare = objet.findViewById<AppCompatImageButton>(R.id.btn_share)
              btnShare.setOnClickListener {
                   var myIntent = Intent (Intent.ACTION_SEND)
                   myIntent.setType("text/plain")
                  var shareBody ="THE BODY OF POST"
                  var shareSub =" THE BODY SUBJECT"
                  myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub)
                  myIntent.putExtra(Intent.EXTRA_TEXT,shareBody)
                  context.startActivity(Intent.createChooser(myIntent,"Sharing Post"))
              }

              val intent = Intent(context, ArticleReadingActivity::class.java)
              objet.setOnClickListener {
                  intent.putExtra("article",item)
                  context.startActivity(intent)
              }

          }





    }
}