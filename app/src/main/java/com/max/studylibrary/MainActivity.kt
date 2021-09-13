package com.max.studylibrary

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.max.studylibrary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = getSerial()

        binding.textView.text = getPackages()

    }
    /**
     * A native method that is implemented by the 'studylibrary' native library,
     * which is packaged with this application.
     */
    external fun getSerial():String
    external fun getPackages():String


    companion object {
        // Used to load the 'studylibrary' library on application startup.
        init {
            System.loadLibrary("studylibrary")
        }
    }

    }



    

