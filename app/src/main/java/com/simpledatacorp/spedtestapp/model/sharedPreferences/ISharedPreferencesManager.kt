package com.simpledatacorp.spedtestapp.model.sharedPreferences

interface ISharedPreferencesManager {
    //guarda la selección de usuario a través del id
    fun saveSelection(id:String)
    //Obtener id de la película seleccionada
    fun getIdSelected():String

}