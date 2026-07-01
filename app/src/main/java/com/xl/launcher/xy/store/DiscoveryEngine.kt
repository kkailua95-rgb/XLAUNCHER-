package com.xl.launcher.xy.store

class DiscoveryEngine {
    fun rankItems(items: List<StoreItem>): List<StoreItem> {
        return items.sortedWith(compareBy({ -it.downloads }, { -it.rating }))
    }
}
