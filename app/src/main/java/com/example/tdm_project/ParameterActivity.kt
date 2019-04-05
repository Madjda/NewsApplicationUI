package com.example.tdm_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.Preference
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.util.Log
import android.widget.Switch
import com.example.tdm_project.sharedPreferences.CustomBaseActivity
import com.example.tdm_project.sharedPreferences.preferencesProvider

class ParameterActivity : CustomBaseActivity() {
    lateinit var modeSwitch : Switch
    lateinit var pref : preferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //for the shared preferences
       pref = preferencesProvider(this)

       /* if (pref.load() == "dark"){
            setTheme(R.style.DarkAppTheme)
        }else{
            setTheme(R.style.AppTheme)
        }
*/

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
        Log.i("here",modeSwitch.id.toString())


    }



}