package com.simpledatacorp.spedtestapp

import com.simpledatacorp.spedtestapp.model.api.RetrofitClient
import org.junit.Test
import retrofit2.Retrofit

class RetrofitTest {

    @Test
    fun testRetrofitInstance() {
        //Se crea instancia de retrofit
        val instace: Retrofit = RetrofitClient().retrofit
        //Se compara url base de retrofit
        assert(instace.baseUrl().url().toString() == BuildConfig.BASE_URL)
    }

    @Test
    fun testCallService() {
        //GSe crea instancia de Api
        val service = RetrofitClient.retrofitInstance()

        //se ejecuta llamado a API
        val response = service.getMovies(BuildConfig.API_KEY).execute()
        //se revisa errores
        val errorBody = response.errorBody()
        assert(errorBody == null)
        //se revisa éxito de llamada
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(response.code() == 200)
    }

    @Test
    fun testSizeResponse() {
        //GSe crea instancia de Api
        val service = RetrofitClient.retrofitInstance()

        //se ejecuta llamado a API
        val response = service.getMovies(BuildConfig.API_KEY).execute()
        //se revisa errores
        val errorBody = response.errorBody()
        assert(errorBody == null)
        //se revisa éxito de llamada
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(responseWrapper!!.items.size >= 5)
    }
}