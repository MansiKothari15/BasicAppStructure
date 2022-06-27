package com.app.basicappstructure.ui.activity

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.app.basicappstructure.R
import com.app.basicappstructure.databinding.ActivityLoginBinding
import com.app.basicappstructure.network.Constants
import com.app.basicappstructure.ui.viewmodels.LoginViewModel
import com.app.basicappstructure.utils.ProgressUtils
import com.app.basicappstructure.utils.liveSnackBar
import com.google.android.material.snackbar.Snackbar
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

    private fun initView(){
        setupSnackbar()
        observeShowProgress()
        initListener()
        navigate()
    }

    private fun initListener(){
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

    private fun setupSnackbar() {
        loginBinding.root.liveSnackBar(this, viewModel.snackbarText, Snackbar.LENGTH_SHORT)
    }

    private fun observeShowProgress() {
        viewModel.showProgress.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                if (it) {
                    ProgressUtils.showProgressDialog(this)
                } else {
                    ProgressUtils.dismissProgressDialog()
                }
            }
        }

    }

    private fun navigate() {
        viewModel.data.observe(this) { event ->
            event.getContentIfNotHandled()?.let { loginData ->
                /*if (loginData.err_code == 200) {
                    if (loginData.data.otp != null) {
                        val bundle = Bundle().apply {
                            putSerializable("loginData", loginData)
                        }
                        // hostSelectionInterceptor?.setHostBaseUrl()
                        findNavController().navigate(R.id.passcode, bundle)
                    } else {
                        prefProvider.setValue(Constants.FIRST_NAME,loginData?.data?.firstname.toString())
                        prefProvider.setValue(Constants.LAST_NAME,loginData?.data?.lastname.toString())
                        prefProvider.setValue(Constants.EMAIL,loginData?.data?.email.toString())
                        prefProvider.setValue(Constants.MIDDLE_NAME,loginData?.data?.secondname.toString())
                        prefProvider.setValue(Constants.JWT_TOKEN,loginData?.data?.jwt.toString())
                        prefProvider.setValue(Constants.AUTH_TOKEN,loginData?.data?.auth.toString())
                        prefProvider.setValue(Constants.USER_ID,loginData?.data?.id.toString())

                        findNavController().navigate(R.id.action_login_to_dashboard)
                    }
                } else {
                    activity?.let {
                        AlertUtils.showCustomAlertWithListenerWithOK(
                            it,
                            loginData.err_msg
                        ) { _, _ ->

                            //backPressManage()
                        }

                    }

                }*/

            }
        }

    }

}