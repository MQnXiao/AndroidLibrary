package com.mq.lib.mvp

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.mq.core.BaseActivity
import com.mq.lib.mvp.lifecycle.MVPLifecycleOwner
import com.mq.lib.mvp.lifecycle.MVPLifecycleRegistry

abstract class BaseMVPActivity<VB : ViewBinding> : BaseActivity<VB>(), MVPLifecycleOwner, IBaseView {
    private var mvpViewLifecycle: MVPLifecycleRegistry? = null

    private fun initialize() {
        if (mvpViewLifecycle == null) {
            mvpViewLifecycle = MVPLifecycleRegistry(this)
        }
    }

    override fun getViewLifecycle(): MVPLifecycleRegistry {
        initialize()
        return mvpViewLifecycle!!

    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        getViewLifecycle().onCreate()
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        getViewLifecycle().onDestroy()
        super.onDestroy()
    }
}