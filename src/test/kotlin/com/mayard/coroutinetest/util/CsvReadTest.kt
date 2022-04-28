package com.mayard.coroutinetest.util

import com.mayard.coroutinetest.CoroutineTestApplication
import com.mayard.coroutinetest.model.Store
import com.mayard.coroutinetest.repository.StoreRepository
import com.mayard.coroutinetest.service.CoroutineStoreService
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [CoroutineTestApplication::class])
class CsvReadTest(
    private val storeRepository: StoreRepository,
    private val coroutineStoreService: CoroutineStoreService,

    @Value("\${file-name}")
    val fileName: String,
): StringSpec() {

    lateinit var list: List<Store>

    override fun timeout(): Long? {
        return 100000000L
    }

    override fun invocationTimeout(): Long? {
        return 1000000000L
    }

    override fun beforeTest(testCase: TestCase) {
        list = CsvUtil.readFile(fileName, Store::class.java)
    }

    // Time: 20m 23.323604375s || Size: 497621
    init {
        "coroutine 한개로 store 정보 db 저장해보기" {
            val elapsedTime: Duration = measureTime {
                list.map { store ->
                    storeRepository.save(store)
                }
                storeRepository.count() shouldBeEqualComparingTo list.size.toLong()
            }
            logger.info("Time: $elapsedTime || Size: ${list.size}")
        }
    }

    // Time: 4m 35.355437584s || Size: 497621
    init {
        "chunkSize 1000으로 나눠서 저장해보기" {
            logger.info(fileName)
            val elapsedTime: Duration = measureTime {
                coroutineStoreService.saveByChunkedList(list, 1000)
                storeRepository.count() shouldBeEqualComparingTo list.size.toLong()
            }
            logger.info("Time: $elapsedTime || Size: ${list.size}")
        }
    }

    companion object {
        val logger by Logger()
    }
}