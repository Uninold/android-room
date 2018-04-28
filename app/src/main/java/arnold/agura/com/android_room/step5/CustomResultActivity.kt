package arnold.agura.com.android_room.step5

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import arnold.agura.com.android_room.R

/**
 * Created by Arnold on 28 Apr 2018.
 */

class CustomResultActivity : AppCompatActivity() {

    private var mShowUserViewModel: CustomResultViewModel? = null

    private var mBooksTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.db_activity)
        mBooksTextView = findViewById(R.id.books_tv)

        mShowUserViewModel = ViewModelProviders.of(this).get(CustomResultViewModel::class.java)

        populateDb()

        subscribeUiLoans()
    }

    private fun populateDb() {
        mShowUserViewModel!!.createDb()
    }

    private fun subscribeUiLoans() {
        mShowUserViewModel!!.loansResult?.observe(this, Observer { result -> mBooksTextView!!.text = result })
    }

    fun onRefreshBtClicked(view: View) {
        populateDb()
        subscribeUiLoans()
    }
}
