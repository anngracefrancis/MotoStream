package e.h.a;

import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: compiled from: ITaskHunter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface x extends r {

    /* JADX INFO: compiled from: ITaskHunter.java */
    public interface a {
        boolean a(MessageSnapshot messageSnapshot);

        t f();

        boolean i(MessageSnapshot messageSnapshot);

        MessageSnapshot l(Throwable th);

        boolean n(MessageSnapshot messageSnapshot);

        boolean p(MessageSnapshot messageSnapshot);
    }

    /* JADX INFO: compiled from: ITaskHunter.java */
    public interface b {
        boolean r(i iVar);

        void start();
    }

    void b();

    int d();

    Throwable e();

    byte getStatus();

    boolean h();

    void j();

    long k();

    long m();

    boolean pause();
}
