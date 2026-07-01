package com.xl.launcher.xy.ai

import kotlinx.coroutines.*

/**
 * Asynchronous execution model for AI tasks
 */
class XYAITask {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun executeAsync(task: suspend () -> String, onComplete: (String) -> Unit) {
        scope.launch {
            val result = task()
            withContext(Dispatchers.Main) {
                onComplete(result)
            }
        }
    }

    fun cancel() {
        scope.cancel()
    }
}
