package com.erolaksoy.kotlinworkmanagerexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySendingNumber = Data.Builder().putInt("myInt",5).build()

        var constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresCharging(false).build()

        val myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefreshDatabase>()
            .setConstraints(constraints)
            .setInputData(mySendingNumber)
            .addTag("deneme")
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
    }
}