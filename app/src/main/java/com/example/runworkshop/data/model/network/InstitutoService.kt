package com.example.runworkshop.data.model.network


import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.data.model.InstitutoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//Cuando el repositorio decide hacer el llamado por internet, lo hace a traves de esta clase service
//Si en un futuro decidimos cambiar firebase, o retrofit, o los endpoint etc, solo modificamos esta clase,
//porque esta clase es la dedicada a hacer la peticion  a internet
class InstitutoService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getInstituto(): List<InstitutoModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(InstitutoApiClient::class.java).getAllInstitutos()
            response.body() ?: emptyList()
        }

    }
}
