package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjy extends zzjx {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, List<String>> f16386h;

    public zzjy(int i2, Map<String, List<String>> map, zzjq zzjqVar) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i2);
        super(sb.toString(), zzjqVar);
        this.f16385g = i2;
        this.f16386h = map;
    }
}
