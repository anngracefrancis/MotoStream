package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private int f11672f = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i2) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i2, true), 134217728);
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f11672f = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                GoogleApiManager googleApiManagerK = GoogleApiManager.k(this);
                if (i3 == -1) {
                    googleApiManagerK.A();
                } else if (i3 == 0) {
                    googleApiManagerK.f(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f11672f = 0;
            setResult(i3, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f11672f = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11672f = bundle.getInt("resolution");
        }
        if (this.f11672f != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else {
                if (pendingIntent == null) {
                    GoogleApiAvailability.q().r(this, num.intValue(), 2, this);
                    this.f11672f = 1;
                    return;
                }
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f11672f = 1;
                } catch (IntentSender.SendIntentException e2) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
                    finish();
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f11672f);
        super.onSaveInstanceState(bundle);
    }
}
