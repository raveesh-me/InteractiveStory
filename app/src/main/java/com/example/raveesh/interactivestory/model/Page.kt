package com.example.raveesh.interactivestory.model

data class Page(val imageId:Int,
                val textId:Int,
                val choice1:Choice = Choice(-1,-1),
                val choice2:Choice = Choice(-1,-1),
                val isFinalPage: Boolean = false)