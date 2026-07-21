package e.h.a;

import android.content.Context;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* JADX INFO: compiled from: FileDownloadServiceProxy.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u f21376f;

    /* JADX INFO: compiled from: FileDownloadServiceProxy.java */
    private static final class b {
        private static final m a = new m();
    }

    public static com.liulishuo.filedownloader.services.e.a a() {
        if (b().f21376f instanceof n) {
            return (com.liulishuo.filedownloader.services.e.a) b().f21376f;
        }
        return null;
    }

    public static m b() {
        return b.a;
    }

    @Override // e.h.a.u
    public byte Q(int i2) {
        return this.f21376f.Q(i2);
    }

    @Override // e.h.a.u
    public boolean S(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        return this.f21376f.S(str, str2, z, i2, i3, i4, z2, fileDownloadHeader, z3);
    }

    @Override // e.h.a.u
    public boolean a0(int i2) {
        return this.f21376f.a0(i2);
    }

    @Override // e.h.a.u
    public boolean isConnected() {
        return this.f21376f.isConnected();
    }

    @Override // e.h.a.u
    public boolean o0(int i2) {
        return this.f21376f.o0(i2);
    }

    @Override // e.h.a.u
    public void t0(boolean z) {
        this.f21376f.t0(z);
    }

    @Override // e.h.a.u
    public void u0(Context context) {
        this.f21376f.u0(context);
    }

    @Override // e.h.a.u
    public boolean v0() {
        return this.f21376f.v0();
    }

    private m() {
        this.f21376f = e.h.a.k0.e.a().f21366d ? new n() : new o();
    }
}
