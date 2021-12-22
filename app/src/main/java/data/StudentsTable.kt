package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentsTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo
        (name = "name") val name: String,

    @ColumnInfo
        (name = "grade") val grade: String,

    @ColumnInfo
        (name = "duration") val duration: String,

    @ColumnInfo
        (name = "purpose") val purpose: String,

    @ColumnInfo
        (name = "cost") val cost: String

)