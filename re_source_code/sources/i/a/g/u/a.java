package i.a.g.u;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NamedThreadFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ThreadFactory f21915f = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f21916g;

    public a(String str) {
        this.f21916g = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f21915f.newThread(runnable);
        threadNewThread.setName(this.f21916g + ' ' + threadNewThread.getName());
        return threadNewThread;
    }
}
