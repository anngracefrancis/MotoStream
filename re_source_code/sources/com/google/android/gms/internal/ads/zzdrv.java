package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdrv {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f16078b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f16079c = new Object();

    public static void a(zzdrr zzdrrVar, zzdrr zzdrrVar2) {
        zzdrt zzdrtVar = zzdrrVar.f16072b;
        if (zzdrtVar != null) {
            zzdrrVar2.f16072b = (zzdrt) zzdrtVar.clone();
        }
    }
}
