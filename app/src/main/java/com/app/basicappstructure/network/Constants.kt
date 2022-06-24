package com.app.basicappstructure.network

object Constants {
    //Database Name
    const val DATABASE_NAME = ""

    //Api End Points
    const val USERS_LOG_IN = "users"
    const val USERS_SIGN_UP = "signup"

    /*file related constants*/
    const val FILE_NAME_VIDEO = "VID_CAPTURE_"
    const val FILE_NAME_IMG = "IMG_CAPTURE_"
    const val FILE_CAPTURE = "CAPTURE_"
    const val FOLDER_CAPTURE = "IRA Financial/CapturedFiles"
    const val MEDIA_TYPE_IMAGE = 111
    const val MEDIA_TYPE_VIDEO = 222
    const val EXTENSION_CAMERA_IMAGE_TEMP_IMG = "jpg"
    const val EXTENSION_CAMERA_VIDEO_TEMP_IMG = "mp4"

    //request codes
    var REQUEST_GET_IMAGE_GALLERY = 1
    var REQUEST_GET_IMAGE_CAMERA = 2
    val REQUEST_LOCATION_PERMISSION = 3

    // broadcast
    const val SEND_NOTIFICATION = "send_notification"

    //SharedPref Keys
    const val AUTH_TOKEN = "authToken"
    const val JWT_TOKEN = "jwtToken"
    const val USER_ID = "user_id"
    const val BASE_URL_NEW = "baseUrlNew"

}