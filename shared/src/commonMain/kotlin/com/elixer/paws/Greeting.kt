package com.elixer.paws

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}