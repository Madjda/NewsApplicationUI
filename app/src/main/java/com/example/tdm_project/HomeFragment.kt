
package com.example.tdm_project

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.tdm_project.adapters.horizCardAdapter
import com.example.tdm_project.adapters.vertCardAdapter
import com.example.tdm_project.data.getList
import com.example.tdm_project.data.news
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    lateinit var rootView : View
    lateinit var customHAdapter : horizCardAdapter
    lateinit var customVAdapter : vertCardAdapter
    var newsList = ArrayList<news>()



    companion object {
        fun getInstance() = HomeFragment()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //set the view
        rootView = inflater.inflate(R.layout.home_fragment, container, false)

        newsList = getList()


        var  btnChange= rootView.findViewById<Button>(R.id.btn_changeLang)
        btnChange.setOnClickListener {
            showChangeLanguageDialog()
        }

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

    private fun intialiserHorizontally() {
        val rv = rootView.findViewById<RecyclerView>(R.id.recyler_view_news)
        val layout = LinearLayoutManager(rootView.context)
        layout.orientation = LinearLayoutManager.HORIZONTAL
        rv.layoutManager = layout
        customHAdapter = horizCardAdapter(rootView.context,newsList)
        rv.adapter = customHAdapter
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