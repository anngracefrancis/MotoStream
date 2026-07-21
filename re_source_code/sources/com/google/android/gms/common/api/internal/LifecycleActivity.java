package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class LifecycleActivity {
    private final Object a;

    public final Activity a() {
        return (Activity) this.a;
    }

    public final androidx.fragment.app.d b() {
        return (androidx.fragment.app.d) this.a;
    }

    public final boolean c() {
        return this.a instanceof Activity;
    }

    public final boolean d() {
        return this.a instanceof androidx.fragment.app.d;
    }
}
