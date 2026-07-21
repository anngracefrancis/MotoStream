package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: CustomTabPrefetchHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends c.c.b.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static c.c.b.b f10021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static c.c.b.e f10022h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10020f = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ReentrantLock f10023i = new ReentrantLock();

    /* JADX INFO: compiled from: CustomTabPrefetchHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            c.c.b.b bVar;
            q.f10023i.lock();
            if (q.f10022h == null && (bVar = q.f10021g) != null) {
                a aVar = q.f10020f;
                q.f10022h = bVar.c(null);
            }
            q.f10023i.unlock();
        }

        public final c.c.b.e b() {
            q.f10023i.lock();
            c.c.b.e eVar = q.f10022h;
            q.f10022h = null;
            q.f10023i.unlock();
            return eVar;
        }

        public final void c(Uri uri) {
            kotlin.jvm.internal.m.f(uri, "url");
            d();
            q.f10023i.lock();
            c.c.b.e eVar = q.f10022h;
            if (eVar != null) {
                eVar.c(uri, null, null);
            }
            q.f10023i.unlock();
        }
    }

    @Override // c.c.b.d
    public void a(ComponentName componentName, c.c.b.b bVar) {
        kotlin.jvm.internal.m.f(componentName, "name");
        kotlin.jvm.internal.m.f(bVar, "newClient");
        bVar.d(0L);
        a aVar = f10020f;
        f10021g = bVar;
        aVar.d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        kotlin.jvm.internal.m.f(componentName, "componentName");
    }
}
