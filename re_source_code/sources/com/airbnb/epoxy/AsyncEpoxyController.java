package com.airbnb.epoxy;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncEpoxyController extends n {
    public AsyncEpoxyController() {
        this(true);
    }

    private static Handler getHandler(boolean z) {
        return z ? m.c() : m.a;
    }

    public AsyncEpoxyController(boolean z) {
        this(z, z);
    }

    public AsyncEpoxyController(boolean z, boolean z2) {
        super(getHandler(z), getHandler(z2));
    }
}
