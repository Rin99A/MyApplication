package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LessonsDao {
    @Query("SELECT * FROM lessons")
    fun getAll(): List<LessonsTable>

    @Insert
    fun insertAll(vararg lesson: LessonsTable)

    @Delete
    fun delete(lesson: LessonsTable)
}