package com.facebook.o0;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: AnalyticsUserIDStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static final u a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10503b = u.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f10504c = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f10506e;

    private u() {
    }

    public static final String a() {
        if (!f10506e) {
            Log.w(f10503b, "initStore should have been called before calling setUserID");
            a.b();
        }
        f10504c.readLock().lock();
        try {
            return f10505d;
        } finally {
            f10504c.readLock().unlock();
        }
    }

    private final void b() {
        if (f10506e) {
            return;
        }
        f10504c.writeLock().lock();
        try {
            if (f10506e) {
                return;
            }
            com.facebook.a0 a0Var = com.facebook.a0.a;
            f10505d = PreferenceManager.getDefaultSharedPreferences(com.facebook.a0.c()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f10506e = true;
        } finally {
            f10504c.writeLock().unlock();
        }
    }

    public static final void c() {
        if (f10506e) {
            return;
        }
        g0.a.b().execute(new Runnable() { // from class: com.facebook.o0.b
            @Override // java.lang.Runnable
            public final void run() {
                u.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        a.b();
    }

    public static final void g(final String str) {
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        com.facebook.o0.q0.g.b();
        if (!f10506e) {
            Log.w(f10503b, "initStore should have been called before calling setUserID");
            a.b();
        }
        g0.a.b().execute(new Runnable() { // from class: com.facebook.o0.a
            @Override // java.lang.Runnable
            public final void run() {
                u.h(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str) {
        f10504c.writeLock().lock();
        try {
            f10505d = str;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(com.facebook.a0.c()).edit();
            editorEdit.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", f10505d);
            editorEdit.apply();
        } finally {
            f10504c.writeLock().unlock();
        }
    }
}
