package com.example.baseclasskotlin.ui.main

import android.content.Intent
import com.example.baseclasskotlin.R
import com.example.baseclasskotlin.ui.second.SecondActivity
import com.example.baseclasskotlin.base.BaseActivity
import com.example.baseclasskotlin.databinding.ActivityMainBinding
import com.example.baseclasskotlin.ext.showToast

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    MainAdapter.SelectListener {
    private lateinit var adapter: MainAdapter
    private var list: ArrayList<Int> = arrayListOf()
    private var selectedList: ArrayList<Int> = arrayListOf()

    override fun initListener() {
        binding.btnForward.setOnClickListener {
            if (selectedList.isNullOrEmpty()) {
                showToast(getString(R.string.emptyList))

            } else {
                resetSelected()
                openActivity()
                selectedList.clear()
            }
        }
    }

    private fun openActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putIntegerArrayListExtra(getString(R.string.selectKey), selectedList)
        startActivity(intent)
    }

    private fun resetSelected() {
        for (i in 0..list.lastIndex) {
            adapter.notifyItemChanged(i)
        }
    }

    override fun initView() {
        adapter = MainAdapter(this)
        binding.rvImage.adapter = adapter
        adapter.setImgList(list)
        initList()
    }

    private fun initList() {
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
        list.add(R.drawable.img_2)
        list.add(R.drawable.img_3)
        list.add(R.drawable.img_1)
    }

    override fun select(selectImg: Int) {
        selectedList.add(selectImg)
    }
}