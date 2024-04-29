package com.example.workwithopencv

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loaded = OpenCVLoader.initDebug()
        Log.d("~~~", "loaded: $loaded")
        if (loaded) {
            val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.img)
//            val bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.width / 2, bitmap1.height / 2)
            val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.img_4points)
            Log.d("~~~", "similarity: ${SIFTUtils.similarity(bitmap1, bitmap2)}")
            var tvResult = findViewById<View>(R.id.tv_result) as TextView
            tvResult.text = "similarity: ${SIFTUtils.similarity(bitmap1, bitmap2)}"
        }
    }
}