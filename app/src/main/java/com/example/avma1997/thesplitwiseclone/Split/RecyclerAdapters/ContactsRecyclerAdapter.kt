package com.example.avma1997.thesplitwiseclone

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

/**
 * Created by Avma1997 on 10/23/2017.
 */
class ContactsRecyclerAdapter(private val mContext: Context, private val mPhoneUsers: ArrayList<User>, private val mListener: ContactsClickListener) : RecyclerView.Adapter<ContactsRecyclerAdapter.ContactsViewHolder>() {

    interface ContactsClickListener {
        fun onItemClick(view: View, position: Int)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_contacts, parent, false)
        return ContactsViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val user = mPhoneUsers[position]


         holder.nameTextView.text=user.name
        holder.phoneTextView.text =user.phoneNo

        // Picasso.with(mContext).load("http://image.tmdb.org/t/p/w342" + movie.poster_path).into(holder.posterImageView)


    }

    override fun getItemCount(): Int {
        return mPhoneUsers.size
    }

    class ContactsViewHolder(itemView: View, internal var mContactsClickListener: ContactsClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

         var nameTextView: TextView
         var phoneTextView: TextView



        init {
            itemView.setOnClickListener(this)
            nameTextView = itemView.findViewById<View>(R.id.contact_name_text) as TextView
            phoneTextView = itemView.findViewById<View>(R.id.contact_phone) as TextView


        }

        override fun onClick(view: View) {
            val id = view.id
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (id == R.id.contacts_layout) {
                    mContactsClickListener.onItemClick(view, position)
                }


            }

        }
    }


}
