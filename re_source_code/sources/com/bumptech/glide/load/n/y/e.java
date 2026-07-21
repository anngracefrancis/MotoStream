package com.bumptech.glide.load.n.y;

import com.bumptech.glide.load.i;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: UrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements n<URL, InputStream> {
    private final n<g, InputStream> a;

    /* JADX INFO: compiled from: UrlLoader.java */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.n.o
        public n<URL, InputStream> b(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.a = nVar;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(URL url, int i2, int i3, i iVar) {
        return this.a.b(new g(url), i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
