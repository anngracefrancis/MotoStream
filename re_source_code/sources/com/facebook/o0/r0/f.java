package com.facebook.o0.r0;

import kotlin.collections.n;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: MTensor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f10444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f10446d;

    /* JADX INFO: compiled from: MTensor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int[] iArr) {
            int i2 = 1;
            if (iArr.length == 0) {
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }
            int i3 = iArr[0];
            int iZ = n.z(iArr);
            if (1 <= iZ) {
                while (true) {
                    i3 *= iArr[i2];
                    if (i2 == iZ) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
    }

    public f(int[] iArr) {
        m.f(iArr, "shape");
        this.f10444b = iArr;
        int iB = a.b(iArr);
        this.f10445c = iB;
        this.f10446d = new float[iB];
    }

    public final float[] a() {
        return this.f10446d;
    }

    public final int b(int i2) {
        return this.f10444b[i2];
    }

    public final int c() {
        return this.f10444b.length;
    }

    public final void d(int[] iArr) {
        m.f(iArr, "shape");
        this.f10444b = iArr;
        int iB = a.b(iArr);
        float[] fArr = new float[iB];
        System.arraycopy(this.f10446d, 0, fArr, 0, Math.min(this.f10445c, iB));
        this.f10446d = fArr;
        this.f10445c = iB;
    }
}
