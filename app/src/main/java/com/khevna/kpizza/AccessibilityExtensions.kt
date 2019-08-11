
@file:JvmName("AccessibilityUtils")

package com.khevna.kpizza

import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.ListView



fun View.setInitialFocus(): View {
    isFocusable = true
    postDelayed({
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
        requestFocus()
    }, 500)
    return this
}

fun View.setFocus(): View {
    isFocusable = true
    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
    requestFocus()
    return this
}

fun View.unFocus(): View {
    isFocusable = false
    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED)
    return this
}

fun View.configureViewAccessibility(): AccessibilityViewConfig {
    return AccessibilityViewConfig(this)
}


fun ListView.removeClickable() {
    isClickable = false
    isLongClickable = false
    isFocusable = false
}

