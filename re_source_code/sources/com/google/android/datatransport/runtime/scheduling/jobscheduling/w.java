package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import e.e.b.a.i.b0.j.j0;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class w {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f11371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y f11372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f11373d;

    @Inject
    w(Executor executor, j0 j0Var, y yVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.a = executor;
        this.f11371b = j0Var;
        this.f11372c = yVar;
        this.f11373d = aVar;
    }

    private /* synthetic */ Object b() {
        Iterator<e.e.b.a.i.q> it = this.f11371b.U().iterator();
        while (it.hasNext()) {
            this.f11372c.a(it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        this.f11373d.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.m
            @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
            public final Object execute() {
                this.a.c();
                return null;
            }
        });
    }

    public void a() {
        this.a.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f11338f.e();
            }
        });
    }

    public /* synthetic */ Object c() {
        b();
        return null;
    }
}
