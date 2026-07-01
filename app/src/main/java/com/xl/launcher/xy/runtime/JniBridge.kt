package com.xl.launcher.xy.runtime

/**
 * JNI Interface for native Minecraft hooks
 * Provides bridge between Java runtime and native game code
 */
class JniBridge {
    companion object {
        init {
            try {
                System.loadLibrary("minecraft_bridge")
            } catch (e: UnsatisfiedLinkError) {
                // Handle cases where native library is not available
            }
        }
    }

    external fun initializeGameRuntime(): Int
    external fun attachNativeGameThread(): Boolean
    external fun redirectOpenGLCalls(): Boolean
    external fun setupInputMapping(keyMap: IntArray): Boolean
    external fun startGameLoop(): Boolean
    external fun stopGameLoop(): Boolean
}
