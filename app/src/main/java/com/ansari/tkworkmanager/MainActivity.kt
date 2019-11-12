package com.ansari.tkworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import workers.FirstWorker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(View.OnClickListener {

            val workManager = WorkManager.getInstance()
            var firstWorkReq= OneTimeWorkRequest.Builder(FirstWorker::class.java).build()
            workManager.enqueue(firstWorkReq)

            workManager.getWorkInfoByIdLiveData(firstWorkReq.id).observe(this, Observer {
                 var workInfoStatus = it.state
                Toast.makeText(this, "status is " + workInfoStatus,Toast.LENGTH_SHORT).show()
            })
        })
    }
}
