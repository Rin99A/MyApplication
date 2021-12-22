package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "lessons",
    foreignKeys = [ForeignKey(
        entity = StudentsTable::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("student_id")
    )]
)
data class LessonsTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo
        (name = "day")
    val day: String,

    @ColumnInfo
        (name = "time")
    val time: String,

    @ColumnInfo
        (name = "student_id")
    val student_id: String
)
