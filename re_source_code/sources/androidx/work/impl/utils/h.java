package androidx.work.impl.utils;

import androidx.work.WorkerParameters;

/* JADX INFO: compiled from: StartWorkRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private androidx.work.impl.j f2576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WorkerParameters.a f2578h;

    public h(androidx.work.impl.j jVar, String str, WorkerParameters.a aVar) {
        this.f2576f = jVar;
        this.f2577g = str;
        this.f2578h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2576f.r().k(this.f2577g, this.f2578h);
    }
}
