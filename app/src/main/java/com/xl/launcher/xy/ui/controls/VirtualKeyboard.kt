package com.xl.launcher.xy.ui.controls

/**
 * Maps screen touch boundaries to PC keyboard scan codes
 */
class VirtualKeyboard {
    private val keyMap = mutableMapOf<String, Int>()

    init {
        // Initialize key mappings
        keyMap["W"] = 17 // W key code
        keyMap["A"] = 30 // A key code
        keyMap["S"] = 31 // S key code
        keyMap["D"] = 32 // D key code
        keyMap["SPACE"] = 57 // Space key code
        keyMap["SHIFT"] = 42 // Shift key code
    }

    fun mapTouchToKey(touchX: Float, touchY: Float): String? {
        // Map touch coordinates to keyboard keys
        return when {
            touchX < 0.2f && touchY > 0.7f -> "A"
            touchX in 0.2f..0.4f && touchY > 0.7f -> "W"
            touchX in 0.4f..0.6f && touchY > 0.7f -> "D"
            touchX in 0.6f..0.8f && touchY > 0.7f -> "S"
            touchY > 0.9f -> "SPACE"
            else -> null
        }
    }
}
