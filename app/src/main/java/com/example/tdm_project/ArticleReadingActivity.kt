package com.example.tdm_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.widget.ImageViewCompat
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatViewInflater
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.tdm_project.R.string.publish_date
import com.example.tdm_project.data.news
import com.example.tdm_project.sharedPreferences.CustomBaseActivity

import kotlinx.android.synthetic.main.activity_article_reading.*

class ArticleReadingActivity : CustomBaseActivity() {

    lateinit var fabSettings : FloatingActionButton

    lateinit var layoutFabSave : LinearLayout
    lateinit var layoutFabShare : LinearLayout
    lateinit var layoutFabSharePrl :  LinearLayout
    lateinit var article : news


    var fabExpanded = true
    @SuppressLint("SetTextI18n")
    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_reading)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
        toolbar.setNavigationOnClickListener{
            finish()
        }

       intent?.let {
           article = intent.extras.getParcelable("article") as news
           Toast.makeText(this,article.Title + "" + article.Writer,Toast.LENGTH_LONG).show()
       }

        findViewById<AppCompatTextView>(R.id.title_input).text =  article.Title
        findViewById<AppCompatTextView>(R.id.date_input).text = getString(publish_date) + " " +article.Date
        findViewById<AppCompatTextView>(R.id.writer_input).text = article.Writer
        findViewById<AppCompatTextView>(R.id.article_text).text = article.Text
        findViewById<AppCompatImageView>(R.id.article_image)



       fabSettings = this.findViewById(R.id.fabSettings) as FloatingActionButton

         layoutFabSave = this.findViewById(R.id.layoutFabSave) as LinearLayout
         layoutFabShare = this.findViewById(R.id.layoutFabShare) as LinearLayout
         layoutFabSharePrl = this.findViewById(R.id.layoutFabSharePrl) as LinearLayout

        //When main Fab (Settings) is clicked, it expands if not expanded already.
        //Collapses if main FAB was open already.
        //This gives FAB (Settings) open/close behavior
        fabSettings.setOnClickListener {
            if (fabExpanded) {
                closeSubMenusFab()
            } else {
                openSubMenusFab()
            }
        }

        layoutFabSave.setOnClickListener {
            Toast.makeText(this, "saved done", Toast.LENGTH_SHORT).show()
        }

        layoutFabShare.setOnClickListener {
            Toast.makeText(this, "sharing done", Toast.LENGTH_SHORT).show()
        }

        layoutFabSharePrl.setOnClickListener {
            Toast.makeText(this, "profile done", Toast.LENGTH_SHORT).show()
        }

        //Only main FAB is visible in the beginning
        closeSubMenusFab()



    }
    private fun closeSubMenusFab(){
        layoutFabSave.visibility = View.INVISIBLE
        layoutFabShare.visibility = View.INVISIBLE
        layoutFabSharePrl.visibility = View.INVISIBLE

        fabSettings.setImageResource(R.drawable.ic_settings_black_24dp)
        fabExpanded = false
    }

    //Opens FAB submenus
    private fun openSubMenusFab(){
        layoutFabSave.visibility = View.VISIBLE
        layoutFabShare.visibility = View.VISIBLE
        layoutFabSharePrl.visibility = View.VISIBLE
        //Change settings icon to 'X' icon
        fabSettings.setImageResource(R.drawable.ic_close_black_24dp)
        fabExpanded = true

    }

}
