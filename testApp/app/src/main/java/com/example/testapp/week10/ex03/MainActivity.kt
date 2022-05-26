package com.example.week10ex03

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class MainActivity : AppCompatActivity() {
    val databaseName = "movie"
    var database: SQLiteDatabase? = null
    val tableName = "movie_reserved"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDatabase()
        createTable()

        doButton1.setOnClickListener {
            saveMovie()
        }

        doButton2.setOnClickListener {
            loadMovie()
        }
    }

    fun createDatabase() {
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null)
    }

    fun createTable() {
        database?.execSQL("DROP Table if exists ${tableName}")
        val sql = "create table if not exists ${tableName}" +
                "(_id integer PRIMARY KEY autoincrement, " +
                "name text," +
                "poster_image text," +
                "director text," +
                "reserved_time text," +
                "synopsis text)"

        if(database == null)    return
        database?.execSQL(sql)
    }

    fun saveMovie() {
        val posterImageUri = savePosterToFile(R.drawable.aa)

        val name = input1.text.toString()
        val reserved_time = input2.text.toString()
        val director = input3.text.toString()
        val synopsis = input4.text.toString()
        val poster_image = posterImageUri.toString()

        addData(name, poster_image, director, synopsis, reserved_time)
    }

    fun savePosterToFile(drawable:Int) : Uri {
        val drawable = ContextCompat.getDrawable(applicationContext, drawable)
        val bitmap = (drawable as BitmapDrawable).bitmap

        val wrapper = ContextWrapper(applicationContext)
        val imagesFolder = wrapper.getDir("images", Context.MODE_PRIVATE)
        val file = File(imagesFolder, "aa.jpg")

        try{
            val stream : OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e : IOException) {
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    fun addData(name:String, poster_image: String, director:String, synopsis:String, reserved_time:String){
        val sql = "insert into ${tableName}(name,poster_image,director,synopsis,reserved_time)" + "values" +
                "(?,?,?,?,?)"

        if(database == null) {
            println("데이터베이스를 먼저 오픈하세요\n")
            return
        }
        database?.execSQL(sql, arrayOf(name, poster_image, director, synopsis, reserved_time))
        println("데이터 추가됨\n")
    }

    fun loadMovie() {
        val movies = queryData()

        val intent = Intent(this, ReservedActivity::class.java)
        intent.putExtra("movies", movies)
        startActivity(intent)
    }

    fun queryData() : ArrayList<ReservedMovie>? {
        val sql = "select _id,name,poster_image,director,synopsis,reserved_time from ${tableName}"

        if(database == null) {
            println("데이터베이스를 먼저 오픈하세요\n")
        }

        val list = arrayListOf<ReservedMovie>()
        val cursor = database?.rawQuery(sql, null)
        if(cursor!= null){
            for(index in 0 until cursor.count){
                cursor.moveToNext()
                val _id = cursor.getInt(0)
                val name = cursor.getString(1)
                val poster_image = cursor.getString(2)
                val director = cursor.getString(3)
                val synopsis = cursor.getString(4)
                val reserved_time = cursor.getString(5)
                println("레코드# ${index}: $_id, $name, $poster_image, $director, $synopsis, $reserved_time\n")

                val movie = ReservedMovie(_id, name, poster_image, director, synopsis, reserved_time)
                list.add(movie)
            }
            if(cursor.count == 0){
                val movie = ReservedMovie(-99, "",
                    "", "", "", "")
                list.add(movie)
            }
            cursor.close()
        }
        println("데이터 조회함\n")
        return list
    }
}