package dev.usbharu.kotlindataclassspringdatajdbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDataClassSpringDataJdbcApplication

fun main(args: Array<String>) {
    val runApplication = runApplication<KotlinDataClassSpringDataJdbcApplication>(*args)
    val itemRepository = runApplication.getBean(ItemRepository::class.java)
    itemRepository.save(Item.of(null,"hello"))
    println(itemRepository.findAll())
}
