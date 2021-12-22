package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LesDay (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val student: String,
    val time: String
)