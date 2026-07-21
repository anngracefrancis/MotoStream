package com.google.android.gms.internal.ads;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzyu extends zzzz {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f17013h = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Random f17011f = new Random();

    public zzyu() {
        h7();
    }

    @Override // com.google.android.gms.internal.ads.zzzy
    public final long getValue() {
        return this.f17012g;
    }

    public final void h7() {
        synchronized (this.f17013h) {
            int i2 = 3;
            long jNextInt = 0;
            while (true) {
                i2--;
                if (i2 <= 0) {
                    break;
                }
                jNextInt = ((long) this.f17011f.nextInt()) + 2147483648L;
                if (jNextInt != this.f17012g && jNextInt != 0) {
                    break;
                }
            }
            this.f17012g = jNextInt;
        }
    }
}
