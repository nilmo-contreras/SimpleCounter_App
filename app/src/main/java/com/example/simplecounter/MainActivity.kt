package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            //Toast.makeText(it.context, "clicked the button!", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()

            if (counter >= 100) {

                // Show upgrade button and set onClickListener
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    // Update original button to add 2 instead of `
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }

                    // Hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}