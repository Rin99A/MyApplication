package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentsDao {
    @Query("SELECT name FROM students")
    fun getName(): List<String>

    @Query("SELECT * FROM students")
    fun getAll(): List<StudentsTable>

    // @Query("SELECT id FROM students")
    // fun getid(): List<Int>

    @Query("SELECT COUNT(*) FROM students ")
    fun getcount(): Int


    @Insert
    fun insertAll(vararg student: StudentsTable)

    @Insert
    fun insert(student: StudentsTable)

    @Delete
    fun delete(student: StudentsTable)


}