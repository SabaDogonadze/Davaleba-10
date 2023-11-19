package com.example.davaleba10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davaleba10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NavigationRecyclerAdapter
    private val items = mutableListOf<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        setItemsData()
        setUpNavigationRecycler()
    }

    private fun setUpNavigationRecycler() {
        adapter = NavigationRecyclerAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
        adapter.setData(items)
    }


    private fun setItemsData() {
        items.also {
            it.add(
                Data(
                    id = 0,
                    icon = R.drawable.user,
                    text = "Edit Profile",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 1,
                    icon = R.drawable.location,
                    text = "Address",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 2,
                    icon = R.drawable.notification_bell,
                    text = "Notification",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 3,
                    icon = R.drawable.wallet,
                    text = "Payment",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 4,
                    icon = R.drawable.security_verified,
                    text = "Security",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 5,
                    icon = R.drawable.language,
                    text = "Language",
                    language = "English(US)",
                    button = R.drawable.greater,
                    itemType = ItemType.ADDITIONAL
                )
            )

            it.add(
                Data(
                    id = 6,
                    icon = R.drawable.eye,
                    text = "Dark Mode",
                    language = "",
                    button = R.drawable.greater,
                    itemType = ItemType.ADDITIONAL2
                )
            )

            it.add(
                Data(
                    id = 7,
                    icon = R.drawable.lock,
                    text = "Privacy Policy",
                    language = "",
                    button = R.drawable.greater
                )
            )

            it.add(
                Data(
                    id = 8,
                    icon = R.drawable.warning,
                    text = "Help Center",
                    language = "",
                    button = R.drawable.greater,
                    itemType = ItemType.NORMAL
                )
            )

            it.add(
                Data(
                    id = 9,
                    icon = R.drawable.people,
                    text = "Invite Friends",
                    language = "",
                    button = R.drawable.greater,
                    itemType = ItemType.NORMAL
                )
            )

            it.add(
                Data(
                    id = 10,
                    icon = R.drawable.log_out,
                    text = "Logout",
                    language = "",
                    button = R.drawable.greater,
                    itemType = ItemType.NORMAL
                )
            )


        }


    }


}
