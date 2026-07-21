package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzalr {

    @VisibleForTesting
    private static final zzayp<zzajw> a = new e2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private static final zzayp<zzajw> f13957b = new f2();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzakh f13958c;

    public zzalr(Context context, zzbai zzbaiVar, String str) {
        this.f13958c = new zzakh(context, zzbaiVar, str, a, f13957b);
    }

    public final <I, O> zzalj<I, O> a(String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        return new zzalu(this.f13958c, str, zzalmVar, zzallVar);
    }

    public final zzaly b() {
        return new zzaly(this.f13958c);
    }
}
