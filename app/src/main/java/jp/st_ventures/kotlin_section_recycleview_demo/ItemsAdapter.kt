package jp.st_ventures.kotlin_section_recycleview_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ItemsAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ListItem.values()

    enum class ListType(val rawValue: Int) {
        HEADER_TYPE(0),
        ITEM_TYPE(1)
    }

    override fun getItemViewType(position: Int): Int {

        val item = items.get(position)

        when(item) {
            ListItem.ListHeader1, ListItem.ListHeader2 -> return ListType.HEADER_TYPE.rawValue
            else -> return ListType.ITEM_TYPE.rawValue
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(context)

        when(viewType) {
            ListType.HEADER_TYPE.rawValue -> return ViewHolderItem(inflater.inflate(R.layout.list_section,
                parent,
                false))
            else -> return ViewHolderItem(inflater.inflate(R.layout.list_item,
                parent,
                false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val titleTextView = holder.itemView.textView_item_title
        titleTextView.text = items.get(position).title

        holder.itemView.setOnClickListener() {
            this.tapAction(items.get(position))
        }
    }

    private fun tapAction(item: ListItem) {
        println(item)
    }
}

class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {}