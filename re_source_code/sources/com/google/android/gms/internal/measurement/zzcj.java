package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcj {
    private static volatile zzcy<Boolean> a = zzcy.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f17343b = new Object();

    private static boolean a(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean b(Context context, Uri uri) {
        ProviderInfo providerInfoResolveContentProvider;
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (a.b()) {
            return a.c().booleanValue();
        }
        synchronized (f17343b) {
            if (a.b()) {
                return a.c().booleanValue();
            }
            if (("com.google.android.gms".equals(context.getPackageName()) || ((providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName))) && a(context)) {
                z = true;
            }
            a = zzcy.a(Boolean.valueOf(z));
            return a.c().booleanValue();
        }
    }
}
