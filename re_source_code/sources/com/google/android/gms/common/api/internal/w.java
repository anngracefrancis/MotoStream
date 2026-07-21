package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
abstract class w {
    private final zabd a;

    protected w(zabd zabdVar) {
        this.a = zabdVar;
    }

    protected abstract void a();

    public final void b(zabe zabeVar) {
        zabeVar.f11825f.lock();
        try {
            if (zabeVar.p != this.a) {
                return;
            }
            a();
        } finally {
            zabeVar.f11825f.unlock();
        }
    }
}
