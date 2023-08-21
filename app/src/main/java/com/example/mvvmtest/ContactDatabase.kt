package com.example.mvvmtest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


// DB version Update when update tables
@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase :RoomDatabase() {
    abstract fun contactDao() : ContactDAO
    // For Single instance
    companion object{
        val migration_1_2 = object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTACE :ContactDatabase? = null;

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTACE == null){
                synchronized(this){
                    INSTACE =
                        Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java, "contactDB")
                            .addMigrations(migration_1_2)
                            .build();
                }
            }
            return  INSTACE!!;
        }
    }
}