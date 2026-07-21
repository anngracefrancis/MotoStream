package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsc extends zzsb {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, List<String>> f16710i;

    public zzsc(int i2, Map<String, List<String>> map, zzry zzryVar) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i2);
        super(sb.toString(), zzryVar, 1);
        this.f16709h = i2;
        this.f16710i = map;
    }
}
