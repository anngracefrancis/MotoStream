package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class x2 {
    private static final /* synthetic */ int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f13544b;

    static {
        int[] iArr = new int[e.e.a.a.values().length];
        f13544b = iArr;
        try {
            iArr[e.e.a.a.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13544b[e.e.a.a.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f13544b[e.e.a.a.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f13544b[e.e.a.a.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[e.e.a.b.values().length];
        a = iArr2;
        try {
            iArr2[e.e.a.b.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[e.e.a.b.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[e.e.a.b.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
