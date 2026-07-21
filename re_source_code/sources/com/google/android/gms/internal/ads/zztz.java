package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zztz {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Object, Object> f16781b = new WeakHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Object> f16782c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f16783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbai f16784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzakh f16785f;

    public zztz(Context context, zzbai zzbaiVar) {
        this.f16783d = context.getApplicationContext();
        this.f16784e = zzbaiVar;
        this.f16785f = new zzakh(context.getApplicationContext(), zzbaiVar, (String) zzyt.e().c(zzacu.f13800d));
    }
}
