package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class wt extends tt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ut f13521b = new ut();

    wt() {
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> listA = this.f13521b.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            for (Throwable th2 : listA) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final void b(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.f13521b.a(th, true).add(th2);
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final void c(Throwable th) {
        th.printStackTrace();
        List<Throwable> listA = this.f13521b.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            for (Throwable th2 : listA) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
