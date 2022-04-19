package io.github.edsuns.star

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.tencent.bugly.crashreport.CrashReport

/**
 * Created by Edsuns@qq.com on 2021/6/27.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        CrashReport.initCrashReport(this, "ce159ef1e2", false)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        @JvmStatic
        lateinit var instance: App
    }
}
