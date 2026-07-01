package com.xl.launcher.xy.performance

/**
 * Manages cache layouts for asset rendering and metadata indexing
 */
class SmartCacheRepository {
    private val assetCache = mutableMapOf<String, ByteArray>()
    private val metadataCache = mutableMapOf<String, String>()
    private val cacheSize = 500 * 1024 * 1024 // 500MB

    fun cacheAsset(name: String, data: ByteArray): Boolean {
        return if (canCacheData(data.size)) {
            assetCache[name] = data
            true
        } else false
    }

    fun cacheMetadata(key: String, value: String) {
        metadataCache[key] = value
    }

    private fun canCacheData(size: Int): Boolean {
        return getTotalCacheSize() + size < cacheSize
    }

    private fun getTotalCacheSize(): Long {
        return assetCache.values.sumOf { it.size.toLong() }
    }
}
