package com.example.exampleroomcaching.data

import androidx.room.withTransaction
import com.example.exampleroomcaching.data.entity.Pizza
import com.example.exampleroomcaching.data.entity.PizzaResponse
import com.example.exampleroomcaching.data.local.PizzaDataBase
import com.example.exampleroomcaching.data.remote.PizzaService
import com.example.exampleroomcaching.utils.networkBoundResource
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: PizzaService,
    private val db: PizzaDataBase
){
    private val pizzaDao = db.getPizzaDao()

    fun getPizzas() = networkBoundResource(
        query = {
            pizzaDao.getAllPizza()
        },
        fetch = {
            delay(2000)
            api.getPizzaList()
        },
        saveFetchResult = {
            db.withTransaction {
                pizzaDao.deleteAllPizzas()
                pizzaDao.insertPizzas(mapResponseToList(it))
            }
        }

    )


    private fun mapResponseToList(entity: Response<PizzaResponse>): List<Pizza> {
       return entity.body()!!.pizza
    }


}