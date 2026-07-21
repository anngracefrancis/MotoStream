package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class n4 implements f7<j7> {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j7.a.g().length];
            a = iArr;
            try {
                iArr[j7.a.f10857h - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j7.a.f10856g - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j7.a.f10855f - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(j7 j7Var) {
        int i2 = a.a[j7Var.a - 1];
        if (i2 == 1) {
            m2.a().b(new q3(new r3()));
        } else if (i2 == 2) {
            j5.h(true);
        } else {
            if (i2 != 3) {
                return;
            }
            j5.h(false);
        }
    }
}
