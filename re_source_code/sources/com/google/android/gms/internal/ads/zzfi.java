package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class zzfi {
    private final zzdy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16215c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?>[] f16218f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16216d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Method f16217e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CountDownLatch f16219g = new CountDownLatch(1);

    public zzfi(zzdy zzdyVar, String str, String str2, Class<?>... clsArr) {
        this.a = zzdyVar;
        this.f16214b = str;
        this.f16215c = str2;
        this.f16218f = clsArr;
        zzdyVar.r().submit(new vy(this));
    }

    private final String b(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.a.t().b(bArr, str), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        try {
            Class clsLoadClass = this.a.s().loadClass(b(this.a.u(), this.f16214b));
            if (clsLoadClass == null) {
                this.f16219g.countDown();
                return;
            }
            this.f16217e = clsLoadClass.getMethod(b(this.a.u(), this.f16215c), this.f16218f);
            if (this.f16217e == null) {
                this.f16219g.countDown();
            } else {
                this.f16219g.countDown();
            }
        } catch (zzdk unused) {
            this.f16219g.countDown();
        } catch (UnsupportedEncodingException unused2) {
            this.f16219g.countDown();
        } catch (ClassNotFoundException unused3) {
            this.f16219g.countDown();
        } catch (NoSuchMethodException unused4) {
            this.f16219g.countDown();
        } catch (NullPointerException unused5) {
            this.f16219g.countDown();
        } catch (Throwable th) {
            this.f16219g.countDown();
            throw th;
        }
    }

    public final Method d() {
        if (this.f16217e != null) {
            return this.f16217e;
        }
        try {
            if (this.f16219g.await(2L, TimeUnit.SECONDS)) {
                return this.f16217e;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
