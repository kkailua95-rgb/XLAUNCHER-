package com.xl.launcher.xy.profile

/**
 * Saves, switches, and validates custom user profiles
 */
class ProfileManager {
    private val profiles = mutableMapOf<String, Profile>()
    private var activeProfile: String = ""

    fun createProfile(name: String, javaVersion: String, ramAllocation: Int): Boolean {
        return if (validateProfile(name, javaVersion, ramAllocation)) {
            profiles[name] = Profile(name, javaVersion, ramAllocation)
            true
        } else false
    }

    fun switchProfile(name: String): Boolean {
        return if (profiles.containsKey(name)) {
            activeProfile = name
            true
        } else false
    }

    fun getActiveProfile(): Profile? = profiles[activeProfile]

    private fun validateProfile(name: String, javaVersion: String, ram: Int): Boolean {
        return name.isNotEmpty() && javaVersion.isNotEmpty() && ram in 1..8
    }
}

data class Profile(
    val name: String,
    val javaVersion: String,
    val ramAllocation: Int,
    val mods: List<String> = emptyList(),
    val createdAt: Long = System.currentTimeMillis()
)
