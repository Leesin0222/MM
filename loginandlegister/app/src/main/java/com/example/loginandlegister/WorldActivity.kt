package com.example.loginandlegister

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WorldActivity : AppCompatActivity() {
    private lateinit var actionBar: androidx.appcompat.app.ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LoginAndLegister)
        setContentView(R.layout.activity_world)

        actionBar = supportActionBar!!
        actionBar.hide()


            val tableLayout=findViewById<TabLayout>(R.id.tab_layout)
            val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

            val adapter=ViewPagerAdapter(supportFragmentManager, lifecycle)

            viewPager2.adapter=adapter

            TabLayoutMediator(tableLayout,viewPager2){tab,position->
                when(position){
                    0->{
                        tab.text="액션"
                    }
                    1->{
                        tab.text="공포"
                    }
                    2->{
                        tab.text="로맨스"
                    }
                    3->{
                        tab.text="스포츠"
                    }
                    4->{
                        tab.text="개발자"
                    }
                    5->{
                        tab.text="갈림길"
                    }
                }

            }.attach()
        }
}