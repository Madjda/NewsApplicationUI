
package com.example.tdm_project

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*


class HomeFragment : Fragment() {




    companion object {
        fun getInstance() = HomeFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.home_fragment, container, false)


         var  btnChange= rootView.findViewById<Button>(R.id.btn_changeLang)

        btnChange.setOnClickListener {

            showChangeLanguageDialog()

        }



        return rootView
    }

    private fun showChangeLanguageDialog () {

        var languagesList= arrayOf("Français","العربية")
        var mBuilder = AlertDialog.Builder(context)
        mBuilder.setTitle("Changer La Langue")
        mBuilder.setSingleChoiceItems( languagesList,-1) { dialog , i: Int ->

       if (i==0) {
           setLocal("fr")
           activity!!.recreate()
       }
       else
       {
           setLocal("ar")
           activity!!.recreate()
       }

     dialog.dismiss()

        }

        mBuilder.setNeutralButton("Annuler") { dialog, which: Int ->
            dialog.dismiss()


        }

      var mDialog = mBuilder.create()
        mDialog.show()


    }

    private fun setLocal(lang: String) {
        var locale = Locale(lang)
        Locale.setDefault(locale)
        var config = Configuration()
        config.locale =locale
        activity!!.baseContext.resources.updateConfiguration(config,activity!!.baseContext.resources.displayMetrics)
        val editor = activity!!.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()

    }
    private fun loadLocate() {
        val sharedPreferences = activity!!.getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        setLocal(language)
    }

}