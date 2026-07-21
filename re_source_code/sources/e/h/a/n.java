package e.h.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadServiceSharedTransmit.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements u, com.liulishuo.filedownloader.services.e.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Class<?> f21377f = FileDownloadService.SharedMainProcessService.class;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21378g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList<Runnable> f21379h = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.liulishuo.filedownloader.services.e f21380i;

    n() {
    }

    @Override // e.h.a.u
    public byte Q(int i2) {
        return !isConnected() ? e.h.a.k0.a.b(i2) : this.f21380i.Q(i2);
    }

    @Override // e.h.a.u
    public boolean S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        if (!isConnected()) {
            return e.h.a.k0.a.e(str, str2, z);
        }
        this.f21380i.S(str, str2, z, i2, i3, i4, z2, fileDownloadHeader, z3);
        return true;
    }

    @Override // com.liulishuo.filedownloader.services.e.a
    public void a(com.liulishuo.filedownloader.services.e eVar) {
        this.f21380i = eVar;
        List list = (List) this.f21379h.clone();
        this.f21379h.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.e().b(new e.h.a.h0.b(e.h.a.h0.b.a.connected, f21377f));
    }

    @Override // e.h.a.u
    public boolean a0(int i2) {
        return !isConnected() ? e.h.a.k0.a.d(i2) : this.f21380i.a0(i2);
    }

    public void b(Context context, Runnable runnable) {
        if (runnable != null && !this.f21379h.contains(runnable)) {
            this.f21379h.add(runnable);
        }
        Intent intent = new Intent(context, f21377f);
        boolean zP = e.h.a.k0.f.P(context);
        this.f21378g = zP;
        intent.putExtra("is_foreground", zP);
        if (!this.f21378g) {
            context.startService(intent);
            return;
        }
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "start foreground service", new Object[0]);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        }
    }

    @Override // e.h.a.u
    public boolean isConnected() {
        return this.f21380i != null;
    }

    @Override // e.h.a.u
    public boolean o0(int i2) {
        return !isConnected() ? e.h.a.k0.a.a(i2) : this.f21380i.o0(i2);
    }

    @Override // e.h.a.u
    public void t0(boolean z) {
        if (!isConnected()) {
            e.h.a.k0.a.f(z);
        } else {
            this.f21380i.t0(z);
            this.f21378g = false;
        }
    }

    @Override // e.h.a.u
    public void u0(Context context) {
        b(context, null);
    }

    @Override // e.h.a.u
    public boolean v0() {
        return this.f21378g;
    }
}
