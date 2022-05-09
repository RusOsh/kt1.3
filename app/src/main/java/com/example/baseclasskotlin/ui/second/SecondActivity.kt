package com.example.baseclasskotlin.ui.second

import com.example.baseclasskotlin.R
import com.example.baseclasskotlin.base.BaseActivity
import com.example.baseclasskotlin.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    private var selectedList: ArrayList<Int> = arrayListOf()
    private lateinit var adapter: SecondAdapter

    override fun initView() {
        adapter = SecondAdapter()
        binding.rvSelectedImg.adapter = adapter
        getImage()
    }

    private fun getImage() {
        selectedList =
            (intent.getIntegerArrayListExtra(getString(R.string.selectKey)) as ArrayList<Int>)
        adapter.setSelectList(selectedList)
    }
}