package com.tijanidian.add_playground.ut02_share_pref.commons

import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import com.tijanidian.add_playground.ut02_share_pref.CustomerModel
import com.tijanidian.add_playground.ut02_share_pref.InvoiceModel
import java.lang.reflect.Type

class GsonSerializer<T> : Serializer<T> {

    private val gson = Gson()
    //Tenemos que ir poniendo manual mente los modelos de datos
    private val types: Type = TypeToken.getParameterized(
        CustomerModel::class.java,
        InvoiceModel::class.java,
    ).type

    override fun toJson(model: T): String =
        gson.toJson(model, types)

    override fun fromJson(json: String): T {
        return gson.fromJson(json, types)
    }
}