package arnold.agura.com.android_room.step4_solution

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import arnold.agura.com.android_room.db.AppDatabase
import arnold.agura.com.android_room.db.Book
import arnold.agura.com.android_room.db.utils.DatabaseInitializer
import java.util.*

/**
 * Created by Arnold on 28 Apr 2018.
 */



class TypeConvertersViewModel(application: Application) : AndroidViewModel(application) {

    var books: LiveData<List<Book>>? = null
        private set

    private var mDb: AppDatabase? = null

    init {
        createDb()
    }

    fun createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication())

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb!!)

        // Receive changes
        subscribeToDbChanges()
    }

    private fun subscribeToDbChanges() {
        // Books is a LiveData object so updates are observed.
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        val yesterday = calendar.time
        books = mDb!!.bookModel().findBooksBorrowedByNameAfter("Mike", yesterday)
    }
}
