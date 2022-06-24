package com.irafinancial.data.remote

object Constants {
    const val ARG_PARAM1 = "param1"
    const val ARG_PARAM2 = "param2"
    const val ARG_PARAM3 = "param2"

    //Database Name
    const val DATABASE_NAME = ""

    //Api End Points


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



    //api constants
    const val USERS_LOG_IN = "ira/index.php?option=com_api\u200B&app=users\u200B&resource=login\u200B&format=raw"
    const val USERS_SIGN_UP = "ira/index.php?option=com_api\u200B&app=users\u200B&resource=user\u200B&format=raw"
    const val MENU_LIST = "ira/index.php?option=com_api&app=menulinks&resource=link&format=raw"


    // broadcast
    const val SEND_NOTIFICATION = "send_notification"

    //SharedPref Keys
    const val AUTH_TOKEN = "authToken"
    const val JWT_TOKEN = "jwtToken"
    const val USER_ID = "user_id"
    const val BASE_URL_NEW = "baseUrlNew"
    const val PASSCODE = "passcode"
    const val EMAIL = "email"
    const val USERNAME = "userName"
    const val ADD = "ADD"
    const val MEDIUM = "medium"
    const val SMALL = "small"
    const val LARGE = "large"
    const val PERCENTAGE = "Percentage"
    const val AMOUNT = "Amount"
    const val IS_ORDER_UPDATE = "isOrderUpdate"
    const val REDIRECT_FROM = "redirect_from"
    const val WEB_URL = "web_url"
    const val FIRST_NAME = "first_name"
    const val LAST_NAME = "last_name"
    const val MIDDLE_NAME = "middle_name"


}