package com.ism.saveanimal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.content.ContentProviderCompat.requireContext
import com.ism.saveanimal.databinding.SaveHomeBinding
import com.ism.saveanimal.databinding.SaveMenuFullBinding



class SaveMainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: SaveMenuFullBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SaveMenuFullBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.appBarMain.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.appBarMain.toolbar.navigationIcon?.setTint(Color.parseColor("#A0B9FF"))

        val name = intent.getStringExtra("name")
        val bundle = Bundle()
        bundle.putString("name", name)

        binding.appBarMain.fab.setOnClickListener {
            val intent = Intent(this, SaveAnnouncementWrite::class.java)
            startActivity(intent)
        }
//        val adapter = SaveHome(itemList) { clickedItem ->
//            // LongClick된 아이템 처리
//            val intent = Intent(requireContext(), SaveEditActivity::class.java)
//            intent.putExtra("postId", clickedItem.id)
//            startActivity(intent)
//        }
//
//        binding.recyclerView.adapter = adapter

//
//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .setAnchorView(R.id.fab).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.setGraph(R.navigation.savemobile_navigation, bundle)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.apply_check, R.id.profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

