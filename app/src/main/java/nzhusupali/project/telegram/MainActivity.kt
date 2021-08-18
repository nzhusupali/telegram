package nzhusupali.project.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nzhusupali.project.telegram.databinding.ActivityMainBinding
import nzhusupali.project.telegram.ui.objects.AppDrawer
import nzhusupali.project.telegram.ui.fragments.ChatsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
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
        mAppDrawer.create() // Создаём боковое меню
        // Fragment in mainActivity
        setSupportActionBar(mToolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsFragment()).commit()

    }


    private fun initFields() {
        mToolbar = binding.mainToolbar

        // Инициализируем AppDrawer(Боковое меню)
        mAppDrawer = AppDrawer(this, mToolbar)


    }



}