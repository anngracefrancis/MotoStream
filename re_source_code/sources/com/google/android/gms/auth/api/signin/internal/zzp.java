package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public final class zzp {
    private static zzp a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private Storage f11544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInAccount f11545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private GoogleSignInOptions f11546d;

    private zzp(Context context) {
        Storage storageB = Storage.b(context);
        this.f11544b = storageB;
        this.f11545c = storageB.c();
        this.f11546d = this.f11544b.d();
    }

    public static synchronized zzp c(Context context) {
        return d(context.getApplicationContext());
    }

    private static synchronized zzp d(Context context) {
        if (a == null) {
            a = new zzp(context);
        }
        return a;
    }

    public final synchronized void a() {
        this.f11544b.a();
        this.f11545c = null;
        this.f11546d = null;
    }

    public final synchronized void b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f11544b.f(googleSignInAccount, googleSignInOptions);
        this.f11545c = googleSignInAccount;
        this.f11546d = googleSignInOptions;
    }
}
