package com.khevna.kpizza


import android.support.v4.view.AccessibilityDelegateCompat
import android.support.v4.view.ViewCompat
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
import android.view.View
import android.view.accessibility.AccessibilityEvent

class AccessibilityViewConfig (private val view: View) {
    var isButton = false
    var action = ""

    fun setViewToButton(): AccessibilityViewConfig {
        isButton = true
        return this
    }

    fun setCustomAction(action: String): AccessibilityViewConfig {
        this.action = action
        return this
    }

    fun setCustomAction(actionId: Int): AccessibilityViewConfig {
        this.action = view.resources.getString(actionId)
        return this
    }

    fun apply() {
        ViewCompat.setAccessibilityDelegate(view, object : AccessibilityDelegateCompat() {

            override fun onInitializeAccessibilityEvent(host: View, event: AccessibilityEvent) {
                super.onInitializeAccessibilityEvent(host, event)
            }

            override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                if (isButton) {
                    info.extras.putBoolean(host.resources.getString(R.string.talkback_button_check), true)
                }
                if (action.isNotEmpty()) {
                    info.extras.putString(host.resources.getString(R.string.talkback_custom_action), action)
                }
            }
        })
    }
}
