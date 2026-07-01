package com.xl.launcher.xy.mod

class DependencyScanner {
    fun scan(mods: List<String>): Map<String, List<String>> {
        // Simulate scanning mod dependencies
        return mapOf(
            "Mod1" to listOf("Forge", "LibLib"),
            "Mod2" to listOf("Fabric", "FabricAPI")
        )
    }
}
