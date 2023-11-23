package dev.usbharu.kotlindataclassspringdatajdbc

import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.annotation.PersistenceCreator
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration

@JvmInline
value class ItemId private constructor(val id:Long){
    companion object{
        @PersistenceCreator
        fun of(id:Long): ItemId {
            require(id>=0)
            return ItemId(id)
        }

        val NULL = ItemId(-1)
    }
}

class ItemIdToLongConverter : Converter<ItemId,Long> {


    override fun convert(source: ItemId): Long? {
        return source.id
    }
}

class LongToItemIdConverter : Converter<Long,ItemId> {
    override fun convert(source: Long): ItemId? {
        return ItemId.of(source)
    }
}

@Configuration
class MyJdbcConfiguration : AbstractJdbcConfiguration() {
    override fun userConverters(): MutableList<*> {
        println("aaaaaaaaaaa")
        return mutableListOf(LongToItemIdConverter(),ItemIdToLongConverter())
    }
}
