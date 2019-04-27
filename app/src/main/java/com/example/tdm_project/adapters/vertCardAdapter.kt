package com.example.tdm_project.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tdm_project.ArticleReadingActivity
import com.example.tdm_project.R
import com.example.tdm_project.data.SharedSavedNews
import com.example.tdm_project.data.news

class vertCardAdapter(val context: Context, val news : ArrayList<news>) : RecyclerView.Adapter<vertCardAdapter.ViewHolder> (){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val newsCard = LayoutInflater.from(context).inflate(R.layout.vert_news_view,p0,false)
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
        lateinit var btnShareProfile : AppCompatImageButton
        lateinit var btnSave : AppCompatImageButton
        init {

        }
          fun bind(item : news){
              objet.findViewById<TextView>(R.id.news_title).text = item.Title
              objet.findViewById<TextView>(R.id.news_date).text = item.Date + " By"
              objet.findViewById<TextView>(R.id.news_descrp).text = item.Second_title
              objet.findViewById<TextView>(R.id.news_writer).text = item.Writer
              objet.findViewById<ImageView>(R.id.news_image)
              btnShareProfile = objet.findViewById<AppCompatImageButton>(R.id.btn_share_profile)
              btnShare = objet.findViewById<AppCompatImageButton>(R.id.btn_share)
              btnSave = objet.findViewById<AppCompatImageButton>(R.id.btn_save)
              btnShare.setOnClickListener {
                  var myIntent = Intent (Intent.ACTION_SEND)
                  myIntent.setType("text/plain")
                  myIntent.putExtra(Intent.EXTRA_SUBJECT,item.Title)
                  myIntent.putExtra(Intent.EXTRA_TEXT,item.Text)
                  myIntent.putExtra(Intent.EXTRA_TITLE,item.Second_title)
                  context.startActivity(Intent.createChooser(myIntent,context.getResources().getString(R.string.share)))

              }

              btnShareProfile.setOnClickListener {

                  SharedSavedNews.getListSharedPosts().add(item)
                  Log.i("SIIIZEEE",  SharedSavedNews.getListSharedPosts().size.toString())

              }

              btnSave.setOnClickListener {

                  SharedSavedNews.getListSavedPosts().add(item)
                  Log.i("SIIIZEEE",  SharedSavedNews.getListSavedPosts().size.toString())

              }
              val intent = Intent(context,ArticleReadingActivity::class.java)
              objet.setOnClickListener {
                  intent.putExtra("article",item)
                  context.startActivity(intent)
              }
          }


    }
}