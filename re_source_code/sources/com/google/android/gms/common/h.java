package com.google.android.gms.common;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f11924g;

    h(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f11924g = bArr;
    }

    @Override // com.google.android.gms.common.g
    final byte[] E0() {
        return this.f11924g;
    }
}
