package com.xl.launcher.xy.world

import java.io.File

/**
 * Discovers, lists, and modifies Minecraft world folders
 */
class WorldManager(private val minecraftDir: File) {
    fun discoverWorlds(): List<WorldInfo> {
        val savesDir = File(minecraftDir, "saves")
        return if (savesDir.exists()) {
            savesDir.listFiles()?.filter { it.isDirectory }?.map { worldDir ->
                WorldInfo(
                    name = worldDir.name,
                    path = worldDir.absolutePath,
                    size = calculateDirSize(worldDir)
                )
            } ?: emptyList()
        } else emptyList()
    }

    private fun calculateDirSize(dir: File): Long {
        return dir.walkTopDown().sumOf { it.length() }
    }
}

data class WorldInfo(
    val name: String,
    val path: String,
    val size: Long
)
