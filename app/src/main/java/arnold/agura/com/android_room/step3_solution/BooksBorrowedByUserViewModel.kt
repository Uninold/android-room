package arnold.agura.com.android_room.step3_solution

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import arnold.agura.com.android_room.db.AppDatabase
import arnold.agura.com.android_room.db.Book
import arnold.agura.com.android_room.db.utils.DatabaseInitializer

/**
 * Created by Arnold on 28 Apr 2018.
 */


class BooksBorrowedByUserViewModel(application: Application) : AndroidViewModel(application) {

    val books: LiveData<List<Book>>

    private var mDb: AppDatabase? = null

    init {
        createDb()

        // Books is a LiveData object so updates are observed.
        books = mDb!!.bookModel().findBooksBorrowedByName("Mike")
    }

    fun createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication())

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb!!)
    }
}
