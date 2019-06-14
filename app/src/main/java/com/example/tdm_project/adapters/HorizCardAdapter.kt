package com.example.tdm_project.adapters

import android.content.Context
import android.support.v7.widget.AppCompatImageButton
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tdm_project.R
import com.example.tdm_project.data.SharedSavedNews
import com.example.tdm_project.data.news
import com.squareup.picasso.Picasso


class HorizCardAdapter(val context: Context, val news : ArrayList<news>) : RecyclerView.Adapter<HorizCardAdapter.ViewHolder> (){
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
        lateinit var btnMenu : AppCompatImageButton

          fun bind(item : news){
              objet.findViewById<TextView>(R.id.news_title).text = item.Title
              objet.findViewById<TextView>(R.id.news_date).text = item.Date + ","
              objet.findViewById<TextView>(R.id.news_descrp).text = item.Second_title
              objet.findViewById<TextView>(R.id.news_writer).text = item.Writer
              val img =objet.findViewById<ImageView>(R.id.news_image)
              Picasso
                  .get() // give it the context
                  .load(item.Image)
                  .into(img)

              btnMenu = objet.findViewById(R.id.menu_button)
              btnMenu.setOnClickListener {
                  showPopupMenu(btnMenu,item,context)
              }




              objet.setOnClickListener {
                  SharedSavedNews.readArticle(item,context)
              }



          }
        fun showPopupMenu(view: View, item: news , context: Context) {
            // inflate menu
            val popup = PopupMenu(view.context, view)
            val inflater = popup.menuInflater
            inflater.inflate(R.menu.card_menu, popup.menu)
            popup.setOnMenuItemClickListener(CustomMenuItem(item,context))
            popup.show()
        }






    }



}