
package com.example.tdm_project

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.AppCompatButton
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView


class ProfileFragment : Fragment() {


    lateinit var ModeSwitch : Switch


    companion object {
        fun getInstance() = ProfileFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.profile_fragment, container, false)
    ModeSwitch = rootView.findViewById(R.id.mode_switcher)

        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
         ModeSwitch.isChecked = true
        }

        ModeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                updateApp()

            } else {
                // The switch is disabled
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                updateApp()

                // Set the app background color to light gray
            }
        }
        Log.i("here",ModeSwitch.id.toString())

        return rootView
    }

    private fun updateApp() {
        val intent = Intent(context,ProfileFragment::class.java)
        startActivity(intent)
    }


}