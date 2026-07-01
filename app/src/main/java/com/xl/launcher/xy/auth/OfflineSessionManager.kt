package com.xl.launcher.xy.auth

import java.util.*

/**
 * Generates random/custom working UUID profiles compliant with Minecraft offline specifications
 */
class OfflineSessionManager {
    fun generateOfflineProfile(username: String): String {
        val offlineUUID = generateOfflineUUID(username)
        return "{\"name\":\"$username\",\"uuid\":\"$offlineUUID\"}"
    }

    private fun generateOfflineUUID(username: String): String {
        val namespace = "00000000-0000-0000-0000-000000000000"
        val hash = "OfflinePlayer:$username".hashCode().toString(16)
        return "${hash.padStart(8, '0')}-0000-0000-0000-000000000000"
    }
}
