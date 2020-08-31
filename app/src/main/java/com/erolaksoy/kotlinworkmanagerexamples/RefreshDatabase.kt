package com.erolaksoy.kotlinworkmanagerexamples

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        val getData = inputData
        val myComingNumber = getData.getInt("myInt",0)
        refreshDatabase(myComingNumber)
        return Result.success()
    }

    private fun refreshDatabase(number : Int){
        val sharedPreferences = context.getSharedPreferences("package com.erolaksoy.kotlinworkmanagerexamples",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber+=number
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply()
    }
}