
package com.example.tdm_project

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.tdm_project.adapters.horizCardAdapter
import com.example.tdm_project.adapters.vertCardAdapter
import com.example.tdm_project.data.Topic
import com.example.tdm_project.data.getList
import com.example.tdm_project.data.news
import kotlin.collections.ArrayList



class HomeFragment : Fragment() {
    lateinit var rootView : View
    lateinit var customHAdapter : horizCardAdapter
    lateinit var customVAdapter : vertCardAdapter
    var newsList = ArrayList<news>()
    var topicsList = ArrayList<Topic>()



    companion object {
        fun getInstance() = HomeFragment()
    }



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //set the view
        rootView = inflater.inflate(R.layout.home_fragment, container, false)

        GetTopics()
        newsList = getList()




        var btnHoriz = rootView.findViewById<ImageButton>(R.id.btn_horizt_display)
        btnHoriz.setOnClickListener{
            intialiserHorizontally()
        }

        var btnVert = rootView.findViewById<ImageButton>(R.id.btn_vert_display)
        btnVert.setOnClickListener{
            intialiserVertically()
        }

        return rootView
    }

    private fun intialiserVertically() {
        val rv = rootView.findViewById<RecyclerView>(R.id.recyler_view_news)
        val layout = LinearLayoutManager(rootView.context)
        layout.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = layout
        customVAdapter = vertCardAdapter(rootView.context,newsList)
        rv.adapter = customVAdapter
    }

    private fun intialiserHorizontally()
    {
        val rv = rootView.findViewById<RecyclerView>(R.id.recyler_view_news)
        val layout = LinearLayoutManager(rootView.context)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        rv.layoutManager = layout
        customHAdapter = horizCardAdapter(rootView.context,newsList)
        rv.adapter = customHAdapter
    }




    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun GetTopics(){
        var layout = rootView.findViewById<LinearLayoutCompat>(R.id.Topics_buttom_holder)
        var style = 0
        var num = 0

        topicsList.add(Topic("politics", rootView.context.resources.getDrawable(R.drawable.newspaper,null)))
        topicsList.add(Topic("techno ", rootView.context.resources.getDrawable(R.drawable.tech_icon,null)))
        topicsList.add(Topic("art", rootView.context.resources.getDrawable(R.drawable.art_icon,null)))
        topicsList.add(Topic("art", rootView.context.resources.getDrawable(R.drawable.art_icon,null)))

        topicsList.forEach {
            var btn =  AppCompatButton(rootView.context)
            btn.setCompoundDrawablesWithIntrinsicBounds(it.IconLink,null,null,null)
            btn.setPadding(45,0,45,0)
            btn.compoundDrawablePadding = 20
            btn.maxWidth = 450
            btn.minWidth = 350
            btn.minHeight = 200
            btn.text = it.title
            btn.setTextColor(rootView.resources.getColor(R.color.white , null))
            when (num){
                0-> style = R.drawable.style_blue
                1-> style = R.drawable.style_red
                2-> style = R.drawable.style_green
            }
            num ++
            if (num ==3)num =0

            btn.background = rootView.resources.getDrawable(style,null)
            layout.addView(btn)
}
}

}