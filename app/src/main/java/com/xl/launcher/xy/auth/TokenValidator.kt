package com.xl.launcher.xy.auth

class TokenValidator {
    fun validateToken(token: String): Boolean {
        return token.isNotEmpty() && token.startsWith("mock_token")
    }

    fun isTokenExpired(token: String): Boolean {
        // Mock implementation
        return false
    }
}
