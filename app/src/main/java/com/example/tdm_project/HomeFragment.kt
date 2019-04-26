
package com.example.tdm_project

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.tdm_project.adapters.horizCardAdapter
import com.example.tdm_project.adapters.vertCardAdapter
import com.example.tdm_project.data.Topic
import com.example.tdm_project.data.getList
import com.example.tdm_project.data.news
import com.example.tdm_project.sharedPreferences.PreferencesProvider
import java.util.*
import kotlin.collections.ArrayList





class HomeFragment : Fragment() {
    lateinit var rootView : View
    lateinit var customHAdapter : horizCardAdapter
    lateinit var customVAdapter : vertCardAdapter
    lateinit var rv : RecyclerView
    lateinit var pref : PreferencesProvider

    var newsList = ArrayList<news>()
    var selectedList = ArrayList<news>()
    var topicsList = ArrayList<Topic>()
    var choice : Int = 1



    companion object {
        fun getInstance() = HomeFragment()
    }



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //set the view
        rootView = inflater.inflate(R.layout.home_fragment, container, false)
        pref = PreferencesProvider(rootView.context)

        //prepare the topics on the top of the fragment
        GetTopics()


        //set list of news
        newsList = getList()
        intialiserHorizontally()






        val btnHoriz = rootView.findViewById<ImageButton>(R.id.btn_horizt_display)
        btnHoriz.setOnClickListener{
            intialiserHorizontally()
            choice = 1
        }

        val btnVert = rootView.findViewById<ImageButton>(R.id.btn_vert_display)
        btnVert.setOnClickListener{
            intialiserVertically()
            choice = 2
        }

        val btnAll = rootView.findViewById<AppCompatButton>(R.id.all_topics_btn)
        btnAll.setOnClickListener {
            newsList = getList()
            when(choice){
                1 -> intialiserHorizontally()
                2 -> intialiserVertically()
            }
        }

        return rootView
    }

    private fun intialiserVertically() {
        rv = rootView.findViewById<RecyclerView>(R.id.recyler_view_news)
        val layout = LinearLayoutManager(rootView.context)
        layout.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = layout
        customVAdapter = vertCardAdapter(rootView.context,newsList)
        rv.adapter = customVAdapter
    }

    private fun intialiserHorizontally() {
        rv = rootView.findViewById<RecyclerView>(R.id.recyler_view_news)

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

        topicsList = pref.loadTopicsList()
        topicsList.forEach {

            var btn =  AppCompatButton(rootView.context)
            val draw = rootView.resources.getDrawable(it.IconLink,null)

            btn.setCompoundDrawablesWithIntrinsicBounds(draw,null,null,null)
            btn.setPadding(45,0,45,0)
            btn.compoundDrawablePadding = 20
            btn.maxWidth = 450
            btn.minWidth = 350
            btn.minHeight = 200
            val titre = it.title
            btn.text = titre
            btn.setTextColor(rootView.resources.getColor(R.color.white , null))

            when (num){
                0-> style = R.drawable.style_blue
                1-> style = R.drawable.style_red
                2-> style = R.drawable.style_green
            }

            num = (num+1)%3

            btn.background = rootView.resources.getDrawable(style,null)

            btn.setOnClickListener {
                chargeNews(titre)
            }

            layout.addView(btn)
        }
    }

    private fun chargeNews(titre: String?) {
         selectedList.clear()
         newsList = getList()
         newsList.forEach {
             if (it.category == titre) selectedList.add(it)
         }
         newsList = selectedList
         updateListTopics(selectedList)
    }

    private fun updateListTopics(myNewList : ArrayList<news>){
        when (choice) {
            1-> customHAdapter.updateList(myNewList)
            2-> customVAdapter.updateList(myNewList)
        }
    }

}