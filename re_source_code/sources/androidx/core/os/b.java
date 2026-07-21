package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;

/* JADX INFO: compiled from: CancellationSignal.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f988d;

    /* JADX INFO: compiled from: CancellationSignal.java */
    public interface a {
        void onCancel();
    }

    private void d() {
        while (this.f988d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.f988d = true;
            a aVar = this.f986b;
            Object obj = this.f987c;
            if (aVar != null) {
                try {
                    aVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f988d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f988d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void c(a aVar) {
        synchronized (this) {
            d();
            if (this.f986b == aVar) {
                return;
            }
            this.f986b = aVar;
            if (this.a && aVar != null) {
                aVar.onCancel();
            }
        }
    }
}
