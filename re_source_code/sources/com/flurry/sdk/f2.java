package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f2 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PrintStream f10740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PrintWriter f10741g;

    public abstract void a() throws Exception;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            if (this.f10740f != null) {
                th.printStackTrace(this.f10740f);
            } else {
                PrintWriter printWriter = this.f10741g;
                if (printWriter != null) {
                    th.printStackTrace(printWriter);
                } else {
                    th.printStackTrace();
                }
            }
            d1.d(6, "SafeRunnable", HttpUrl.FRAGMENT_ENCODE_SET, th);
            g0.a();
            g0.c("SafeRunnableException", "Exception caught by SafeRunnable", th);
        }
    }
}
