package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.n.n;
import com.bumptech.glide.load.n.o;
import com.bumptech.glide.load.n.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.o.a f8906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.o.e f8907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.o.f f8908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.m.f f8909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.o.h.f f8910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.o.b f8911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.o.d f8912h = new com.bumptech.glide.o.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.o.c f8913i = new com.bumptech.glide.o.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c.i.j.f<List<Throwable>> f8914j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        c.i.j.f<List<Throwable>> fVarE = com.bumptech.glide.r.l.a.e();
        this.f8914j = fVarE;
        this.a = new p(fVarE);
        this.f8906b = new com.bumptech.glide.o.a();
        this.f8907c = new com.bumptech.glide.o.e();
        this.f8908d = new com.bumptech.glide.o.f();
        this.f8909e = new com.bumptech.glide.load.m.f();
        this.f8910f = new com.bumptech.glide.load.o.h.f();
        this.f8911g = new com.bumptech.glide.o.b();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f8907c.d(cls, cls2)) {
            for (Class cls5 : this.f8910f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.i(cls, cls4, cls5, this.f8907c.b(cls, cls4), this.f8910f.a(cls4, cls5), this.f8914j));
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.f8906b.a(cls, dVar);
        return this;
    }

    public <TResource> Registry b(Class<TResource> cls, k<TResource> kVar) {
        this.f8908d.a(cls, kVar);
        return this;
    }

    public <Data, TResource> Registry c(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.j<Data, TResource> jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    public <Model, Data> Registry d(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource> Registry e(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.j<Data, TResource> jVar) {
        this.f8907c.a(str, jVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.f8911g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVarA = this.f8913i.a(cls, cls2, cls3);
        if (this.f8913i.c(sVarA)) {
            return null;
        }
        if (sVarA == null) {
            List<com.bumptech.glide.load.engine.i<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
            sVarA = listF.isEmpty() ? null : new s<>(cls, cls2, cls3, listF, this.f8914j);
            this.f8913i.d(cls, cls2, cls3, sVarA);
        }
        return sVarA;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        List<n<Model, ?>> listD = this.a.d(model);
        if (listD.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return listD;
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.f8912h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f8907c.d(it.next(), cls2)) {
                    if (!this.f8910f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f8912h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public <X> k<X> k(u<X> uVar) throws NoResultEncoderAvailableException {
        k<X> kVarB = this.f8908d.b(uVar.e());
        if (kVarB != null) {
            return kVarB;
        }
        throw new NoResultEncoderAvailableException(uVar.e());
    }

    public <X> com.bumptech.glide.load.m.e<X> l(X x) {
        return this.f8909e.a(x);
    }

    public <X> com.bumptech.glide.load.d<X> m(X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.d<X> dVarB = this.f8906b.b(x.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(u<?> uVar) {
        return this.f8908d.b(uVar.e()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.f8911g.a(imageHeaderParser);
        return this;
    }

    public Registry p(com.bumptech.glide.load.m.e.a<?> aVar) {
        this.f8909e.b(aVar);
        return this;
    }

    public <TResource, Transcode> Registry q(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.o.h.e<TResource, Transcode> eVar) {
        this.f8910f.c(cls, cls2, eVar);
        return this;
    }

    public final Registry r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f8907c.e(arrayList);
        return this;
    }
}
