@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.example.tdm_project.data

import android.graphics.drawable.Drawable
import com.example.tdm_project.R

data class Topic(
    var title : String ?,
    var IconLink : Int
)
fun getTopics() : ArrayList<Topic>{
    val topicsList = ArrayList<Topic>()
    topicsList.add(Topic("politics",  R.drawable.newspaper ))
    topicsList.add(Topic("tech",  R.drawable.tech_icon ))
    topicsList.add(Topic("art" ,R.drawable.art_icon))
    topicsList.add(Topic("science", R.drawable.art_icon))
    topicsList.add(Topic("sport", R.drawable.art_icon))
    topicsList.add(Topic("economics", R.drawable.art_icon))
    topicsList.add(Topic("culture", R.drawable.art_icon))



    return  topicsList
}