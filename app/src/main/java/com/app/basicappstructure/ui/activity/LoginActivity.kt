package com.app.basicappstructure.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.basicappstructure.R
import com.app.basicappstructure.databinding.ActivityLoginBinding
import com.app.basicappstructure.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        initView()
    }

    fun initView(){
        loginBinding.llLoginBtnLogin.setOnClickListener {
            if (TextUtils.isEmpty(loginBinding.etLoginEmailAddress.text!!.trim())) {
                loginBinding.etLoginEmailAddress.error = getString(R.string.email_validate)
            } else if (!Patterns.EMAIL_ADDRESS.matcher(loginBinding.etLoginEmailAddress.text!!.trim()).matches()) {
                loginBinding.etLoginEmailAddress.error = getString(R.string.valid_email_validate)
            } else if (TextUtils.isEmpty(loginBinding.etLoginPassword.text?.trim())) {
                loginBinding.etLoginPassword.error = getString(R.string.password_validate)
            } else if (loginBinding.etLoginPassword.text.toString().length < 4) {
                loginBinding.etLoginPassword.error = getString(R.string.invalid_confirm_password_length)
            } else {
                viewModel.login()
            }

        }
    }

}