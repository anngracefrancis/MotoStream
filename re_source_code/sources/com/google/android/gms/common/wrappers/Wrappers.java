package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class Wrappers {
    private static Wrappers a = new Wrappers();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PackageManagerWrapper f12172b = null;

    @KeepForSdk
    public static PackageManagerWrapper a(Context context) {
        return a.b(context);
    }

    @VisibleForTesting
    public final synchronized PackageManagerWrapper b(Context context) {
        if (this.f12172b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f12172b = new PackageManagerWrapper(context);
        }
        return this.f12172b;
    }
}
