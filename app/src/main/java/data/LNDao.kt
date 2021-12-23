package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LNDao {
    @Query("SELECT * FROM LN")
    fun getAll(): List<LN>

    @Insert
    fun insert(les: LN)

    @Delete
    fun delete(les: LN)
}