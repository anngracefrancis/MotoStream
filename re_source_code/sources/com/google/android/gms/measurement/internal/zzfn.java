package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfn {
    private final zzfs a;

    public zzfn(zzfs zzfsVar) {
        Preconditions.k(zzfsVar);
        this.a = zzfsVar;
    }

    public static boolean b(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void a(Context context, Intent intent) {
        zzfx zzfxVarA = zzfx.a(context, null);
        zzet zzetVarH = zzfxVarA.h();
        if (intent == null) {
            zzetVarH.K().a("Receiver called with null intent");
            return;
        }
        zzfxVarA.G();
        String action = intent.getAction();
        zzetVarH.P().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzetVarH.P().a("Starting wakeful intent.");
            this.a.a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzfxVarA.g().z(new u3(this, zzfxVarA, zzetVarH));
            } catch (Exception e2) {
                zzetVarH.K().b("Install Referrer Reporter encountered a problem", e2);
            }
            BroadcastReceiver.PendingResult pendingResultB = this.a.b();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzetVarH.P().a("Install referrer extras are null");
                if (pendingResultB != null) {
                    pendingResultB.finish();
                    return;
                }
                return;
            }
            zzetVarH.N().b("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                stringExtra = stringExtra.length() != 0 ? "?".concat(stringExtra) : new String("?");
            }
            Bundle bundleY = zzfxVarA.I().y(Uri.parse(stringExtra));
            if (bundleY == null) {
                zzetVarH.P().a("No campaign defined in install referrer broadcast");
                if (pendingResultB != null) {
                    pendingResultB.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000;
            if (longExtra == 0) {
                zzetVarH.K().a("Install referrer is missing timestamp");
            }
            zzfxVarA.g().z(new t3(this, zzfxVarA, longExtra, bundleY, context, zzetVarH, pendingResultB));
        }
    }
}
