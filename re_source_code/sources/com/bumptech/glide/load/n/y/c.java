package com.bumptech.glide.load.n.y;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements n<Uri, InputStream> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements o<Uri, InputStream> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Uri, InputStream> b(r rVar) {
            return new c(this.a);
        }
    }

    public c(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i2, int i3, i iVar) {
        if (com.bumptech.glide.load.m.o.b.d(i2, i3)) {
            return new n.a<>(new com.bumptech.glide.q.c(uri), com.bumptech.glide.load.m.o.c.f(this.a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return com.bumptech.glide.load.m.o.b.a(uri);
    }
}
