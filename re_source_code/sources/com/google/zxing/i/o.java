package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: UPCAWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements com.google.zxing.e {
    private final j a = new j();

    @Override // com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.UPC_A) {
            return this.a.a("0".concat(String.valueOf(str)), com.google.zxing.a.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
