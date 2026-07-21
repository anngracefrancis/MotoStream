package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.r.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private final com.bumptech.glide.r.g<com.bumptech.glide.load.f, String> a = new com.bumptech.glide.r.g<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.i.j.f<b> f9076b = com.bumptech.glide.r.l.a.d(10, new a());

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    class a implements com.bumptech.glide.r.l.a.d<b> {
        a() {
        }

        @Override // com.bumptech.glide.r.l.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    private static final class b implements com.bumptech.glide.r.l.a.f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final MessageDigest f9077f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.bumptech.glide.r.l.c f9078g = com.bumptech.glide.r.l.c.a();

        b(MessageDigest messageDigest) {
            this.f9077f = messageDigest;
        }

        @Override // com.bumptech.glide.r.l.a.f
        public com.bumptech.glide.r.l.c u() {
            return this.f9078g;
        }
    }

    private String a(com.bumptech.glide.load.f fVar) {
        b bVar = (b) com.bumptech.glide.r.j.d(this.f9076b.b());
        try {
            fVar.updateDiskCacheKey(bVar.f9077f);
            return k.u(bVar.f9077f.digest());
        } finally {
            this.f9076b.a(bVar);
        }
    }

    public String b(com.bumptech.glide.load.f fVar) {
        String strG;
        synchronized (this.a) {
            strG = this.a.g(fVar);
        }
        if (strG == null) {
            strG = a(fVar);
        }
        synchronized (this.a) {
            this.a.k(fVar, strG);
        }
        return strG;
    }
}
