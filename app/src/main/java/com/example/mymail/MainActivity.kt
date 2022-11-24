package com.example.mymail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_inbox, R.id.nav_outbox, R.id.nav_trash, R.id.nav_spam
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Imagen redondo
        val header = navView.getHeaderView(0)
        val fotouser = header.findViewById<ImageView>(R.id.imageView)
        val bm = BitmapFactory.decodeResource(applicationContext.resources, R.mipmap.fotocuadrada)
        val drawable = RoundedBitmapDrawableFactory.create(applicationContext.resources, bm)
        drawable.isCircular = true
        fotouser.setImageDrawable(drawable)

        //Spinner
        val emails = arrayOf(
            getString(R.string.nav_header_email),
            getString(R.string.nav_header_email1),
            getString(R.string.nav_header_email2)
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, emails)
        val list_email = header.findViewById<Spinner>(R.id.spinner)
        list_email.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}