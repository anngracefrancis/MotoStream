package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzada {
    public static void a(zzacy zzacyVar, zzacx zzacxVar) {
        if (zzacxVar.a() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzacxVar.b())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzacyVar.b(zzacxVar.a(), zzacxVar.b(), zzacxVar.c(), zzacxVar.d());
    }
}
