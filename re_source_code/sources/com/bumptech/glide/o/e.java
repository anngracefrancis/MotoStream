package com.bumptech.glide.o;

import com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private final List<String> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f9480b = new HashMap();

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {
        private final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f9481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final j<T, R> f9482c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.a = cls;
            this.f9481b = cls2;
            this.f9482c = jVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f9481b);
        }
    }

    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> arrayList;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        arrayList = this.f9480b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f9480b.put(str, arrayList);
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, jVar));
    }

    public synchronized <T, R> List<j<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f9480b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f9482c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f9480b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f9481b)) {
                        arrayList.add(aVar.f9481b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.a);
        this.a.clear();
        this.a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.a.add(str);
            }
        }
    }
}
