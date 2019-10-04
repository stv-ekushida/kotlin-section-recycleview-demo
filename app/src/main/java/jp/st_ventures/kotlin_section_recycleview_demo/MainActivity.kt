package jp.st_ventures.kotlin_section_recycleview_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

enum class ListItem(val title: String) {
    ListHeader1("Section1"),
    ListRow1("row1-1"),
    ListRow2("row1-2"),
    ListHeader2("Section2"),
    ListRow3("row2-1"),
    ListRow4("row2-2"),
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        recycleView_main.setHasFixedSize(true)
        recycleView_main.layoutManager = LinearLayoutManager(this)
        recycleView_main.adapter = ItemsAdapter(this)
    }
}
