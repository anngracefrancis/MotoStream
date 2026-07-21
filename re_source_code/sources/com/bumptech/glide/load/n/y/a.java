package com.bumptech.glide.load.n.y;

import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m.j;
import com.bumptech.glide.load.n.g;
import com.bumptech.glide.load.n.m;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.r;
import java.io.InputStream;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements n<g, InputStream> {
    public static final h<Integer> a = h.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<g, g> f9346b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.n.y.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class C0136a implements o<g, InputStream> {
        private final m<g, g> a = new m<>(500);

        @Override // com.bumptech.glide.load.n.o
        public n<g, InputStream> b(r rVar) {
            return new a(this.a);
        }
    }

    public a(m<g, g> mVar) {
        this.f9346b = mVar;
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(g gVar, int i2, int i3, i iVar) {
        m<g, g> mVar = this.f9346b;
        if (mVar != null) {
            g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.f9346b.b(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) iVar.a(a)).intValue()));
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(g gVar) {
        return true;
    }
}
