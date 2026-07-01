package com.xl.launcher.xy.profile

import com.google.gson.Gson
import java.io.File

/**
 * Local database repository using clean abstractions for persistence
 */
class ProfileRepository(private val dataDir: File) {
    private val gson = Gson()

    fun saveProfile(profile: Profile): Boolean {
        return try {
            val json = gson.toJson(profile)
            val file = File(dataDir, "${profile.name}.json")
            file.writeText(json)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun loadProfile(name: String): Profile? {
        return try {
            val file = File(dataDir, "$name.json")
            if (file.exists()) {
                gson.fromJson(file.readText(), Profile::class.java)
            } else null
        } catch (e: Exception) {
            null
        }
    }

    fun loadAllProfiles(): List<Profile> {
        return dataDir.listFiles()?.mapNotNull { file ->
            try {
                gson.fromJson(file.readText(), Profile::class.java)
            } catch (e: Exception) {
                null
            }
        } ?: emptyList()
    }
}
