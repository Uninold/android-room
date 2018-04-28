package arnold.agura.com.android_room.db

import android.arch.persistence.room.ColumnInfo

import android.arch.persistence.room.*
import java.util.*

/**
 * Created by Arnold on 28 Apr 2018.
 */

class LoanWithUserAndBook {
    var id: String? = null

    @ColumnInfo(name = "title")
    var bookTitle: String? = null

    @ColumnInfo(name = "name")
    var userName: String? = null

    @TypeConverters(DateConverter::class)
    var startTime: Date? = null

    @TypeConverters(DateConverter::class)
    var endTime: Date? = null
}
