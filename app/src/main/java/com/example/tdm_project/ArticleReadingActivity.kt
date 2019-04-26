package com.example.tdm_project

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast
import com.example.tdm_project.data.news

import kotlinx.android.synthetic.main.activity_article_reading.*

class ArticleReadingActivity : AppCompatActivity() {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_reading)
        setSupportActionBar(toolbar)

       intent?.let {
           val article = intent.extras.getParcelable("article") as news
           Toast.makeText(this,article.Title + "" + article.Writer,Toast.LENGTH_LONG).show()
       }
    }

}
