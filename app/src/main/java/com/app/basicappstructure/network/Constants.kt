package com.app.basicappstructure.network

object Constants {
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

    // broadcast
    const val SEND_NOTIFICATION = "send_notification"

}