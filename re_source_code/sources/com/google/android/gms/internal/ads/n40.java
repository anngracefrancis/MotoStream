package com.google.android.gms.internal.ads;

import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class n40 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ m40 f13021f;

    n40(m40 m40Var) {
        this.f13021f = m40Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13021f.f12959h) {
            if (this.f13021f.f12960i && this.f13021f.f12961j) {
                m40.g(this.f13021f, false);
                zzbad.e("App went background");
                Iterator it = this.f13021f.f12962k.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzut) it.next()).a(false);
                    } catch (Exception e2) {
                        zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
                    }
                }
            } else {
                zzbad.e("App is still foreground");
            }
        }
    }
}
