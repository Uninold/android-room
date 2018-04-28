package arnold.agura.com.android_room.db

import android.arch.persistence.room.*
import java.util.*

/**
 * Created by Arnold on 28 Apr 2018.
 */

@Entity(foreignKeys = [(ForeignKey(entity = Book::class, parentColumns = arrayOf("id"), childColumns = arrayOf("book_id"))), (ForeignKey(entity = User::class, parentColumns = arrayOf("id"), childColumns = arrayOf("user_id")))])
@TypeConverters(DateConverter::class)
class Loan {
    // Fields can be public or private with getters and setters.
    @PrimaryKey
    lateinit var id: String

    var startTime: Date? = null

    var endTime: Date? = null

    @ColumnInfo(name = "book_id")
    var bookId: String? = null

    @ColumnInfo(name = "user_id")
    var userId: String? = null
}