package com.rajesh.expensestrackerwithai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform