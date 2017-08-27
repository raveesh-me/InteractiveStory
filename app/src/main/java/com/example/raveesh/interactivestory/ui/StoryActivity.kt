package com.example.raveesh.interactivestory.ui

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.raveesh.interactivestory.R
import com.example.raveesh.interactivestory.model.Page
import com.example.raveesh.interactivestory.model.Story
import kotlinx.android.synthetic.main.activity_story.*
import java.util.*

class StoryActivity : AppCompatActivity() {
//    val TAG = "StoryActivity1"

    private lateinit var story:Story
    private lateinit var name:String
    private lateinit var pageStack: Stack<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        pageStack = Stack()
        story = Story()
        name = intent.extras.getString(R.string.key_name.toString())
        loadPage(0)
    }

    private fun loadPage(pageNumber: Int) {
        pageStack.push(pageNumber)
//        Log.i(TAG, pageStack.toString())
        val page:Page = story.pages[pageNumber]
        // draw image
        storyImageView.setImageDrawable(
                ContextCompat.getDrawable(this, page.imageId))
        val pageText = getString(page.textId)
        //add name if placeholder exists
        storyTextView.text = String.format(pageText,name)

        if (page.isFinalPage){
            choice1Button.visibility = View.INVISIBLE
            choice2Button.text = getString(R.string.play_again_buttontext)
            choice2Button.setOnClickListener({
                loadPage(0)
            })

        } else loadButtons(page)

    }

    private fun loadButtons(page: Page) {
        choice1Button.visibility = View.VISIBLE
        choice2Button.visibility = View.VISIBLE

        choice1Button.setText(page.choice1.textId)
        choice1Button.setOnClickListener {
            loadPage(page.choice1.nextPage)
        }

        choice2Button.setText(page.choice2.textId)
        choice2Button.setOnClickListener({
            loadPage(page.choice2.nextPage)
        })

        //re-initialising our backstack on 0th state/adventure begin
        if (pageStack.peek()==0) {
            pageStack = Stack()
            pageStack.push(0)
        }
    }

    override fun onBackPressed() {
        if (pageStack.peek() == 0) {
            super.onBackPressed()
        }
        else{
            pageStack.pop()
            loadPage(pageStack.pop()!!)
        }
    }

}
