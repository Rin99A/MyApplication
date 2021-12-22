package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LN")
data class LN(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val day: String,
    val time: String,

    @ColumnInfo(name = "student")
    val student: String
)