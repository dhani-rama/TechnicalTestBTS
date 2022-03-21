package id.research.btstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.btstest.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var mLoginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mLoginBinding.root)

    }
}