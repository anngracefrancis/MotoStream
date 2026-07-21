package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdrw {
    protected volatile int a = -1;

    public static final byte[] b(zzdrw zzdrwVar) {
        int iC = zzdrwVar.c();
        byte[] bArr = new byte[iC];
        try {
            zzdrp zzdrpVarV = zzdrp.v(bArr, 0, iC);
            zzdrwVar.a(zzdrpVarV);
            zzdrpVarV.f();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void a(zzdrp zzdrpVar) throws IOException {
    }

    public final int c() {
        int iE = e();
        this.a = iE;
        return iE;
    }

    @Override // 
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public zzdrw clone() throws CloneNotSupportedException {
        return (zzdrw) super.clone();
    }

    protected int e() {
        return 0;
    }

    public String toString() {
        return zzdrx.b(this);
    }
}
