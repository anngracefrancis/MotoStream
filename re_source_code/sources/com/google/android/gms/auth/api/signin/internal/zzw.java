package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes2.dex */
public final class zzw extends zzr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f11547f;

    public zzw(Context context) {
        this.f11547f = context;
    }

    private final void P() {
        if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.f11547f, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    public final void O() {
        P();
        zzp.c(this.f11547f).a();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    public final void v() {
        P();
        Storage storageB = Storage.b(this.f11547f);
        GoogleSignInAccount googleSignInAccountC = storageB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f11509k;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = storageB.d();
        }
        GoogleApiClient googleApiClientE = new GoogleApiClient.Builder(this.f11547f).b(Auth.f11405g, googleSignInOptionsD).e();
        try {
            if (googleApiClientE.d().e0()) {
                if (googleSignInAccountC != null) {
                    Auth.f11408j.c(googleApiClientE);
                } else {
                    googleApiClientE.e();
                }
            }
        } finally {
            googleApiClientE.h();
        }
    }
}
