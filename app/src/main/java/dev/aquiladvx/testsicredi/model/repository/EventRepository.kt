package dev.aquiladvx.testsicredi.model.repository

import dev.aquiladvx.testsicredi.model.entity.EventsListResponse
import dev.aquiladvx.testsicredi.model.service.EventAPI
import dev.aquiladvx.testsicredi.model.service.RemoteEventDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EventRepository {

    private val remote = RemoteEventDataSource()

    suspend fun getEventsList() = flow { emit(remote.getEvents()) }.flowOn(Dispatchers.IO)

}