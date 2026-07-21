package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzta {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f16751e;

    private zzta(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.a = list;
        this.f16748b = i2;
        this.f16749c = i3;
        this.f16750d = i4;
        this.f16751e = f2;
    }

    public static zzta a(zzst zzstVar) throws zzlm {
        int i2;
        int i3;
        float f2;
        try {
            zzstVar.l(4);
            int iG = (zzstVar.g() & 3) + 1;
            if (iG == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iG2 = zzstVar.g() & 31;
            for (int i4 = 0; i4 < iG2; i4++) {
                arrayList.add(b(zzstVar));
            }
            int iG3 = zzstVar.g();
            for (int i5 = 0; i5 < iG3; i5++) {
                arrayList.add(b(zzstVar));
            }
            if (iG2 > 0) {
                zzsr zzsrVarA = zzsq.a((byte[]) arrayList.get(0), iG, ((byte[]) arrayList.get(0)).length);
                int i6 = zzsrVarA.f16720b;
                int i7 = zzsrVarA.f16721c;
                f2 = zzsrVarA.f16722d;
                i2 = i6;
                i3 = i7;
            } else {
                i2 = -1;
                i3 = -1;
                f2 = 1.0f;
            }
            return new zzta(arrayList, iG, i2, i3, f2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzlm("Error parsing AVC config", e2);
        }
    }

    private static byte[] b(zzst zzstVar) {
        int iH = zzstVar.h();
        int iB = zzstVar.b();
        zzstVar.l(iH);
        return zzsl.b(zzstVar.a, iB, iH);
    }
}
