package dev.aquiladvx.testsicredi.model.service

import dev.aquiladvx.testsicredi.model.entity.EventsListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteEventDataSource {

    private val api = EventAPI.create()

    suspend fun getEvents(): EventsListResponse? {
        return withContext(Dispatchers.Default) {
            val response = api.getEvents()
            val processResponse = processData(response)
            processResponse
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}