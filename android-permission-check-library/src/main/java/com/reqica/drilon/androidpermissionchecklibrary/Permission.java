package com.reqica.drilon.androidpermissionchecklibrary;

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

import android.Manifest;

public class Permission {
	protected static final int REQUEST_CODE_ASK_PERMISSIONS = 123;

	public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
	public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
	public static final String CAMERA = Manifest.permission.CAMERA;
	public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;

	public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
	public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
	public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
	public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

	public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
	public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
	public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
	public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;

	public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
	public static final String ADD_VOICEMAINL = Manifest.permission.ADD_VOICEMAIL;
	public static final String USE_SIP = Manifest.permission.USE_SIP;
	public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;

	public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
	public static final String SEND_SMS = Manifest.permission.SEND_SMS;
	public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
	public static final String READ_SMS = Manifest.permission.READ_SMS;

	public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
	public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
	public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
	public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
}
