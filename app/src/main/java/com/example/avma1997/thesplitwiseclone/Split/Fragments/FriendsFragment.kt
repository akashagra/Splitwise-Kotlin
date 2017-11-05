package com.example.avma1997.thesplitwiseclone

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.ImageButton
import android.widget.Button
/**
 * Created by Avma1997 on 10/21/2017.
 */
class FriendsFragment: Fragment() {
    var mRecyclerView:RecyclerView?=null
    var mAdapter:FriendsRecyclerAdapter?=null
    var decoration: DividerItemDecoration?=null
    var mListener : FriendsRecyclerAdapter.FriendsClickListener?=null
    var friends: ArrayList<User>?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_friends, container, false)

        var headerImageView=v.findViewById<View>(R.id.friends_balances_image) as ImageView
        var headerTextView=v.findViewById<View>(R.id.friends_balances_text) as TextView
        var headerButton=v.findViewById<View>(R.id.friends_balances_button) as ImageButton
        var addFriendsButton=v.findViewById<View>(R.id.add_button) as Button
        friends= ArrayList()
        mRecyclerView = v.findViewById<View>(R.id.friends_recycler_view) as RecyclerView
        mAdapter = FriendsRecyclerAdapter(context,friends, object : FriendsRecyclerAdapter.FriendsClickListener {
            override fun onItemClick(view: View, position: Int) {

            }


        })


        mRecyclerView!!.setAdapter(mAdapter)


        mRecyclerView!!.setLayoutManager(LinearLayoutManager(context))
        decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        mRecyclerView!!.addItemDecoration(decoration)

        mRecyclerView!!.setItemAnimator(DefaultItemAnimator())
        addFriendsButton.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {

                val intent= Intent(getActivity(),AddFriendsActivity::class.java)
                startActivityForResult(intent,1);

            }


        })

        return v
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
              //  priority = data.getIntExtra("priority", -1)
                //updateToDoList()
                var user=data.getSerializableExtra("added_friend")
                friends!!.add(user as User)
                mAdapter!!.notifyDataSetChanged()

                Log.i("MainActivityTag", "Result_Ok")
            } else if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }


}