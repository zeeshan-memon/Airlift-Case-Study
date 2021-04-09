package com.example.airliftcasestudy.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.airliftcasestudy.R
import com.example.airliftcasestudy.data.model.OnClickHandlerInterface
import com.example.airliftcasestudy.data.model.response.Hits
import com.example.airliftcasestudy.databinding.HintsItemsBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * This is custom adapter for results.
 * @param response  - list of result.
 * @param context -   Application context for inflate custom row.
 * @param clickListener - click listener for each result of results.
 */
class GalleryAdapter(
    private val context: Context, var response: List<Hits>,
    private val clickListener: (View) -> Unit) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>(), OnClickHandlerInterface {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: HintsItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.hints_items,
            parent,
            false
        )
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = response.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.bind(response[position])
//            Picasso.get().load(response[position].image_urls_thumbnails).fit().centerCrop().into(holder.resultsBinding!!.itemImageView, object :
            Picasso.get().load(response[position].webformatURL).fit().centerCrop().into(holder.hitsItemsBinding!!.itemImageView, object :
                Callback {
                override fun onSuccess() {
                    Log.d("Picasso", "success")
                }

                override fun onError(e: Exception?) {
                    Log.d("Picasso", "error"+e?.printStackTrace())
                }
            })
            holder.hitsItemsBinding!!.clickHandler = this

        } catch (e: Exception) {
            println("DisputeAdapter exception: $e")
        }
    }

    /**
     * This is inner class for initiate views.
     * @param itemView  - custom view of results row.
     */
    inner class ViewHolder constructor(val binding: HintsItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var hitsItemsBinding: HintsItemsBinding? = binding
        fun bind(data: Any) {
            val variable = binding.setVariable(
                BR.hits,
                data
            ) //BR - generated class; BR.user - 'user' is variable name declared in layout
            binding.executePendingBindings()
        }
    }

    override fun onClick(t: View) {
    /*
    * On click image will be Large
    */
    }
}