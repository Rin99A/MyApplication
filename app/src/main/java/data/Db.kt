package data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StudentsTable::class, LessonsTable::class, LN::class, LesDay::class], version = 1)
abstract class Db : RoomDatabase() {
    abstract fun StudentsDao(): StudentsDao
    abstract fun LessonsDao(): LessonsDao
    abstract fun JoinDao(): JoinDao
    abstract fun LesDaysDao(): LesDaysDao

    companion object {
        var database: Db? = null

        @Synchronized
        fun getDatabase(context: Context): Db {
            if (database == null)
                database = Room.databaseBuilder(context, Db::class.java, "database")
                    .allowMainThreadQueries().build()
            return database!! as Db

        }

    }
}