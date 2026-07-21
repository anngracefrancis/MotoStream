package com.bumptech.glide.load.m;

import com.bumptech.glide.load.o.c.s;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements e<InputStream> {
    private final s a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {
        private final com.bumptech.glide.load.engine.z.b a;

        public a(com.bumptech.glide.load.engine.z.b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.m.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.m.e.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.a);
        }
    }

    k(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
        s sVar = new s(inputStream, bVar);
        this.a = sVar;
        sVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.m.e
    public void b() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.m.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.a.reset();
        return this.a;
    }
}
