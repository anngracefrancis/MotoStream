package com.bumptech.glide.load.engine;

import java.io.File;

/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes.dex */
class e<DataType> implements com.bumptech.glide.load.engine.a0.a.b {
    private final com.bumptech.glide.load.d<DataType> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f9101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i f9102c;

    e(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, com.bumptech.glide.load.i iVar) {
        this.a = dVar;
        this.f9101b = datatype;
        this.f9102c = iVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.b
    public boolean a(File file) {
        return this.a.a(this.f9101b, file, this.f9102c);
    }
}
