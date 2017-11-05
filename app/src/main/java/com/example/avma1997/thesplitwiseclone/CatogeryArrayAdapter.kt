package com.example.avma1997.thesplitwiseclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.ArrayList
import android.widget.ImageView
/**
 * Created by Avma1997 on 11/2/2017.
 */


/**
 * Created by Avma1997 on 7/9/2017.
 */

  class CatogeryArrayAdapter(internal var context: Context, internal var catogerylist: ArrayList<Catogery>) : ArrayAdapter<Catogery>(context, 0) {
    override fun getCount(): Int {
        return catogerylist.size
    }

    internal class CatogeryViewHolder( var name: TextView, var image:ImageView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null)


            var name = convertView!!.findViewById(R.id.catogery_title_list_item) as TextView
            var image = convertView!!.findViewById(R.id.catogery_image_list_item) as ImageView

            val stocksViewHolder = CatogeryViewHolder(name, image)
            convertView.tag = stocksViewHolder

        }
        val s = catogerylist[position]

        val catogeryViewHolder = convertView.tag as CatogeryViewHolder

        catogeryViewHolder.name.setText(s.name)
        // Picasso wali line
        return convertView
    }


}
