package com.example.raveesh.interactivestory.model

import com.example.raveesh.interactivestory.R


class Story(){
    val pages:Array<Page> = arrayOf(
            //[0]
            Page(R.drawable.page0,
                    R.string.page0,
                    Choice(R.string.page0_choice1,1),
                    Choice(R.string.page0_choice2,2)),
            //[1]
            Page(R.drawable.page1,
                    R.string.page1,
                    Choice(R.string.page1_choice1,3),
                    Choice(R.string.page1_choice2,4)),
            //[2]
            Page(R.drawable.page2,
                    R.string.page2,
                    Choice(R.string.page2_choice1,1),
                    Choice(R.string.page2_choice2,6)),
            //[3]
            Page(R.drawable.page3,
                    R.string.page3,
                    Choice(R.string.page3_choice1,4),
                    Choice(R.string.page3_choice2,5)),
            //[4]
            Page(R.drawable.page4,
                    R.string.page4,
                    Choice(R.string.page4_choice1,3),
                    Choice(R.string.page4_choice2,6)),
            //[5]
            Page(R.drawable.page5, R.string.page5, isFinalPage = true),
            //[6]
            Page(R.drawable.page6, R.string.page6, isFinalPage = true)
    )
}