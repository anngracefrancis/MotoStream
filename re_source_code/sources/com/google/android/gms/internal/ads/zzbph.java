package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbph {
    public final List<? extends zzbbh<? extends zzbpc>> a;

    public zzbph(List<? extends zzbbh<? extends zzbpc>> list) {
        this.a = list;
    }

    public static zzcjv<zzbph> a(zzcjv<? extends zzbpc> zzcjvVar) {
        return new zzcjw(zzcjvVar, gd.a);
    }

    public static zzcjv<zzbph> b(zzclw<? extends zzbpc> zzclwVar) {
        return new zzcjw(zzclwVar, fd.a);
    }

    public zzbph(zzbpc zzbpcVar) {
        this.a = Collections.singletonList(zzbar.o(zzbpcVar));
    }
}
