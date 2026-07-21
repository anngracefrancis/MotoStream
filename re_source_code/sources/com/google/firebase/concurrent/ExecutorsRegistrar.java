package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.b0;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final com.google.firebase.components.x<ScheduledExecutorService> a = new com.google.firebase.components.x<>(new com.google.firebase.s.b() { // from class: com.google.firebase.concurrent.t
        @Override // com.google.firebase.s.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.c("Firebase Background", 10, ExecutorsRegistrar.a())));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final com.google.firebase.components.x<ScheduledExecutorService> f18923b = new com.google.firebase.components.x<>(new com.google.firebase.s.b() { // from class: com.google.firebase.concurrent.q
        @Override // com.google.firebase.s.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.c("Firebase Lite", 0, ExecutorsRegistrar.l())));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final com.google.firebase.components.x<ScheduledExecutorService> f18924c = new com.google.firebase.components.x<>(new com.google.firebase.s.b() { // from class: com.google.firebase.concurrent.p
        @Override // com.google.firebase.s.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.b("Firebase Blocking", 11)));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final com.google.firebase.components.x<ScheduledExecutorService> f18925d = new com.google.firebase.components.x<>(new com.google.firebase.s.b() { // from class: com.google.firebase.concurrent.o
        @Override // com.google.firebase.s.b
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.b("Firebase Scheduler", 0));
        }
    });

    private static StrictMode.ThreadPolicy a() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            builderDetectNetwork.detectResourceMismatches();
            if (i2 >= 26) {
                builderDetectNetwork.detectUnbufferedIo();
            }
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    private static ThreadFactory b(String str, int i2) {
        return new v(str, i2, null);
    }

    private static ThreadFactory c(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return new v(str, i2, threadPolicy);
    }

    private static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new w(executorService, f18925d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<com.google.firebase.components.n<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.n.b(b0.a(com.google.firebase.o.a.a.class, ScheduledExecutorService.class), b0.a(com.google.firebase.o.a.a.class, ExecutorService.class), b0.a(com.google.firebase.o.a.a.class, Executor.class)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.concurrent.u
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                return ExecutorsRegistrar.a.get();
            }
        }).d(), com.google.firebase.components.n.b(b0.a(com.google.firebase.o.a.b.class, ScheduledExecutorService.class), b0.a(com.google.firebase.o.a.b.class, ExecutorService.class), b0.a(com.google.firebase.o.a.b.class, Executor.class)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.concurrent.n
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                return ExecutorsRegistrar.f18924c.get();
            }
        }).d(), com.google.firebase.components.n.b(b0.a(com.google.firebase.o.a.c.class, ScheduledExecutorService.class), b0.a(com.google.firebase.o.a.c.class, ExecutorService.class), b0.a(com.google.firebase.o.a.c.class, Executor.class)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.concurrent.s
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                return ExecutorsRegistrar.f18923b.get();
            }
        }).d(), com.google.firebase.components.n.a(b0.a(com.google.firebase.o.a.d.class, Executor.class)).f(new com.google.firebase.components.r() { // from class: com.google.firebase.concurrent.r
            @Override // com.google.firebase.components.r
            public final Object a(com.google.firebase.components.p pVar) {
                return a0.INSTANCE;
            }
        }).d());
    }
}
