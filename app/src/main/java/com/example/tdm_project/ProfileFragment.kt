
package com.example.tdm_project

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
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




    companion object {
        fun getInstance() = ProfileFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.profile_fragment,
                       container,
            false)
          rootView.findViewById<FloatingActionButton>(R.id.param).setOnClickListener {
              // preparé l'activité d'ajout
              val intent = Intent(rootView.context, ParameterActivity::class.java)
              // lancer l'activité
              startActivity(intent)

          }

        return rootView
    }



}