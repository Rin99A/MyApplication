package data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JoinDao {
    @Query(
        "SELECT lessons.day, lessons.time, students.name as student FROM lessons, students WHERE student_id = students.id"
    )
    fun getl(): List<LN>


    @Insert
    fun insert (les: LN)
}