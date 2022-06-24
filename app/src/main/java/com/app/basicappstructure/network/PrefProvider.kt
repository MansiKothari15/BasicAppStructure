package com.app.basicappstructure.network

import android.content.Context
import android.content.SharedPreferences
import com.app.basicappstructure.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefProvider @Inject constructor(@ApplicationContext context: Context) {

    internal var sharedPreferences: SharedPreferences? = null
    internal var mContext = context

    fun openPref() {
        sharedPreferences = mContext.getSharedPreferences(
            mContext.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
    }

    fun getValue(
        key: String,
        defaultValue: String
    ): String {
        openPref()
        val result = sharedPreferences?.getString(key, defaultValue)
        sharedPreferences = null
        return result ?: ""
    }

    fun getValueInt(
        key: String?,
        defaultValue: Int
    ): Int {
        openPref()
        val result = sharedPreferences!!.getInt(key, defaultValue)
        sharedPreferences = null
        return result
    }

    fun setValue(
        key: String,
        value: String
    ) {
        openPref()
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor!!.putString(key, value)
        prefsPrivateEditor.commit()
        sharedPreferences = null
    }

    fun setValueInt(
        key: String?,
        value: Int
    ) {
        openPref()
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor!!.putInt(key, value)
        prefsPrivateEditor.commit()
        sharedPreferences = null
    }


    fun setValueDouble(
        key: String?,
        value: Double
    ) {
        openPref()
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor!!.putLong(key, value.toLong())
        prefsPrivateEditor.commit()
        sharedPreferences = null
    }

    fun getValueDouble(
        key: String,
        defaultValue: Double
    ): Double {
        openPref()
        val result = sharedPreferences!!.getFloat(key, defaultValue.toFloat())
        sharedPreferences = null
        return result.toDouble()
    }

    fun getValueboolean(
        key: String?,
        defaultValue: Boolean
    ): Boolean {
        openPref()
        val result = sharedPreferences!!.getBoolean(key, defaultValue)
        sharedPreferences = null
        return result
    }

    fun setValueboolean(
        key: String?,
        value: Boolean
    ) {
        openPref()
        val prefsPrivateEditor = sharedPreferences!!.edit()
        prefsPrivateEditor!!.putBoolean(key, value)
        prefsPrivateEditor.commit()
        sharedPreferences = null
    }


    fun setClear() {
        openPref()
        val prefsPrivateEditor = sharedPreferences!!.edit().clear().commit()
//        prefsPrivateEditor!!.clear().apply()
        sharedPreferences = null
    }



}