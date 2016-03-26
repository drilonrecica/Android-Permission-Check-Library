package com.reqica.drilon.androidmpermissioncheck;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

public class CreatePermissionDialog {

    static Context context;
    static Activity activity;

    public CreatePermissionDialog (Context context , Activity activity){
        CreatePermissionDialog.context = context;
        CreatePermissionDialog.activity = activity;
    }

    public static void checkMPermission (final String permission , String dialogMessage) {


        int hasSpecificPermission = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);
        }
        if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!activity.shouldShowRequestPermissionRationale(permission)) {
                    showMessageOKCancel(dialogMessage,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        activity.requestPermissions(new String[] {permission},
                                                PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{permission},
                        PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }
    }



    private static void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
