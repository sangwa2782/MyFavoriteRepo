package com.ajayam.mygit.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.ajayam.mygit.data.RepoData

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "AddedGitList.db", null, 1) {

    companion object {
        private const val TABLE_NAME = "repo_data"
        private const val COL_ID = "id"
        private const val REPO_NAME = "repo_name"
        private const val OWNER_NAME = "owner_name"
        private const val DESCRIPTION = "description"
        private const val URL = "url"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,  $OWNER_NAME TEXT, $REPO_NAME TEXT, $DESCRIPTION TEXT, $URL TEXT)"

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


    //save repository data
    fun saveRepoData(repoData: RepoData) {

        val contentValues = ContentValues()
        contentValues.put(OWNER_NAME, repoData.ownerName)
        contentValues.put(REPO_NAME, repoData.repoName)
        contentValues.put(URL, repoData.url)
        contentValues.put(DESCRIPTION, repoData.description)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, contentValues)
        Log.e("TAG", "saveRepoData: ")
        db.close()
    }

    //get repo data
    fun getRepoList(): MutableList<RepoData>? {
        var repoData1 = mutableListOf<RepoData>()

        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME ORDER BY $COL_ID DESC "

        val cursor: Cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {
                val repoData = RepoData(
                    cursor.getString(cursor.getColumnIndexOrThrow(OWNER_NAME)), cursor.getString(
                        cursor.getColumnIndexOrThrow(
                            REPO_NAME
                        )
                    ), cursor.getString(cursor.getColumnIndexOrThrow(URL)), cursor.getString(
                        cursor.getColumnIndexOrThrow(
                            DESCRIPTION
                        )
                    )
                )
                repoData1.add(repoData)
            } while (cursor.moveToNext())

        }

        cursor.close()
        db.close()

        return repoData1
    }

    //clear all data
    fun onRefreshClearTable() {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }

}