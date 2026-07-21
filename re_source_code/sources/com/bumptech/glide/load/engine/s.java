package com.bumptech.glide.load.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes.dex */
public class s<Data, ResourceType, Transcode> {
    private final Class<Data> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.i.j.f<List<Throwable>> f9190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f9191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9192d;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, c.i.j.f<List<Throwable>> fVar) {
        this.a = cls;
        this.f9190b = fVar;
        this.f9191c = (List) com.bumptech.glide.r.j.c(list);
        this.f9192d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> b(com.bumptech.glide.load.m.e<Data> eVar, com.bumptech.glide.load.i iVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f9191c.size();
        u<Transcode> uVarA = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                uVarA = this.f9191c.get(i4).a(eVar, i2, i3, iVar, aVar);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (uVarA != null) {
                break;
            }
        }
        if (uVarA != null) {
            return uVarA;
        }
        throw new GlideException(this.f9192d, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.m.e<Data> eVar, com.bumptech.glide.load.i iVar, int i2, int i3, i.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.r.j.d(this.f9190b.b());
        try {
            return b(eVar, iVar, i2, i3, aVar, list);
        } finally {
            this.f9190b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f9191c.toArray()) + '}';
    }
}
