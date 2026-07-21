package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzws {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzwo f16883d;

    private zzws(zzwo zzwoVar, byte[] bArr) {
        this.f16883d = zzwoVar;
        this.a = bArr;
    }

    public final zzws a(int i2) {
        this.f16881b = i2;
        return this;
    }

    public final zzws b(int i2) {
        this.f16882c = i2;
        return this;
    }

    public final synchronized void c() {
        try {
            zzwo zzwoVar = this.f16883d;
            if (zzwoVar.f16880b) {
                zzwoVar.a.U0(this.a);
                this.f16883d.a.z3(this.f16881b);
                this.f16883d.a.a1(this.f16882c);
                this.f16883d.a.a3(null);
                this.f16883d.a.b6();
            }
        } catch (RemoteException e2) {
            zzbad.b("Clearcut log failed", e2);
        }
    }
}
