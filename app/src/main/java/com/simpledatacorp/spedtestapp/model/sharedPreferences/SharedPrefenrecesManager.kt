package com.simpledatacorp.spedtestapp.model.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
class SharedPrefenrecesManager(context: Context):ISharedPreferencesManager {

    private val sharedPref: SharedPreferences = context.getSharedPreferences("this", Context.MODE_PRIVATE)
    private val ID_LABEL = "id"

    override fun saveSelection(idSelected: String) {
        val editor =  sharedPref.edit()
        editor.putString(ID_LABEL, idSelected).apply()
    }

    override fun getIdSelected(): String {
        return sharedPref.getString(ID_LABEL, "")!!
    }
}