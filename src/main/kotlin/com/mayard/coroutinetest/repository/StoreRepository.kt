package com.mayard.coroutinetest.repository

import com.mayard.coroutinetest.model.Store
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository: CoroutineCrudRepository<Store, Long> {
}