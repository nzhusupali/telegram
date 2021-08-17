package nzhusupali.project.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import nzhusupali.project.telegram.databinding.ActivityMainBinding
import nzhusupali.project.telegram.ui.ChatsFragment
import nzhusupali.project.telegram.ui.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        // Fragment in mainActivity
        setSupportActionBar(mToolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsFragment()).commit()

        createHeader()
        createDrawer()
    }

    // Меню
    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(

                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Create group")
                    .withIcon(R.drawable.ic_menu_create_groups)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Create secret chat")
                    .withIcon(R.drawable.ic_menu_secret_chat)
                    .withSelectable(false),


                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Create channel")
                    .withIcon(R.drawable.ic_menu_create_channel)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Contacts")
                    .withIcon(R.drawable.ic_menu_contacts)
                    .withSelectable(false),



                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Calls")
                    .withIcon(R.drawable.ic_menu_phone)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Favorite")
                    .withIcon(R.drawable.ic_menu_favorites)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Settings")
                    .withIcon(R.drawable.ic_menu_settings)
                    .withSelectable(false),

                DividerDrawerItem(),

                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("Invite friends")
                    .withIcon(R.drawable.ic_menu_invate)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Telegram features")
                    .withIcon(R.drawable.ic_menu_help)
                    .withSelectable(false),


                // Обработчик нажатия на кнопки
            ).withOnDrawerItemClickListener(object: Drawer.OnDrawerItemClickListener{

                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when(position) {
                        7 -> supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataContainer, SettingsFragment())
                            .commit()
                    }

                    return false
                }

            }).build()
    }

    // Аккаунты добавленные
    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Nurislam Zhusupali")
                    .withEmail("+7 747 900 2083")
            )
            .addProfiles(
                ProfileDrawerItem().withName("Cook")
                    .withEmail("+7 778 188 8073")
            )
            .build()
    }

    private fun initFields() {
        mToolbar = binding.mainToolbar

    }



}