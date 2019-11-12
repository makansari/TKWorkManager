package workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FirstWorker (ctx : Context, params : WorkerParameters) : Worker (ctx,params) {

    override fun doWork(): Result {

        try {
            Log.i("mytag", "job is started")
            Thread.sleep(10000)
            Log.i("mytag", "job is done")
            return Result.success()
        }catch (throwable : Throwable){

            return  Result.failure()
        }
    }
}