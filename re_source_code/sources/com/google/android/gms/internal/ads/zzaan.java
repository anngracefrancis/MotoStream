package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaan implements MuteThisAdReason {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzaak f13730b;

    public zzaan(zzaak zzaakVar) {
        String description;
        this.f13730b = zzaakVar;
        try {
            description = zzaakVar.getDescription();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            description = null;
        }
        this.a = description;
    }

    public final zzaak a() {
        return this.f13730b;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.a;
    }
}
