package com.xl.launcher.xy.ai.components

class ModpackBuilder {
    fun build(description: String): String {
        return when {
            description.contains("combat", ignoreCase = true) -> generateCombatModpack()
            description.contains("building", ignoreCase = true) -> generateBuildingModpack()
            description.contains("exploration", ignoreCase = true) -> generateExplorationModpack()
            else -> generateDefaultModpack()
        }
    }

    private fun generateCombatModpack(): String {
        return "Combat Modpack: [Spartan Weapons, Better Combat, Battle Towers]"
    }

    private fun generateBuildingModpack(): String {
        return "Building Modpack: [Chisels & Bits, Bibliocraft, MrCrayfish Furniture]"
    }

    private fun generateExplorationModpack(): String {
        return "Exploration Modpack: [Twilight Forest, The Aether, Caves & Cliffs]"
    }

    private fun generateDefaultModpack(): String {
        return "Default Modpack: [Sodium, Lithium, Phosphor]"
    }
}
