package com.example.androidstudy.listener

import android.view.View

class SingleClickListener(private val onSingleClick: (View) ->Unit) :View.OnClickListener {

    companion object {
        const val CLICK_INTERVAL = 2000
    }

    private var lastCLickTime: Long = 0L

    private fun isSafe() : Boolean {
        return System.currentTimeMillis() - lastCLickTime > CLICK_INTERVAL
    }

    override fun onClick(v: View?) {
        if (isSafe() && v!= null) {
            onSingleClick(v)
        }
        lastCLickTime = System.currentTimeMillis()
    }
}