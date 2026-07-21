package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhx extends zzhw {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<UUID, byte[]> f16297b;

    public zzhx(String str) {
        super(str);
        this.f16297b = new HashMap();
    }

    public final void a(Map<UUID, byte[]> map) {
        this.f16297b.putAll(map);
    }
}
