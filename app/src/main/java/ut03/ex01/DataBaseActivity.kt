package ut03.ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.tijanidian.add_playground.R
import ut03.ex01.data.AppDataBase
import ut03.ex01.data.UserEntity

class DataBaseActivity : AppCompatActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base2)
        initDb()
    }

    private fun initDb() {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "demo_db"
        ).build()

        Thread(Runnable {
            var user = db.userDao().findById(1)
            if (user == null) {
                db.userDao().insert(UserEntity(1, "Tijani", "user", "email"))
                user = db.userDao().findById(1)
            }
            Log.d("@dev", "$user")
        }).start()
    }

}