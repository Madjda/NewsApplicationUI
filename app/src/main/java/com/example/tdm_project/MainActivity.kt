package com.example.tdm_project
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar;
import android.util.Log
import android.view.MenuItem

val TAG = "TAG-MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById(R.id.TopToolbar) as Toolbar
        setSupportActionBar(toolbar)
        setUpBottomNavigationBar()
    }

    // Sending the token to the fragement
    private fun setUpBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    val fragment: Fragment
                    when (item.getItemId()) {
                        R.id.nav_home -> fragment = HomeFragment.getInstance()
                        R.id.nav_profile -> fragment = ProfileFragment.getInstance()
                        R.id.nav_saved-> fragment = SavedFragment.getInstance()
                        else -> fragment = HomeFragment.getInstance()
                    }
                    replaceFragment(fragment)
                    return true
                }
            })
        bottomNavigationView.selectedItemId = R.id.nav_home  /// consult .. just for the test
    }

    private fun attachArgs(tag: String, data: String): Bundle {
        var bundle = Bundle()
        bundle.putString(tag, data)
        return bundle
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }




}
