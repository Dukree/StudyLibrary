package com.max.studylibrary


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class SerialNumber : AppCompatActivity() {
    private val requestState = 100
    private var checkedPermission = PackageManager.PERMISSION_DENIED
    // Функция для получения серийного номера устройства
    fun getSerial():String {
        //Проверка разрешений пользователя
        checkedPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_PHONE_STATE
        )
        if (Build.VERSION.SDK_INT >= 22 && checkedPermission !=
            PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
        } else
            checkedPermission = PackageManager.PERMISSION_GRANTED;

        val button:Button = findViewById(R.id.button)
        button.setOnClickListener {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val textView:TextView = findViewById(R.id.sample_text)
                    // Вывод результата на экран
                    textView.text = Build.getSerial()
                }
            }

return getSerial()
    }

    // Запрос разрешений
    private fun requestPermission() {
        Toast.makeText(this, "Requesting permission", Toast.LENGTH_SHORT).show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE), requestState)
        }
    }

    //Результат запроса разрешений
   override fun onRequestPermissionsResult(
        requestCode: Int,
        vararg permissions: String?,
        grantResults: IntArray
    ) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults)
       when (requestCode) {
            requestState -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager
                    .PERMISSION_GRANTED
            ) {
                checkedPermission = PackageManager.PERMISSION_GRANTED
            }
        }
    }
}