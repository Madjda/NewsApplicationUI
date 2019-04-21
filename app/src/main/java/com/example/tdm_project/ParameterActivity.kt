package com.example.tdm_project

import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import com.example.tdm_project.data.Topic
import com.example.tdm_project.data.getTopics
import com.example.tdm_project.sharedPreferences.CustomBaseActivity
import com.example.tdm_project.sharedPreferences.PreferencesProvider

class ParameterActivity : CustomBaseActivity() {
    lateinit var modeSwitch : Switch
    lateinit var pref : PreferencesProvider
    var topics = ArrayList<Topic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for the shared preferences
        pref = PreferencesProvider(this)

        //get the view
        setContentView(R.layout.parameters)



        modeSwitch = this.findViewById(R.id.mode_switcher)

        //just to be current to the shared preferences theme
        if (pref.load()=="dark"){
            modeSwitch.isChecked = true
        }
        //the switch button actions : change the theme
        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //if it is switched then it is the dark mode
                pref.setDarkModeState("dark")
                recreate()
            } else {
                //if it is not pressed then it is the light mode
                pref.setDarkModeState("light")
                recreate()
            }
        }

        //set topics list
        topics = pref.loadTopicsList()
        initializeTopicsList()


    }

  private fun initializeTopicsList(){
      val list = getTopics()
      var layout = findViewById<LinearLayoutCompat>(R.id.topics_choice_holder)
      Toast.makeText(this,layout.toString(),Toast.LENGTH_LONG).show()
     list.forEach {
          val check = CheckBox(this)
          check.text = it.title
          if (topics.contains(it)){
              check.isChecked = true
          }
          check.setOnClickListener { v ->
              val checked = (v as CheckBox).isChecked
              if (checked) {
                  topics.add(it)
                  pref.setTopicsList(topics)
              } else {
                  topics.remove(it)
                  pref.setTopicsList(topics)
              }
          }
         layout.addView(check)
      }
  }

}