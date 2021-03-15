package com.Androidlk.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Androidlk.recyclerview.data.Datafruit
import com.chainiao5.recyclerview.adapter.CommonViewHolder
import com.chainiao5.recyclerview.adapter.RecyclerViewdapter

class MainActivity : AppCompatActivity() {
    private val typeTitle = 0
    private val typecontent = 1
    private val mList = ArrayList<Datafruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //拿去数据
        initData()
        var recfruit: RecyclerView = findViewById(R.id.recfruit)
        recfruit.layoutManager = LinearLayoutManager(this)
        //分割线
        recfruit.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recfruit.adapter = RecyclerViewdapter(
            mList,
            object : RecyclerViewdapter.OnBMoreindDataListener<Datafruit> {
                override fun onBindViewHolder(
                    model: Datafruit,
                    viewHolder: CommonViewHolder,
                    type: Int,
                    position: Int
                ) {
                    when (model.type) {
                        typeTitle -> viewHolder.setText(R.id.Titlefruit, model.titlt)
                        typecontent -> {

                            viewHolder.setText(R.id.contentfruit, model.titlt)
                            viewHolder.setImage(R.id.icofruit, model.ico)

                            viewHolder.itemView.setOnClickListener {

                            }
                        }
                    }


                }

                override fun getLayoutId(type: Int): Int {

                    return if (type == typeTitle) {
                        R.layout.fruit_title
                    } else
                        R.layout.fruit_content


                }

                override fun getItemViewType(position: Int): Int {
                    return mList[position].type
                }
            })


    }


    //  初始化数据
    private fun initData() {
        val Titlefruit = resources.getStringArray(R.array.Titlefruit)//标题
        val icofruit = resources.obtainTypedArray(R.array.icofruit)//图片

        for ((index, value) in Titlefruit.withIndex()) {
            if (value.contains("[")) {
                addData(
                    typeTitle,
                    value.replace("[", "").replace("]", ""),
                    icofruit.getResourceId(index, 0)
                )
            } else {
                addData(typecontent, value, icofruit.getResourceId(index, 0))
            }


        }
    }

    //添加数据
    private fun addData(type: Int, title: String, ico: Int) {

        mList.add(Datafruit(type, title, ico))

    }


}