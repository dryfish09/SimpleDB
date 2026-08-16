package com.lpteam.ezLog

fun logInfo(msg: String) {
    println("[INFO]: ${msg}")
}
fun logError(msg: String) {
    println("[ERROR]: ${msg}")
}
fun logNotice(msg: String) {
    println("[NOTICE]: ${msg}")
}
fun logWarn(msg: String) {
    println("[WARN]: ${msg}")
}
fun logDebug(msg: String) {
    println("[DEBUG]: ${msg}")
}
fun customPrefixLog(customPrefix: String, msg: String) {
    println("[${customPrefix}]: ${msg}")
}
