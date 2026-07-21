package com.google.firebase.crashlytics.internal.n;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Task<Void> f19089b = Tasks.e(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f19090c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Boolean> f19091d = new ThreadLocal<>();

    /* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f19091d.set(Boolean.TRUE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
    class b<T> implements Continuation<Void, T> {
        final /* synthetic */ Callable a;

        b(Callable callable) {
            this.a = callable;
        }

        @Override // com.google.android.gms.tasks.Continuation
        public T a(Task<Void> task) throws Exception {
            return (T) this.a.call();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
    class c<T> implements Continuation<T, Void> {
        c() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(Task<T> task) throws Exception {
            return null;
        }
    }

    public w(Executor executor) {
        this.a = executor;
        executor.execute(new a());
    }

    private <T> Task<Void> d(Task<T> task) {
        return task.g(this.a, new c());
    }

    private boolean e() {
        return Boolean.TRUE.equals(this.f19091d.get());
    }

    private <T> Continuation<Void, T> f(Callable<T> callable) {
        return new b(callable);
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.a;
    }

    public <T> Task<T> g(Callable<T> callable) {
        Task<T> taskG;
        synchronized (this.f19090c) {
            taskG = this.f19089b.g(this.a, f(callable));
            this.f19089b = d(taskG);
        }
        return taskG;
    }

    public <T> Task<T> h(Callable<Task<T>> callable) {
        Task<T> taskH;
        synchronized (this.f19090c) {
            taskH = this.f19089b.h(this.a, f(callable));
            this.f19089b = d(taskH);
        }
        return taskH;
    }
}
