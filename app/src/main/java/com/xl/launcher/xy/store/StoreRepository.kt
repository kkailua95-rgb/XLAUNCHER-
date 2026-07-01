package com.xl.launcher.xy.store

class StoreRepository {
    fun fetchAllItems(): List<StoreItem> {
        return listOf(
            StoreItem("1", "Sodium", "Performance mod", 500000, 4.8f),
            StoreItem("2", "Lithium", "Performance enhancement", 300000, 4.7f),
            StoreItem("3", "Fabric API", "Mod loader", 1000000, 4.9f)
        )
    }
}
