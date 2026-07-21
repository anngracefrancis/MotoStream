package com.bumptech.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {
    private final Class<DataType> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.j<DataType, ResourceType>> f9136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.o.h.e<ResourceType, Transcode> f9137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.i.j.f<List<Throwable>> f9138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9139e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.j<DataType, ResourceType>> list, com.bumptech.glide.load.o.h.e<ResourceType, Transcode> eVar, c.i.j.f<List<Throwable>> fVar) {
        this.a = cls;
        this.f9136b = list;
        this.f9137c = eVar;
        this.f9138d = fVar;
        this.f9139e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<ResourceType> b(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar) throws GlideException {
        List<Throwable> list = (List) com.bumptech.glide.r.j.d(this.f9138d.b());
        try {
            return c(eVar, i2, i3, iVar, list);
        } finally {
            this.f9138d.a(list);
        }
    }

    private u<ResourceType> c(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar, List<Throwable> list) throws GlideException {
        int size = this.f9136b.size();
        u<ResourceType> uVarB = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.bumptech.glide.load.j<DataType, ResourceType> jVar = this.f9136b.get(i4);
            try {
                if (jVar.a(eVar.a(), iVar)) {
                    uVarB = jVar.b(eVar.a(), i2, i3, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e2);
                }
                list.add(e2);
            }
            if (uVarB != null) {
                break;
            }
        }
        if (uVarB != null) {
            return uVarB;
        }
        throw new GlideException(this.f9139e, new ArrayList(list));
    }

    public u<Transcode> a(com.bumptech.glide.load.m.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar, a<ResourceType> aVar) throws GlideException {
        return this.f9137c.a(aVar.a(b(eVar, i2, i3, iVar)), iVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.f9136b + ", transcoder=" + this.f9137c + '}';
    }
}
