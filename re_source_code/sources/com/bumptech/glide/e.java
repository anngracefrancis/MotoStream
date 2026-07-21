package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.k;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends ContextWrapper {
    static final j<?, ?> a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f8931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Registry f8932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.p.l.e f8933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.p.h f8934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<com.bumptech.glide.p.g<Object>> f8935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f8936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f8937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f8938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8939j;

    public e(Context context, com.bumptech.glide.load.engine.z.b bVar, Registry registry, com.bumptech.glide.p.l.e eVar, com.bumptech.glide.p.h hVar, Map<Class<?>, j<?, ?>> map, List<com.bumptech.glide.p.g<Object>> list, k kVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f8931b = bVar;
        this.f8932c = registry;
        this.f8933d = eVar;
        this.f8934e = hVar;
        this.f8935f = list;
        this.f8936g = map;
        this.f8937h = kVar;
        this.f8938i = z;
        this.f8939j = i2;
    }

    public <X> com.bumptech.glide.p.l.j<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f8933d.a(imageView, cls);
    }

    public com.bumptech.glide.load.engine.z.b b() {
        return this.f8931b;
    }

    public List<com.bumptech.glide.p.g<Object>> c() {
        return this.f8935f;
    }

    public com.bumptech.glide.p.h d() {
        return this.f8934e;
    }

    public <T> j<?, T> e(Class<T> cls) {
        j<?, T> jVar = (j) this.f8936g.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f8936g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) a : jVar;
    }

    public k f() {
        return this.f8937h;
    }

    public int g() {
        return this.f8939j;
    }

    public Registry h() {
        return this.f8932c;
    }

    public boolean i() {
        return this.f8938i;
    }
}
