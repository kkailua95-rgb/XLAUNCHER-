package com.xl.launcher.xy.ai.components

class ModAdvisor {
    private val modDatabase = mapOf(
        "adventure" to listOf("BetterDungeons", "Twilight Forest", "The Aether"),
        "performance" to listOf("Sodium", "Lithium", "Phosphor"),
        "building" to listOf("Chisels & Bits", "MrCrayfishs Furniture", "Bibliocraft"),
        "magic" to listOf("Baubles", "Thaumcraft", "Blood Magic")
    )

    fun recommend(playstyle: String, metrics: Map<String, Float>): List<String> {
        val baseMods = modDatabase[playstyle.lowercase()] ?: emptyList()
        return baseMods.filter { isCompatibleWithMetrics(it, metrics) }
    }

    private fun isCompatibleWithMetrics(modName: String, metrics: Map<String, Float>): Boolean {
        val stability = metrics["stability"] ?: 0.5f
        return stability > 0.3f
    }
}
