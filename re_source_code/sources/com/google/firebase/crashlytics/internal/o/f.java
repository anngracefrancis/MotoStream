package com.google.firebase.crashlytics.internal.o;

import java.io.File;

/* JADX INFO: compiled from: LogFileManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.r.f f19153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f19154c;

    /* JADX INFO: compiled from: LogFileManager.java */
    private static final class b implements d {
        private b() {
        }

        @Override // com.google.firebase.crashlytics.internal.o.d
        public void a() {
        }

        @Override // com.google.firebase.crashlytics.internal.o.d
        public String b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.o.d
        public byte[] c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.o.d
        public void d() {
        }

        @Override // com.google.firebase.crashlytics.internal.o.d
        public void e(long j2, String str) {
        }
    }

    public f(com.google.firebase.crashlytics.internal.r.f fVar) {
        this.f19153b = fVar;
        this.f19154c = a;
    }

    private File d(String str) {
        return this.f19153b.o(str, "userlog");
    }

    public void a() {
        this.f19154c.d();
    }

    public byte[] b() {
        return this.f19154c.c();
    }

    public String c() {
        return this.f19154c.b();
    }

    public final void e(String str) {
        this.f19154c.a();
        this.f19154c = a;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    void f(File file, int i2) {
        this.f19154c = new i(file, i2);
    }

    public void g(long j2, String str) {
        this.f19154c.e(j2, str);
    }

    public f(com.google.firebase.crashlytics.internal.r.f fVar, String str) {
        this(fVar);
        e(str);
    }
}
