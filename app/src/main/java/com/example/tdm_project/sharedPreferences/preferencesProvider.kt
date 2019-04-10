package com.example.tdm_project.sharedPreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class preferencesProvider (context: Context){

    internal var mySharedPref : SharedPreferences = context.getSharedPreferences("filename",Context.MODE_PRIVATE)
    lateinit var editor : SharedPreferences.Editor



    //Create keys to manage the shared preferences
    companion object {
        const val DEVELOP_MODE = false
        private const val DEVICE_TOKEN = "data.source.prefs.DEVICE_TOKEN"
    }


   //Save the Dark mode
   @SuppressLint("CommitPrefEdits")
   fun setDarkModeState(state : String){
       editor = mySharedPref.edit()
       editor.putString("current_theme",state)
       editor.commit()

   }

    //Get the dark Mode State
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun load(): String {
        return mySharedPref.getString("current_theme","light")
    }


    //create a variable to access to the shared preferences
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)



    //enable write/read from my preference provider
    var deviceToken = preferences.getString(DEVICE_TOKEN, "")
        set(value) = preferences.edit().putString(DEVICE_TOKEN,     value).apply()

}
