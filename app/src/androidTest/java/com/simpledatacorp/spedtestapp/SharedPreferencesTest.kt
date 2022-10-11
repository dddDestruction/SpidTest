package com.simpledatacorp.spedtestapp

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.simpledatacorp.spedtestapp.model.sharedPreferences.SharedPrefenrecesManager
import org.junit.Before
import org.junit.Test

class SharedPreferencesTest {

    private lateinit var sharedPrefenrecesManager : SharedPrefenrecesManager
    val context = ApplicationProvider.getApplicationContext<Context>()


    @Before
    fun createObject() {
        sharedPrefenrecesManager = SharedPrefenrecesManager(context)
    }

    @Test
    fun saveSelectionAndGetTest() {
        //Se intenta guardar y obtener un valor de id
        val dummyId = "tt1649418"
        sharedPrefenrecesManager.saveSelection(dummyId)
        val resId = sharedPrefenrecesManager.getIdSelected()
        assert(resId == dummyId)
    }
}