package com.limrun.samplekotlinmultiplatformapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform