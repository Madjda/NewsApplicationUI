package com.example.tdm_project.data

import android.os.Parcel
import android.os.Parcelable
import com.example.tdm_project.sharedPreferences.PreferencesProvider
import com.google.gson.annotations.SerializedName


data class news (
    var Title : String?,
    var Writer : String?,
    var Date : String,
    var Second_title : String?,
    var Text : String,
    var Image : String?,
    var category : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Title)
        parcel.writeString(Writer)
        parcel.writeString(Date)
        parcel.writeString(Second_title)
        parcel.writeString(Text)
        parcel.writeString(Image)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<news> {
        override fun createFromParcel(parcel: Parcel): news {
            return news(parcel)
        }

        override fun newArray(size: Int): Array<news?> {
            return arrayOfNulls(size)
        }
    }

}

fun getList ( ) : ArrayList<news>{
       var NewsList = ArrayList<news>()

    NewsList.addAll(listOf(news("New President","Amine Blogs","17/03/2019","some new informations concerning this text",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor libero eget lectus auctor feugiat. Maecenas fermentum est ut felis aliquet tempor. Duis porta magna justo, et ullamcorper mi ornare in. Etiam sed velit facilisis massa lobortis lobortis. Fusce facilisis commodo felis ut efficitur. Cras lobortis vitae massa id congue. Pellentesque augue nisl, elementum eu libero ut, aliquam ornare justo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec eget vulputate ipsum. Maecenas pellentesque suscipit lacinia. Nam lobortis molestie nulla quis condimentum.\n" +
                                        "\n" +
                                        "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                        "\n" +
                                        "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                        "\n" ,"", "politics"),
                           news("Something incredible","Teenager Blogs","24/04/2019","some new informations concerning this text",
                               "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravida.\n" +
                                       "\n" +
                                       "Etiam a nulla nec eros tincidunt tincidunt. Nullam gravida augue eu nisl maximus, ut aliquam diam vulputate. Vestibulum gravida felis magna, quis tristique nisl finibus ac. Fusce eget leo sollicitudin, accumsan ligula vitae, malesuada dui. Ut hendrerit nisi et dolor pretium, vitae dignissim risus fringilla. Mauris semper sem quis felis consequat mattis. Nunc commodo nulla tortor, in lacinia justo dignissim ullamcorper. Mauris interdum laoreet magna sit amet volutpat. Nullam viverra vehicula leo quis vehicula. In sagittis commodo velit sed cursus. Praesent vel suscipit ex, ac fringilla sem. Praesent iaculis dignissim egestas. " +
                                       "Praesent sollicitudin venenatis posuere.","" , "media"),
                           news("Black Hole","Researchers","22/04/2019","Asome new informations concerning this text",
                               "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravida.\n" +
                                       "\n" +
                                       "Etiam a nulla nec eros tincidunt tincidunt. Nullam gravida augue eu nisl maximus, ut aliquam diam vulputate. Vestibulum gravida felis magna, quis tristique nisl finibus ac. Fusce eget leo sollicitudin, accumsan ligula vitae, malesuada dui. Ut hendrerit nisi et dolor pretium, vitae dignissim risus fringilla. Mauris semper sem quis felis consequat mattis. Nunc commodo nulla tortor, in lacinia justo dignissim ullamcorper. Mauris interdum laoreet magna sit amet volutpat. Nullam viverra vehicula leo quis vehicula. In sagittis commodo velit sed cursus. Praesent vel suscipit ex, ac fringilla sem. Praesent iaculis dignissim egestas. Praesent sollicitudin venenatis posuere.","","politics"),
                           news("Scientfic explication","John Aisun","13/12/2018","Android developers group",
                               "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tempor libero eget lectus auctor feugiat. Maecenas fermentum est ut felis aliquet tempor. Duis porta magna justo, et ullamcorper mi ornare in. Etiam sed velit facilisis massa lobortis lobortis. Fusce facilisis commodo felis ut efficitur. Cras lobortis vitae massa id congue. Pellentesque augue nisl, elementum eu libero ut, aliquam ornare justo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec eget vulputate ipsum. Maecenas pellentesque suscipit lacinia. Nam lobortis molestie nulla quis condimentum.\n" +
                                       "\n" +
                                       "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                       "\n" +
                                       "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                       "\n","" , "science"),
                           news("new mobile from sumsung","Sumsung groups","16/02/2018","some new informations concerning this text",
                               "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                       "\n" +
                                       "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                       "\n" +
                                       "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravid",
                               "","tech"),
                           news("AI for android developers","Android developers group","12/04/2019","some new informations concerning this text",
                               "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravida.\n" +
                                       "\n" +
                                       "Etiam a nulla nec eros tincidunt tincidunt. Nullam gravida augue eu nisl maximus, ut aliquam diam vulputate. Vestibulum gravida felis magna, quis tristique nisl finibus ac. Fusce eget leo sollicitudin, accumsan ligula vitae, malesuada dui. Ut hendrerit nisi et dolor pretium, vitae dignissim risus fringilla. Mauris semper sem quis felis consequat mattis. Nunc commodo nulla tortor, in lacinia justo dignissim ullamcorper. Mauris interdum laoreet magna sit amet volutpat. Nullam viverra vehicula leo quis vehicula. In sagittis commodo velit sed cursus. Praesent vel suscipit ex, ac fringilla sem. Praesent iaculis dignissim egestas. Praesent sollicitudin venenatis posuere.",
                               "","tech"),
                           news("ML : what's next?","Google search","15/03/2019","some new informations concerning this text","Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                   "\n" +
                                   "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                   "\n" +
                                   "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravid","","tech"),
                           news("Algeria revolution","el Watan","14/03/2018","some new informations concerning this text",
                               "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                       "\n" +
                                       "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                       "\n" +
                                       "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravid"
                               ,"", "politics"),
                           news("How to pass into the next level in democracy?","Mohammed K","12/01/2019","some new informations concerning this text",
                               "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                       "\n" +
                                       "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                       "\n" +
                                       "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravid","","polutics"),
                           news("Layouts and sizes","Android developers group","13/05/2019","some new informations concerning this text",
                               "Integer interdum diam augue, nec suscipit sem condimentum convallis. Fusce posuere semper fermentum. Nam dictum nisi quis mi sagittis mattis. Duis faucibus efficitur massa, ut aliquet nibh ultricies id. Aliquam erat volutpat. Ut ut posuere nisl. Etiam non diam nunc. Donec vitae vulputate dolor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac lorem eu dui sodales convallis. Ut et lacus rhoncus, dapibus tortor eget, efficitur nisl. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus sodales viverra purus ut elementum. Curabitur enim lorem, accumsan ut luctus eget, aliquam non dolor. Cras bibendum sem luctus, iaculis urna sit amet, varius orci. In fringilla nisi nec eros feugiat sollicitudin.\n" +
                                       "\n" +
                                       "Aliquam ut turpis nulla. Suspendisse scelerisque scelerisque libero. Fusce facilisis urna at facilisis vehicula. Etiam non rhoncus diam, et tempus augue. Vestibulum maximus ante dolor, sed accumsan sem aliquam eu. Morbi vel enim mi. Aenean commodo porta turpis, quis gravida lorem tempor non. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam tincidunt facilisis orci, vel malesuada nisl lacinia sed. Curabitur diam elit, condimentum ac lectus id, egestas condimentum nisi. Nam sed tortor nibh. Morbi ut arcu vel ante porta iaculis. Mauris a dolor justo.\n" +
                                       "\n" +
                                       "Cras ac ipsum dui. Praesent eget pretium lectus. Etiam massa leo, auctor vitae accumsan vel, lacinia non purus. Vivamus sed ex nec tortor fringilla gravida. In laoreet orci nec posuere molestie. Etiam at varius mi. Nunc tincidunt justo nec nunc blandit, sed varius felis consectetur. Nullam porta aliquet urna, sed porttitor augue porta vel. Maecenas ut ante quis justo egestas venenatis. Sed quis tempus magna, non feugiat dolor. Integer elementum enim sem, sed aliquet elit rhoncus id. Vivamus nec dolor aliquam, condimentum tortor vitae, finibus nibh. Integer vulputate rhoncus gravid"
                               ,"","tech")
      ))
    return NewsList
   }

