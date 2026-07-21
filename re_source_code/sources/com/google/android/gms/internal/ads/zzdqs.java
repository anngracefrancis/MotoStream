package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdqs extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f16051f;

    public zzdqs(zzdpk zzdpkVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f16051f = null;
    }

    public final zzdok a() {
        return new zzdok(getMessage());
    }
}
