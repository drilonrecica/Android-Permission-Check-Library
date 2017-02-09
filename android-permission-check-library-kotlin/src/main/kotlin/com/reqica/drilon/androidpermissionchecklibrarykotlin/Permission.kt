package com.reqica.drilon.androidpermissionchecklibrarykotlin

/*
		MIT License

		Copyright (c) 2017 Drilon Reçica

		Permission is hereby granted, free of charge, to any person obtaining a copy
		of this software and associated documentation files (the "Software"), to deal
		in the Software without restriction, including without limitation the rights
		to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
		copies of the Software, and to permit persons to whom the Software is
		furnished to do so, subject to the following conditions:

		The above copyright notice and this permission notice shall be included in all
		copies or substantial portions of the Software.

		THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
		IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
		FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
		AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
		LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
		OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
		SOFTWARE.

*/

import android.Manifest

object Permission {
	val REQUEST_CODE_ASK_PERMISSIONS = 123

	val READ_CALENDAR = Manifest.permission.READ_CALENDAR
	val WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR
	val CAMERA = Manifest.permission.CAMERA
	val READ_CONTACTS = Manifest.permission.READ_CONTACTS

	val WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS
	val GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS
	val ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
	val ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION

	val RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
	val READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE
	val CALL_PHONE = Manifest.permission.CALL_PHONE
	val READ_CALL_LOG = Manifest.permission.READ_CALL_LOG

	val WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG
	val ADD_VOICEMAINL = Manifest.permission.ADD_VOICEMAIL
	val USE_SIP = Manifest.permission.USE_SIP
	val PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS

	val BODY_SENSORS = Manifest.permission.BODY_SENSORS
	val SEND_SMS = Manifest.permission.SEND_SMS
	val RECEIVE_SMS = Manifest.permission.RECEIVE_SMS
	val READ_SMS = Manifest.permission.READ_SMS

	val RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH
	val RECEIVE_MMS = Manifest.permission.RECEIVE_MMS
	val WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
	val READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
}
