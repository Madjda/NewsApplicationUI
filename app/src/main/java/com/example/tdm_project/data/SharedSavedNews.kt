package com.example.tdm_project.data

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.tdm_project.ArticleReadingActivity
import com.example.tdm_project.R

class SharedSavedNews {

    companion object {

       var sharedPosts = arrayListOf<news>(news("New President","Amine Blogs","17/03/2019","some new informations concerning this text",
           "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor libero eget lectus auctor feugiat. Maecenas fermentum est ut felis aliquet tempor. Duis porta magna justo, et ullamcorper mi ornare in. Etiam sed velit facilisis massa lobortis lobortis. Fusce facilisis commodo felis ut efficitur. Cras lobortis vitae massa id congue. Pellentesque augue nisl, elementum eu libero ut, aliquam ornare justo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec eget vulputate ipsum. Maecenas pellentesque suscipit lacinia. Nam lobortis molestie nulla quis condimentum.\n" +
                   "\n" +
                   "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                   "\n" +
                   "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                   "\n" ,"", "politics"))

        fun getListSharedPosts() : ArrayList<news> {
            return  sharedPosts
        }

        fun sharePost( item : news , c : Context)
        {
            var myIntent = Intent (Intent.ACTION_SEND)
            myIntent.setType("text/plain")
            myIntent.putExtra(Intent.EXTRA_SUBJECT,item.Title)
            myIntent.putExtra(Intent.EXTRA_TEXT,item.Text)
            myIntent.putExtra(Intent.EXTRA_TITLE,item.Second_title)
            c.startActivity(Intent.createChooser(myIntent,c.getResources().getString(R.string.share)))
        }
        fun shareProfilePost(item : news , c : Context)
        {
            if ( !sharedPosts.contains(item))  {sharedPosts.add(item)
                                               Toast.makeText(c, "news partagé avec succés ", Toast.LENGTH_SHORT).show() }
            else  Toast.makeText(c, "news déja partagé dans votre profile", Toast.LENGTH_SHORT).show()
        }
        fun savePost(item : news , c : Context){
            if ( !savedPosts.contains(item))  {savedPosts.add(item)
                Toast.makeText(c, "news enregistré avec succés", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(c, "news déja enregistré", Toast.LENGTH_SHORT).show()
        }

        var savedPosts = arrayListOf<news>(news("New President","Amine Blogs","17/03/2019","some new informations concerning this text",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor libero eget lectus auctor feugiat. Maecenas fermentum est ut felis aliquet tempor. Duis porta magna justo, et ullamcorper mi ornare in. Etiam sed velit facilisis massa lobortis lobortis. Fusce facilisis commodo felis ut efficitur. Cras lobortis vitae massa id congue. Pellentesque augue nisl, elementum eu libero ut, aliquam ornare justo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec eget vulputate ipsum. Maecenas pellentesque suscipit lacinia. Nam lobortis molestie nulla quis condimentum.\n" +
                    "\n" +
                    "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                    "\n" +
                    "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                    "\n" ,"", "politics"))

        fun getListSavedPosts() : ArrayList<news> {
            return  savedPosts
        }

        fun readArticle(item: news, context: Context) {
            val intent = Intent(context, ArticleReadingActivity::class.java)
                intent.putExtra("article",item)
                context.startActivity(intent)

        }


    }

}