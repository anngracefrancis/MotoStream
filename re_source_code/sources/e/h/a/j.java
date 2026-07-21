package e.h.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FileDownloadMessageStation.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final Executor a = e.h.a.k0.b.a(5, "BlockCompleted");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f21348b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static int f21349c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f21350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedBlockingQueue<t> f21351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f21352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<t> f21353g;

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f21354f;

        a(t tVar) {
            this.f21354f = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21354f.m();
        }
    }

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    private static final class b {
        private static final j a = new j(null);
    }

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    private static class c implements Handler.Callback {
        private c() {
        }

        private void a(ArrayList<t> arrayList) {
            for (t tVar : arrayList) {
                if (!j.f(tVar)) {
                    tVar.m();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                ((t) message.obj).m();
            } else if (i2 == 2) {
                a((ArrayList) message.obj);
                j.d().h();
            }
            return true;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    private void c(t tVar) {
        synchronized (this.f21352f) {
            this.f21351e.offer(tVar);
        }
        h();
    }

    public static j d() {
        return b.a;
    }

    private void e(t tVar) {
        Handler handler = this.f21350d;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(t tVar) {
        if (!tVar.j()) {
            return false;
        }
        a.execute(new a(tVar));
        return true;
    }

    public static boolean g() {
        return f21348b > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this.f21352f) {
            if (this.f21353g.isEmpty()) {
                if (this.f21351e.isEmpty()) {
                    return;
                }
                int i2 = 0;
                if (g()) {
                    int i3 = f21348b;
                    int iMin = Math.min(this.f21351e.size(), f21349c);
                    while (i2 < iMin) {
                        this.f21353g.add(this.f21351e.remove());
                        i2++;
                    }
                    i2 = i3;
                } else {
                    this.f21351e.drainTo(this.f21353g);
                }
                Handler handler = this.f21350d;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f21353g), i2);
            }
        }
    }

    void i(t tVar) {
        j(tVar, false);
    }

    void j(t tVar, boolean z) {
        if (tVar.a()) {
            tVar.m();
            return;
        }
        if (f(tVar)) {
            return;
        }
        if (!g() && !this.f21351e.isEmpty()) {
            synchronized (this.f21352f) {
                if (!this.f21351e.isEmpty()) {
                    Iterator<t> it = this.f21351e.iterator();
                    while (it.hasNext()) {
                        e(it.next());
                    }
                }
                this.f21351e.clear();
            }
        }
        if (!g() || z) {
            e(tVar);
        } else {
            c(tVar);
        }
    }

    private j() {
        this.f21352f = new Object();
        this.f21353g = new ArrayList<>();
        this.f21350d = new Handler(Looper.getMainLooper(), new c(null));
        this.f21351e = new LinkedBlockingQueue<>();
    }
}
