package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public class zzcgm extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15208f;

    public zzcgm(int i2) {
        this.f15208f = i2;
    }

    public static int b(Throwable th) {
        if (th instanceof zzcgm) {
            return ((zzcgm) th).f15208f;
        }
        if (th instanceof zzayn) {
            return ((zzayn) th).a();
        }
        return 0;
    }

    public final int a() {
        return this.f15208f;
    }

    public zzcgm(String str, int i2) {
        super(str);
        this.f15208f = i2;
    }

    public zzcgm(String str, Throwable th, int i2) {
        super(str, th);
        this.f15208f = 0;
    }
}
