package com.mayard.coroutinetest.service

import com.mayard.coroutinetest.model.Store
import com.mayard.coroutinetest.repository.StoreRepository
import com.mayard.coroutinetest.util.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class CoroutineStoreService(
    private val storeRepository: StoreRepository,
) {

    fun saveByChunkedList(list: List<Store>, chunkSize: Int) = runBlocking(Dispatchers.Default) {

        list.chunked(chunkSize).forEach { chunkedList ->
            launch {
                chunkedList.forEach { store ->
                    storeRepository.save(store)
                }
            }
        }
    }
}