package e.h.a.f0;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadDatabase.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: e.h.a.f0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileDownloadDatabase.java */
    public interface InterfaceC0272a extends Iterable<FileDownloadModel> {
        void K(FileDownloadModel fileDownloadModel);

        void T(FileDownloadModel fileDownloadModel);

        void T0();

        void f0(int i2, FileDownloadModel fileDownloadModel);
    }

    void a(int i2);

    InterfaceC0272a b();

    void c(int i2, Throwable th);

    void clear();

    void d(int i2, long j2);

    void e(int i2, String str, long j2, long j3, int i3);

    void f(int i2, int i3, long j2);

    void g(com.liulishuo.filedownloader.model.a aVar);

    void h(int i2);

    void i(int i2);

    void j(FileDownloadModel fileDownloadModel);

    void k(int i2, Throwable th, long j2);

    void l(int i2, long j2);

    void m(int i2, long j2, String str, String str2);

    List<com.liulishuo.filedownloader.model.a> n(int i2);

    FileDownloadModel o(int i2);

    void p(int i2, int i3);

    void q(int i2, long j2);

    boolean remove(int i2);
}
