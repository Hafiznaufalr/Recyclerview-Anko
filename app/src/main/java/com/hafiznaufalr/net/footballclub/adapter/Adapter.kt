package com.hafiznaufalr.net.footballclub.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hafiznaufalr.net.footballclub.R
import com.hafiznaufalr.net.footballclub.model.Footballdc
import org.jetbrains.anko.*

class Adapter constructor(private val context: Context, private val football: ArrayList<Footballdc>, private val listenerAdapterFootballClub: ListenerAdapterFootballClub) : RecyclerView.Adapter<Adapter.ViewHolderItemFootballClub>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemFootballClub {
        return ViewHolderItemFootballClub(
                ItemFootballClubUI().createView(
                        AnkoContext.Companion.create(parent!!.context, parent)
                )
        )
    }

    override fun getItemCount(): Int = football.size

    override fun onBindViewHolder(holder: ViewHolderItemFootballClub, position: Int) {
        val football = football[position]
        holder.textViewNameFootballClub.text = football.name
        Glide.with(context)
                .load(football.image)
                .into(holder.imageViewFootballClub)
    }

    inner class ViewHolderItemFootballClub(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val relativeLayoutContainerItemFootballClub: RelativeLayout = itemView.find(R.id.relative_layout)
        val imageViewFootballClub: ImageView = itemView.find(R.id.image_view_item)
        val textViewNameFootballClub: TextView = itemView.find(R.id.text_view_item)

        init {
            relativeLayoutContainerItemFootballClub.setOnClickListener {
                listenerAdapterFootballClub.onClick(football = football[adapterPosition])
            }
        }

    }

    interface ListenerAdapterFootballClub {

        fun onClick(football: Footballdc)

    }

}

class ItemFootballClubUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            imageView {
                id = R.id.image_view_item
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.img_acm))
            }.lparams(width = 96, height = 150) {
                rightMargin = dip(8)
            }

            textView {
                id = R.id.text_view_item
                text = "Club name"
            }.lparams {
                width = wrapContent
                height = wrapContent
                centerVertically()
                rightOf(R.id.image_view_item)
            }

            id = R.id.relative_layout
            lparams(width = matchParent, height = wrapContent) {
                topPadding = dip(8)
                rightPadding = dip(16)
                bottomPadding = dip(8)
                leftPadding = dip(16)
            }
        }
    }
}