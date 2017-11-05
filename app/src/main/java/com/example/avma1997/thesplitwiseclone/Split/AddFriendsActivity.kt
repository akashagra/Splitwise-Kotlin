package com.example.avma1997.thesplitwiseclone

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.provider.ContactsContract;
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import java.io.Serializable
import java.util.ArrayList

class AddFriendsActivity : AppCompatActivity() {
    var mRecyclerView: RecyclerView?=null
    var mAdapter:ContactsRecyclerAdapter?=null
    var decoration: DividerItemDecoration?=null
     var users: ArrayList<User>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friends)
        val contentResolver = contentResolver
        users= ArrayList()
        var cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null)
        if(cursor.count>0)
        {
            while(cursor.moveToNext())
            {

                var id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                var name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                var hasPhoneNumber=Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))
                if(hasPhoneNumber>0)
                {
                    var cursor2=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", arrayOf(id),null)
                    var phoneNumber=cursor2.getString(cursor2.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                    var user=User(null,name,null,null,null,"settled up",null,phoneNumber,null,null,null);
                    users!!.add(user)

                }
            }
        }
        mRecyclerView = findViewById<View>(R.id.friends_recycler_view) as RecyclerView
        mAdapter = ContactsRecyclerAdapter(this, users!!, object : ContactsRecyclerAdapter.ContactsClickListener {
            override fun onItemClick(view: View, position: Int) {

                 var selecteduser=users!!.get(position);
                val i = Intent()
                i.putExtra("added_friend", selecteduser as Serializable)
                setResult(Activity.RESULT_OK, i)
                finish()


            }
//            override fun onItemClick(view: View, position: Int) {
//                if (mListener != null) {
//                    mListener.onListItemClicked(phoneUsers!!.get(position))
//                }
//            }


        })


        mRecyclerView!!.setAdapter(mAdapter)


        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))
        decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mRecyclerView!!.addItemDecoration(decoration)

        mRecyclerView!!.setItemAnimator(DefaultItemAnimator())








    }
}
