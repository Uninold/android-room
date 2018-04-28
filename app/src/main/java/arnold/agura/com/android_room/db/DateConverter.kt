package arnold.agura.com.android_room.db

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by Arnold on 28 Apr 2018.
 */
object DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}