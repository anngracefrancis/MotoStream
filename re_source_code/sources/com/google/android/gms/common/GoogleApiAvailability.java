package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import cm.aptoide.pt.downloadmanager.Constants;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f11631c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final GoogleApiAvailability f11632d = new GoogleApiAvailability();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11633e = GoogleApiAvailabilityLight.a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11634f;

    @SuppressLint({"HandlerLeak"})
    private class a extends zap {
        private final Context a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i2);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int i3 = GoogleApiAvailability.this.i(this.a);
            if (GoogleApiAvailability.this.m(i3)) {
                GoogleApiAvailability.this.s(this.a, i3);
            }
        }
    }

    private final String B() {
        String str;
        synchronized (f11631c) {
            str = this.f11634f;
        }
        return str;
    }

    public static GoogleApiAvailability q() {
        return f11632d;
    }

    public static Dialog t(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(ConnectionErrorMessages.d(activity, 18));
        builder.setPositiveButton(HttpUrl.FRAGMENT_ENCODE_SET, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        w(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    static Dialog u(Context context, int i2, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(ConnectionErrorMessages.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = ConnectionErrorMessages.c(context, i2);
        if (strC != null) {
            builder.setPositiveButton(strC, dialogRedirect);
        }
        String strG = ConnectionErrorMessages.g(context, i2);
        if (strG != null) {
            builder.setTitle(strG);
        }
        return builder.create();
    }

    static void w(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof androidx.fragment.app.d) {
            SupportErrorDialogFragment.d(dialog, onCancelListener).show(((androidx.fragment.app.d) activity).getSupportFragmentManager(), str);
        } else {
            ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    @TargetApi(20)
    private final void y(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        if (i2 == 18) {
            x(context);
            return;
        }
        if (pendingIntent == null) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = ConnectionErrorMessages.f(context, i2);
        String strE = ConnectionErrorMessages.e(context, i2);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        androidx.core.app.i.e eVarA = new androidx.core.app.i.e(context).r(true).g(true).l(strF).A(new androidx.core.app.i.c().h(strE));
        if (DeviceProperties.d(context)) {
            Preconditions.n(PlatformVersion.g());
            eVarA.y(context.getApplicationInfo().icon).v(2);
            if (DeviceProperties.e(context)) {
                eVarA.a(com.google.android.gms.base.R.drawable.a, resources.getString(com.google.android.gms.base.R.string.o), pendingIntent);
            } else {
                eVarA.j(pendingIntent);
            }
        } else {
            eVarA.y(android.R.drawable.stat_sys_warning).B(resources.getString(com.google.android.gms.base.R.string.f11564h)).E(System.currentTimeMillis()).j(pendingIntent).k(strE);
        }
        if (PlatformVersion.k()) {
            Preconditions.n(PlatformVersion.k());
            String strB = B();
            if (strB == null) {
                strB = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB2 = ConnectionErrorMessages.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", strB2, 4));
                } else if (!strB2.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(strB2);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarA.h(strB);
        }
        Notification notificationC = eVarA.c();
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            i3 = 10436;
            GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, notificationC);
    }

    public final boolean A(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent pendingIntentP = p(context, connectionResult);
        if (pendingIntentP == null) {
            return false;
        }
        y(context, connectionResult.y(), null, GoogleApiActivity.a(context, pendingIntentP, i2));
        return true;
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public Intent d(Context context, int i2, String str) {
        return super.d(context, i2, str);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public PendingIntent e(Context context, int i2, int i3) {
        return super.e(context, i2, i3);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final String g(int i2) {
        return super.g(i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @HideFirstParty
    public int i(Context context) {
        return super.i(context);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    @ShowFirstParty
    @KeepForSdk
    public int j(Context context, int i2) {
        return super.j(context, i2);
    }

    @Override // com.google.android.gms.common.GoogleApiAvailabilityLight
    public final boolean m(int i2) {
        return super.m(i2);
    }

    public Dialog n(Activity activity, int i2, int i3) {
        return o(activity, i2, i3, null);
    }

    public Dialog o(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return u(activity, i2, DialogRedirect.a(activity, d(activity, i2, "d"), i3), onCancelListener);
    }

    public PendingIntent p(Context context, ConnectionResult connectionResult) {
        return connectionResult.Y() ? connectionResult.W() : e(context, connectionResult.y(), 0);
    }

    public boolean r(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogO = o(activity, i2, i3, onCancelListener);
        if (dialogO == null) {
            return false;
        }
        w(activity, dialogO, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public void s(Context context, int i2) {
        y(context, i2, null, f(context, i2, 0, "n"));
    }

    public final zabq v(Context context, zabr zabrVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(Constants.PACKAGE);
        zabq zabqVar = new zabq(zabrVar);
        context.registerReceiver(zabqVar, intentFilter);
        zabqVar.b(context);
        if (l(context, "com.google.android.gms")) {
            return zabqVar;
        }
        zabrVar.a();
        zabqVar.a();
        return null;
    }

    final void x(Context context) {
        new a(context).sendEmptyMessageDelayed(1, LocalNotificationSyncManager.TWO_MINUTES);
    }

    public final boolean z(Activity activity, LifecycleFragment lifecycleFragment, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogU = u(activity, i2, DialogRedirect.c(lifecycleFragment, d(activity, i2, "d"), 2), onCancelListener);
        if (dialogU == null) {
            return false;
        }
        w(activity, dialogU, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
