package dev.usbharu.kotlindataclassspringdatajdbc

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("ITEM")
data class Item private constructor(
    @Id
    @get:JvmName("getId")
    val id: ItemId?,
    val value: String
) {
    companion object {
        @PersistenceCreator
        fun of(id: ItemId?, value: String): Item {
            return Item(
                id, value
            )
        }
    }
}
