package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
@Dao
interface LesDaysDao {
    @Query(
        "SELECT  time, student FROM LN WHERE day = 'Понедельник'"
    )
    fun getm(): List<LesDay>
    @Query(
        "SELECT time as time, student as student  FROM LN WHERE day = 'Вторник'"
    )
    fun gett(): List<LesDay>
    @Query(
        "SELECT time, student FROM LN WHERE day = 'Среда'"
    )
    fun getц(): List<LesDay>
    @Query(
        "SELECT time, student  FROM LN WHERE day = 'Четверг'"
    )
    fun getth(): List<LesDay>
    @Query(
        "SELECT time, student as student FROM lessons, students WHERE student_id = students.id AND lessons.day = 'Пятница'"
    )
    fun getf(): List<LesDay>
    @Query(
        "SELECT lessons.day, lessons.time, students.name as student FROM lessons, students WHERE student_id = students.id AND lessons.day = 'Суббота'"
    )
    fun getsat(): List<LesDay>
    @Query(
        "SELECT lessons.day, lessons.time, students.name as student FROM lessons, students WHERE student_id = students.id AND lessons.day = 'Воскресенье'"
    )
    fun gets(): List<LesDay>


    @Delete
    fun delete(les: LesDay)
}