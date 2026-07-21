package com.bumptech.glide.r;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static final Executor a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f9548b = new b();

    /* JADX INFO: compiled from: Executors.java */
    class a implements Executor {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Handler f9549f = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f9549f.post(runnable);
        }
    }

    /* JADX INFO: compiled from: Executors.java */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f9548b;
    }

    public static Executor b() {
        return a;
    }
}
