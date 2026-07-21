package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static GoogleServices f11729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Status f11731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11733f;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.a));
        boolean z = true;
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z2 = integer == 0;
            z = integer != 0;
            this.f11733f = z2;
        } else {
            this.f11733f = false;
        }
        this.f11732e = z;
        String strB = zzag.b(context);
        strB = strB == null ? new StringResourceValueReader(context).a("google_app_id") : strB;
        if (TextUtils.isEmpty(strB)) {
            this.f11731d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f11730c = null;
        } else {
            this.f11730c = strB;
            this.f11731d = Status.f11688g;
        }
    }

    @KeepForSdk
    private static GoogleServices a(String str) {
        GoogleServices googleServices;
        synchronized (a) {
            googleServices = f11729b;
            if (googleServices == null) {
                throw new IllegalStateException("Initialize must be called before " + str + ".");
            }
        }
        return googleServices;
    }

    @KeepForSdk
    public static String b() {
        return a("getGoogleAppId").f11730c;
    }

    @KeepForSdk
    public static Status c(Context context) {
        Status status;
        Preconditions.l(context, "Context must not be null.");
        synchronized (a) {
            if (f11729b == null) {
                f11729b = new GoogleServices(context);
            }
            status = f11729b.f11731d;
        }
        return status;
    }

    @KeepForSdk
    public static boolean d() {
        return a("isMeasurementExplicitlyDisabled").f11733f;
    }
}
