package id.research.btstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.research.btstest.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var mRegisterBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mRegisterBinding.root)

        mRegisterBinding.btnRegister.setOnClickListener {
            if (validate()) {
                val mEmail = mRegisterBinding.etEmail.text.toString()
                val mPassword = mRegisterBinding.etPassword.text.toString()
                val mUsername = mRegisterBinding.etUsername.text.toString()
                signUpCheck(mEmail, mPassword, mUsername)
            }
        }
    }

    private fun validate(): Boolean {

        if(mRegisterBinding.etEmail.text.toString() == "") {
            mRegisterBinding.etEmail.error = "Harap Isi Email Terlebih Dahulu"
            mRegisterBinding.etEmail.requestFocus()

            return false
        }
        else if(mRegisterBinding.etPassword.text.toString() == "") {
            mRegisterBinding.etPassword.error = "Harap Isi Kata Sandi Terlebih Dahulu"
            mRegisterBinding.etPassword.requestFocus()

            return false
        }
        else if(mRegisterBinding.etUsername.text.toString() == "") {
            mRegisterBinding.etUsername.error = "Harap Isi Username Terlebih Dahulu"
            mRegisterBinding.etUsername.requestFocus()

            return false
        }
        return true
    }

    private fun signUpCheck(mEmail: String, mPassword: String, mUsername:String){
        val service = RetrofitClient().apiRequest().create(DataService::class.java)
        service.register(mEmail, mPassword, mUsername).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    val email = mRegisterBinding.etEmail.text.toString()
                    val password = mRegisterBinding.etPassword.text.toString()
                    val username = mRegisterBinding.etUsername.text.toString()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}