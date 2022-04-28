package com.mayard.coroutinetest.model

import com.opencsv.bean.CsvBindByName
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "store")
class Store {

    @Id
    var id: Long? = null

    @CsvBindByName(column = "상가업소번호")
    val storeId: Long = 0

    @CsvBindByName(column = "상호명")
    val name: String? = null

    @CsvBindByName(column = "지점명")
    val franchise: String? = null

    @CsvBindByName(column = "상권업종대분류코드")
    val bigCategoryCode: String? = null

    @CsvBindByName(column = "상권업종대분류명")
    val bigCategoryName: String? = null

    @CsvBindByName(column = "상권업종중분류코드")
    val middleCategoryCode: String? = null

    @CsvBindByName(column = "상권업종중분류명")
    val middleCategoryName: String? = null

    @CsvBindByName(column = "상권업종소분류코드")
    val smallCategoryCode: String? = null

    @CsvBindByName(column = "상권업종소분류명")
    val smallCategoryName: String? = null

    @CsvBindByName(column = "표준산업분류코드")
    val standardCode: String? = null

    @CsvBindByName(column = "표준산업분류명")
    val standardName: String? = null

    @CsvBindByName(column = "시도코드")
    val cityCode: Int? = null

    @CsvBindByName(column = "시도명")
    val cityName: String? = null

    @CsvBindByName(column = "시군구코드")
    val cityDetailCode: Int? = null

    @CsvBindByName(column = "시군구명")
    val cityDetailName: String? = null

    @CsvBindByName(column = "행정동코드")
    val areaCode: Long? = null

    @CsvBindByName(column = "행정동명")
    val areaName: String? = null

    @CsvBindByName(column = "법정동코드")
    val lawAreaCode: Long? = null

    @CsvBindByName(column = "법정동명")
    val lawAreaName: String? = null

    @CsvBindByName(column = "지번코드")
    val addressCode: Long? = null

    @CsvBindByName(column = "대지구분코드")
    val landCode: Int? = null

    @CsvBindByName(column = "대지구분명")
    val landName: String? = null

    @CsvBindByName(column = "지번본번지")
    val landMainCode: Int? = null

    @CsvBindByName(column = "지번부번지")
    val landSubCode: String? = null

    @CsvBindByName(column = "지번주소")
    val address: String? = null

    @CsvBindByName(column = "도로명코드")
    val roadNameCode: Long? = null

    @CsvBindByName(column = "도로명")
    val roadName: String? = null

    @CsvBindByName(column = "건물본번지")
    val buildingMainCode: String? = null

    @CsvBindByName(column = "건물부번지")
    val buildingSubCode: String? = null

    @CsvBindByName(column = "건물관리번호")
    val buildingCode: String? = null

    @CsvBindByName(column = "건물명")
    val buildingName: String? = null

    @CsvBindByName(column = "도로명주소")
    val roadAddress: String? = null

    @CsvBindByName(column = "구우편번호")
    val oldPostalCode: Int? = null

    @CsvBindByName(column = "신우편번호")
    val newPostalCode: Int? = null

    @CsvBindByName(column = "동정보")
    val buildingNumber: String? = null

    @CsvBindByName(column = "층정보")
    val floor: String? = null

    @CsvBindByName(column = "호정보")
    val unitNumber: String? = null

    @CsvBindByName(column = "경도")
    val latitude: String? = null

    @CsvBindByName(column = "위도")
    val longitude: String? = null
}