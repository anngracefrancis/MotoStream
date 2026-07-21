package com.bumptech.glide.load.engine.a0;

import java.io.File;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.a0.a.InterfaceC0125a {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f9058b;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.a = j2;
        this.f9058b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.InterfaceC0125a
    public com.bumptech.glide.load.engine.a0.a c() {
        File fileA = this.f9058b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.c(fileA, this.a);
        }
        return null;
    }
}
