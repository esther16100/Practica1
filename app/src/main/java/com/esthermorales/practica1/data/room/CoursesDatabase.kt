package com.esthermorales.practica1.data.room

import android.content.Context
import androidx.room.*
import com.esthermorales.practica1.domain.CourseModel

@Database(entities = [Curso::class], version = 1, exportSchema = false)
abstract class CoursesDatabase : RoomDatabase() {

    abstract val coursesDao: CoursesDao

    companion object {

        @Volatile
        private var INSTANCE: CoursesDatabase? = null

        fun getInstance(context: Context): CoursesDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoursesDatabase::class.java,
                        "course_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}

@Dao
interface CoursesDao {

    @Insert
    suspend fun insert(curso: Curso)

    @Query("SELECT * FROM TABLA_CURSO WHERE numeroSeminari = :cursoId")
    suspend fun getCurso(cursoId: String): Curso

    @Query("SELECT * FROM TABLA_CURSO")
    suspend fun getAllCursos(): List<Curso>

}


@Entity(tableName = "tabla_curso")
data class Curso(
    @PrimaryKey
    val numeroSeminari: String,
    @ColumnInfo(name = "logo")
    val logo: String,
    @ColumnInfo(name = "titol")
    val titol: String,
    @ColumnInfo(name = "empresa_organitzadora")
    val empresaOrganitzadora: String
)


fun Curso.toModel(): CourseModel {
    return CourseModel(
        id = this.numeroSeminari,
        logo = this.logo,
        titol = this.titol,
        empresaOrganitzadora = this.empresaOrganitzadora
    )
}
