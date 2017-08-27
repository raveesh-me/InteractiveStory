package com.example.raveesh.interactivestory.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.raveesh.interactivestory.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            val name = nameEditText.text.toString()

            val intent = Intent(this, StoryActivity::class.java)
            intent.putExtra(R.string.key_name.toString(), name)
            startActivity(intent)

        }

    }

    override fun onResume() {
        super.onResume()
        nameEditText.setText("")
    }

}
