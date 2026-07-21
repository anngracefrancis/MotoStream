package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReedSolomonEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f20320b;

    public c(a aVar) {
        this.a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f20320b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i2) {
        if (i2 >= this.f20320b.size()) {
            List<b> list = this.f20320b;
            b bVarG = list.get(list.size() - 1);
            for (int size = this.f20320b.size(); size <= i2; size++) {
                a aVar = this.a;
                bVarG = bVarG.g(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f20320b.add(bVarG);
            }
        }
        return this.f20320b.get(i2);
    }

    public void b(int[] iArr, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i2;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i2);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrD = new b(this.a, iArr2).h(i2, 1).b(bVarA)[1].d();
        int length2 = i2 - iArrD.length;
        for (int i3 = 0; i3 < length2; i3++) {
            iArr[length + i3] = 0;
        }
        System.arraycopy(iArrD, 0, iArr, length + length2, iArrD.length);
    }
}
