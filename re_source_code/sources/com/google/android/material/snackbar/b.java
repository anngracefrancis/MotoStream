package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    private static b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18758b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f18759c = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f18760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f18761e;

    /* JADX INFO: compiled from: SnackbarManager.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SnackbarManager.java */
    interface InterfaceC0201b {
        void a(int i2);

        void show();
    }

    /* JADX INFO: compiled from: SnackbarManager.java */
    private static class c {
        final WeakReference<InterfaceC0201b> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f18764c;

        c(int i2, InterfaceC0201b interfaceC0201b) {
            this.a = new WeakReference<>(interfaceC0201b);
            this.f18763b = i2;
        }

        boolean a(InterfaceC0201b interfaceC0201b) {
            return interfaceC0201b != null && this.a.get() == interfaceC0201b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i2) {
        InterfaceC0201b interfaceC0201b = cVar.a.get();
        if (interfaceC0201b == null) {
            return false;
        }
        this.f18759c.removeCallbacksAndMessages(cVar);
        interfaceC0201b.a(i2);
        return true;
    }

    static b c() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private boolean f(InterfaceC0201b interfaceC0201b) {
        c cVar = this.f18760d;
        return cVar != null && cVar.a(interfaceC0201b);
    }

    private boolean g(InterfaceC0201b interfaceC0201b) {
        c cVar = this.f18761e;
        return cVar != null && cVar.a(interfaceC0201b);
    }

    private void l(c cVar) {
        int i2 = cVar.f18763b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : 2750;
        }
        this.f18759c.removeCallbacksAndMessages(cVar);
        Handler handler = this.f18759c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    private void n() {
        c cVar = this.f18761e;
        if (cVar != null) {
            this.f18760d = cVar;
            this.f18761e = null;
            InterfaceC0201b interfaceC0201b = cVar.a.get();
            if (interfaceC0201b != null) {
                interfaceC0201b.show();
            } else {
                this.f18760d = null;
            }
        }
    }

    public void b(InterfaceC0201b interfaceC0201b, int i2) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                a(this.f18760d, i2);
            } else if (g(interfaceC0201b)) {
                a(this.f18761e, i2);
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f18758b) {
            if (this.f18760d == cVar || this.f18761e == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0201b interfaceC0201b) {
        boolean z;
        synchronized (this.f18758b) {
            z = f(interfaceC0201b) || g(interfaceC0201b);
        }
        return z;
    }

    public void h(InterfaceC0201b interfaceC0201b) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                this.f18760d = null;
                if (this.f18761e != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0201b interfaceC0201b) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                l(this.f18760d);
            }
        }
    }

    public void j(InterfaceC0201b interfaceC0201b) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                c cVar = this.f18760d;
                if (!cVar.f18764c) {
                    cVar.f18764c = true;
                    this.f18759c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(InterfaceC0201b interfaceC0201b) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                c cVar = this.f18760d;
                if (cVar.f18764c) {
                    cVar.f18764c = false;
                    l(cVar);
                }
            }
        }
    }

    public void m(int i2, InterfaceC0201b interfaceC0201b) {
        synchronized (this.f18758b) {
            if (f(interfaceC0201b)) {
                c cVar = this.f18760d;
                cVar.f18763b = i2;
                this.f18759c.removeCallbacksAndMessages(cVar);
                l(this.f18760d);
                return;
            }
            if (g(interfaceC0201b)) {
                this.f18761e.f18763b = i2;
            } else {
                this.f18761e = new c(i2, interfaceC0201b);
            }
            c cVar2 = this.f18760d;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f18760d = null;
                n();
            }
        }
    }
}
