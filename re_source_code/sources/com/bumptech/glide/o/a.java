package com.bumptech.glide.o;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private final List<C0139a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: com.bumptech.glide.o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0139a<T> {
        private final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.d<T> f9476b;

        C0139a(Class<T> cls, com.bumptech.glide.load.d<T> dVar) {
            this.a = cls;
            this.f9476b = dVar;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.load.d<T> dVar) {
        this.a.add(new C0139a<>(cls, dVar));
    }

    public synchronized <T> com.bumptech.glide.load.d<T> b(Class<T> cls) {
        for (C0139a<?> c0139a : this.a) {
            if (c0139a.a(cls)) {
                return (com.bumptech.glide.load.d<T>) c0139a.f9476b;
            }
        }
        return null;
    }
}
