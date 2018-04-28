package arnold.agura.com.android_room.db

/**
 * Created by Arnold on 28 Apr 2018.
 */
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Book {
    @PrimaryKey
    lateinit var id: String

    var title: String? = null
}