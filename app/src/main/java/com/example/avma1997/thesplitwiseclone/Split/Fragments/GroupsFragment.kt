package com.example.avma1997.thesplitwiseclone

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
/**
 * Created by Avma1997 on 10/21/2017.
 */
class GroupsFragment: Fragment() {
var mRecyclerView: RecyclerView?=null
var mAdapter:GroupsRecyclerAdapter?=null
var decoration: DividerItemDecoration?=null
var mListener : GroupsRecyclerAdapter.GroupsClickListener?=null
var groups:ArrayList<Group>?=null

override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val v = inflater!!.inflate(R.layout.fragment_groups, container, false)

    var headerImageView=v.findViewById<View>(R.id.groups_balances_image) as ImageView
    var headerTextView=v.findViewById<View>(R.id.groups_balances_text) as TextView
    var headerButton=v.findViewById<View>(R.id.groups_balances_button) as ImageButton
    var addGroupsButton=v.findViewById<View>(R.id.groups_add_friends) as Button
    mRecyclerView = v.findViewById<View>(R.id.groups_recycler_view) as RecyclerView
    mAdapter = FriendsRecyclerAdapter(context,groups, object : GroupsRecyclerAdapter.GroupsClickListener() {
        override fun onItemClick(view: View, position: Int) {
            if (mListener != null) {
                mListener.onListItemClicked(groups.get(position))
            }
        }


    })


    mRecyclerView!!.setAdapter(mAdapter)


    mRecyclerView!!.setLayoutManager(LinearLayoutManager(context))
    decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
    mRecyclerView!!.addItemDecoration(decoration)

    mRecyclerView!!.setItemAnimator(DefaultItemAnimator())
    addGroupsButton.setOnClickListener(object: View.OnClickListener{
        override fun onClick(p0: View?) {

            val intent= Intent(activity,AddGroupsActivity::class.java)
            startActivity(intent)

        }


    })

    return v
}


}


