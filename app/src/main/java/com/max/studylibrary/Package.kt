package com.max.studylibrary

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager.GET_META_DATA
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Package : AppCompatActivity() {
   // lateinit var name:String
    var size : Int? = null
    var isSystem: Boolean = false
    lateinit var name : List<ApplicationInfo>
    //Функция для получения имён пакетов,их размера и являются ли пакеты системными.
    fun getPackages(): List<ApplicationInfo> {

        val button2:Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            name = packageManager.getInstalledApplications(GET_META_DATA)
            for (names in name){
                val textView:TextView = findViewById(R.id.textView)
                textView.text =names.packageName

            }

        }
        return name
    }
}