package com.mayard.coroutinetest.util

import com.opencsv.bean.CsvToBeanBuilder
import java.io.FileReader

object CsvUtil {

    fun <T> readFile(fileName: String, clazz: Class<T>): List<T> {

        return CsvToBeanBuilder<T>(FileReader(fileName))
            .withType(clazz)
            .build()
            .parse()
    }
}