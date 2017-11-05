package com.example.avma1997.thesplitwiseclone

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Avma1997 on 10/21/2017.
 */
class FriendsRecyclerAdapter(private val mContext: Context, private val mUsers: ArrayList<User>?, private val mListener: FriendsClickListener) : RecyclerView.Adapter<FriendsRecyclerAdapter.FriendsViewHolder>() {

    interface FriendsClickListener {
        fun onItemClick(view: View, position: Int)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_friends, parent, false)
        return FriendsViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        val user = mUsers!![position]


       // holder.nameTextView.text=
        //holder.balanceTextView.text =

       // Picasso.with(mContext).load("http://image.tmdb.org/t/p/w342" + movie.poster_path).into(holder.posterImageView)


    }

    override fun getItemCount(): Int {
        if (mUsers != null) {
            return mUsers.size
        }
        return 0;
    }

    class FriendsViewHolder(itemView: View, internal var mMoviesClickListener: FriendsClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var nameTextView: TextView
        internal var balanceTextView: TextView

        internal var posterImageView: ImageView

        init {
            itemView.setOnClickListener(this)
            nameTextView = itemView.findViewById<View>(R.id.name_text) as TextView
            balanceTextView = itemView.findViewById<View>(R.id.balance_text) as TextView
            posterImageView = itemView.findViewById<View>(R.id.poster_image) as ImageView

        }

        override fun onClick(view: View) {
            val id = view.id
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (id == R.id.friends_layout) {
                    mMoviesClickListener.onItemClick(view, position)
                }


            }

        }
    }


}
