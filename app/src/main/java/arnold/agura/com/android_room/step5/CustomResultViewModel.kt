package arnold.agura.com.android_room.step5

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import arnold.agura.com.android_room.db.AppDatabase
import arnold.agura.com.android_room.db.utils.DatabaseInitializer
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Arnold on 28 Apr 2018.
 */


class CustomResultViewModel(application: Application) : AndroidViewModel(application) {

    var loansResult: LiveData<String>? = null
        private set

    private var mDb: AppDatabase? = null

    private val yesterdayDate: Date
        get() {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, -1)
            return calendar.time
        }

    fun createDb() {
        mDb = AppDatabase.getInMemoryDatabase(getApplication())

        // Populate it with initial data
        DatabaseInitializer.populateAsync(mDb!!)

        // Receive changes
        subscribeToDbChanges()
    }

    private fun subscribeToDbChanges() {
        // TODO: Modify this query to show only recent loans from specific user
        val loans = mDb!!.loanModel().findAllWithUserAndBook()

        // Instead of exposing the list of Loans, we can apply a transformation and expose Strings.
        loansResult = Transformations.map(loans
        ) { loansWithUserAndBook ->
            val sb = StringBuilder()
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm",
                    Locale.US)

            for (loan in loansWithUserAndBook) {
                sb.append(java.lang.String.format("%s\n  (Returned: %s)\n",
                        loan.bookTitle,
                        simpleDateFormat.format(loan.endTime)))
            }
            sb.toString()
        }
    }
}
