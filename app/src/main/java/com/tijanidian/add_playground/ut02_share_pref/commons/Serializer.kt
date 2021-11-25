package com.tijanidian.add_playground.ut02_share_pref.commons

interface Serializer<T> {
    fun toJson(model: T): String
    fun fromJson(json: String): T
}
