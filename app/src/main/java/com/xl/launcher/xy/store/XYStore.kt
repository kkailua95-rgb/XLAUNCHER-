package com.xl.launcher.xy.store

/**
 * Central store controller matching Material Design 3 guidelines
 */
class XYStore {
    private val storeRepository = StoreRepository()
    private val discoveryEngine = DiscoveryEngine()

    fun getTrendingItems(): List<StoreItem> {
        return discoveryEngine.rankItems(storeRepository.fetchAllItems())
    }

    fun searchItems(query: String): List<StoreItem> {
        return storeRepository.fetchAllItems().filter {
            it.name.contains(query, ignoreCase = true) ||
            it.description.contains(query, ignoreCase = true)
        }
    }
}

data class StoreItem(
    val id: String,
    val name: String,
    val description: String,
    val downloads: Int,
    val rating: Float
)
