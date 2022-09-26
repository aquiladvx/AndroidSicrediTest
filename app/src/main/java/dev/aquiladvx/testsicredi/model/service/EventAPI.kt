package dev.aquiladvx.testsicredi.model.service

import dev.aquiladvx.testsicredi.BASE_EVENT_API
import dev.aquiladvx.testsicredi.model.entity.Event
import dev.aquiladvx.testsicredi.model.entity.EventsListResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventAPI {

    @GET("events")
    suspend fun getEvents(): Response<EventsListResponse>

    @GET("events/{eventId}")
    suspend fun getEventDetail(@Path("eventId") id: Int): Response<Event>

    @POST("checkin")
    suspend fun registerCheckIn(@Body checkIn: Int): String

    companion object {
        fun create(): EventAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_EVENT_API)
                .build()
            return retrofit.create(EventAPI::class.java)

        }
    }
}