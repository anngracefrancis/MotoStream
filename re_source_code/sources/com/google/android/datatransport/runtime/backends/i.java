package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Inject;

/* JADX INFO: compiled from: CreationContextFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class i {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11313c;

    @Inject
    i(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2) {
        this.a = context;
        this.f11312b = aVar;
        this.f11313c = aVar2;
    }

    h a(String str) {
        return h.a(this.a, this.f11312b, this.f11313c, str);
    }
}
