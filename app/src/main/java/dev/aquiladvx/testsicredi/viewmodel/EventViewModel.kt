package dev.aquiladvx.testsicredi.viewmodel

import androidx.lifecycle.*
import dev.aquiladvx.testsicredi.common.Resource
import dev.aquiladvx.testsicredi.model.entity.Event
import dev.aquiladvx.testsicredi.model.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(private val repository: EventRepository): ViewModel() {

    private val _events = MutableLiveData<Resource<List<Event>>>()
    val events: LiveData<Resource<List<Event>>> get() = _events

    fun getEventsList() {
        viewModelScope.launch {
            _events.value = Resource.Loading()

            repository.getEventsList().collect { response ->
                if (response != null) {
                    _events.value = Resource.Success(response)
                } else {
                    //TODO: Throw exception
                }
            }
        }
    }

    class EventViewModelFactory(private val dataSource: EventRepository) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>) = EventViewModel(dataSource) as T
    }

}