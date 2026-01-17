package org.example.project.share.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
