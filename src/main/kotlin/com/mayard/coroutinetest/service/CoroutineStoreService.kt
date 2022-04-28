package com.mayard.coroutinetest.service

import com.mayard.coroutinetest.model.Store
import com.mayard.coroutinetest.repository.StoreRepository
import com.mayard.coroutinetest.util.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class CoroutineStoreService(
    private val storeRepository: StoreRepository,
) {

    suspend fun saveByChunkedList(list: List<Store>, chunkSize: Int) = withContext(Dispatchers.Default) {

        list.chunked(chunkSize).forEach { chunkedList ->
            launch {
                storeRepository.saveAll(chunkedList).collect()
//                chunkedList.forEach { store ->
//                    storeRepository.save(store)
//                }
            }
        }
    }
}