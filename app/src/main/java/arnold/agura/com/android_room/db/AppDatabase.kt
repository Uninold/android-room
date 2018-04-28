package arnold.agura.com.android_room.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Arnold on 28 Apr 2018.
 */

@Database(entities = [(User::class), (Book::class), (Loan::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userModel(): UserDao

    abstract fun bookModel(): BookDao

    abstract fun loanModel(): LoanDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInMemoryDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                        // To simplify the codelab, allow queries on the main thread.
                        // Don't do this on a real app! See PersistenceBasicSample for an example.
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}