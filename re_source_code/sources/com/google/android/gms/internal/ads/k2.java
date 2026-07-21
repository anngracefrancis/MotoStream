package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class k2 implements Comparator<byte[]> {
    k2() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}
