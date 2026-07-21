package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class s7 {
    static final /* synthetic */ int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f17951b;

    static {
        int[] iArr = new int[zzbj.zzd.zza.values().length];
        f17951b = iArr;
        try {
            iArr[zzbj.zzd.zza.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17951b[zzbj.zzd.zza.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17951b[zzbj.zzd.zza.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f17951b[zzbj.zzd.zza.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[zzbj.zzf.zzb.values().length];
        a = iArr2;
        try {
            iArr2[zzbj.zzf.zzb.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[zzbj.zzf.zzb.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[zzbj.zzf.zzb.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[zzbj.zzf.zzb.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[zzbj.zzf.zzb.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[zzbj.zzf.zzb.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
