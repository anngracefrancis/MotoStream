package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
final class qt extends ThreadLocal<SecureRandom> {
    qt() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        return zzdlo.a();
    }
}
