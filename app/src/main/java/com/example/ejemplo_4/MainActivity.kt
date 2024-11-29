package com.example.ejemplo_4

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ViewSwitcher.ViewFactory {

    private lateinit var fotos: ArrayList<Imagen>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fotos = ArrayList()
        fotos.add(Imagen(R.drawable.image1))
        fotos.add(Imagen(R.drawable.image2))
        fotos.add(Imagen(R.drawable.image3))
        fotos.add(Imagen(R.drawable.image4))
        fotos.add(Imagen(R.drawable.image5))
        fotos.add(Imagen(R.drawable.image6))
        fotos.add(Imagen(R.drawable.image7))
        fotos.add(Imagen(R.drawable.image8))

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val imageSwitcher = findViewById(R.id.imageSwitcher) as ImageSwitcher
        imageSwitcher.setFactory(this)
        imageSwitcher.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        imageSwitcher.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        val recView = findViewById(R.id.recView) as RecyclerView
        recView.setHasFixedSize(true)
        val adaptador = AdaptadorImagen(fotos)

        adaptador.onClick = {
            val t = fotos[recView.getChildAdapterPosition(it)]
            imageSwitcher.setImageResource(t.foto)
        }

        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
        imageView.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        return imageView
    }
}