package arnold.agura.com.android_room.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Arnold on 28 Apr 2018.
 */

@Entity
class User {
    @PrimaryKey
    lateinit var id: String

    var name: String? = null

    var lastName: String? = null

    var age: Int = 0
}
