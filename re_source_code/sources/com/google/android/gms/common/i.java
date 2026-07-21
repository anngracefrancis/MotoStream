package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class i extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final WeakReference f11925g = new WeakReference(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference f11926h;

    i(byte[] bArr) {
        super(bArr);
        this.f11926h = f11925g;
    }

    @Override // com.google.android.gms.common.g
    final byte[] E0() {
        byte[] bArrE3;
        synchronized (this) {
            bArrE3 = (byte[]) this.f11926h.get();
            if (bArrE3 == null) {
                bArrE3 = E3();
                this.f11926h = new WeakReference(bArrE3);
            }
        }
        return bArrE3;
    }

    protected abstract byte[] E3();
}
