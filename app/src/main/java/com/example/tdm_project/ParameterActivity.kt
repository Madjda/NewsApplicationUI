package com.example.tdm_project

import android.app.Activity
import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v4.content.FileProvider
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.tdm_project.sharedPreferences.CustomBaseActivity
import com.example.tdm_project.sharedPreferences.preferencesProvider
import kotlinx.android.synthetic.main.parameters.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat


class ParameterActivity : CustomBaseActivity() {
    val TAKE_PICTURE = 1
    val SELECT_PICTURE = 2
    lateinit var modeSwitch: Switch
    lateinit var pref: preferencesProvider
    lateinit var btnEditPhoto : Button
    lateinit var btnChange : Button
    lateinit var imageView : ImageView
    var currentPath : String? = null


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //for the shared preferences
        pref = preferencesProvider(this)



        /* if (pref.load() == "dark"){
            setTheme(R.style.DarkAppTheme)
        }else{
            setTheme(R.style.AppTheme)
        }
*/      ///// PopUp Picture


        setContentView(R.layout.parameters)
        imageView = this.findViewById<ImageView>(R.id.image)
        btnEditPhoto = this.findViewById<View>(R.id.btn_edit_pic) as Button
        modeSwitch = this.findViewById(R.id.mode_switcher)


        //just to be current to the shared preferences theme
        if (pref.load() == "dark") {
            modeSwitch.isChecked = true
        }

        //the switch button actions : change the theme
        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

                //if it is switched then it is the dark mode
                pref.setDarkModeState("dark")
                recreate()

            }
            else {

                //if it is not pressed then it is the light mode
                pref.setDarkModeState("light")
                recreate()

            }
        }
        Log.i("here", modeSwitch.id.toString())

//Languages :


        btnChange= this.findViewById<Button>(R.id.btn_changeLang)
        btnChange.setOnClickListener {
            showChangeLanguageDialog()
        }


        btnEditPhoto.setOnClickListener{
            val inflater:LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.pop_up_photo_view,null)

            // Initialize a new instance of popup window
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            // Set an elevation for the popup window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popupWindow.elevation = 10.0F
            }


            // If API level 23 or higher then execute the code
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // Create a new slide animation for popup window enter transition
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn

                // Slide animation for popup window exit transition
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.RIGHT
                popupWindow.exitTransition = slideOut
                popupWindow.setFocusable(true)
                popupWindow.update()
            }
            // popupWindow.setBackgroundDrawable(BitmapDrawable())

            // Get the widgets reference from custom view
            var btnGallery = view.findViewById<Button>(R.id.btn_gallery)
            var btnCamera = view.findViewById<Button>(R.id.btn_camera)

               btnGallery.setOnClickListener {
                   Toast.makeText(this,"GALLERY",Toast.LENGTH_SHORT).show()
                  DispatchGalleryIntent ()

               }
            btnCamera.setOnClickListener {
             Toast.makeText(this,"CAMERA",Toast.LENGTH_SHORT).show()
                DispatchCameraIntent ()


            }


            // Finally, show the popup window on app
            TransitionManager.beginDelayedTransition(root_layout)
            popupWindow.showAtLocation(
                root_layout, // Location to display popup window
                Gravity.CENTER_HORIZONTAL, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
        }


    }

    /////Language

    private fun showChangeLanguageDialog () {

        var languagesList= arrayOf("Français","العربية")
        val lang = pref.getLoginCount()
        val index = languagesList.indexOf(lang)
        var mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Changer La Langue")
        mBuilder.setSingleChoiceItems( languagesList,0) { dialog , i: Int ->

            if (i==0) {
                pref.setLoginCount("fr")
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
            else
            {
                pref.setLoginCount("ar")
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }

            dialog.dismiss()

        }

        mBuilder.setNeutralButton("Annuler") { dialog, which: Int ->
            dialog.dismiss()


        }

        var mDialog = mBuilder.create()
        mDialog.show()


    }







    //Changing Profile Picture

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK )
        { try
        {
          val file = File(currentPath)
          val uri = Uri.fromFile(file)
            imageView.setImageURI(uri)
        }catch ( e: IOException)
        {
            e.printStackTrace()
        }

        }

        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK )
        { try
        {
         val uri = data!!.data
            imageView.setImageURI(uri)
        }catch ( e: IOException)
        {
            e.printStackTrace()
        }

        }



    }
    private fun DispatchGalleryIntent()
    {
      val intent = Intent()
        intent.type="image/*"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"selectionner une image") , SELECT_PICTURE)
    }
    private fun DispatchCameraIntent() {
   val intent = Intent (MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null)
        {
            var photoFile: File? = null
            try
            {
            photoFile = createImage()

            }catch (e : IOException )
            {
                e.printStackTrace()
            }
            if ( photoFile != null )
            {
                var photoUri = FileProvider.getUriForFile(this ,"com.example.tdm_project.fileProvider"
                    ,photoFile)
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent,TAKE_PICTURE)
            }

        }
    }

    fun createImage () : File
    {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss")
        val imageName = "JPEG_"+timeStamp+"_"
        var storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image = File.createTempFile(imageName,".jpg",storageDir)
        currentPath = image.absolutePath
        return image
    }








}