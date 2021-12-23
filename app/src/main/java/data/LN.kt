package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LN")
data class LN(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo
    val day: String,
    @ColumnInfo
    val time: String,

    @ColumnInfo(name = "student")
    val student: String
)