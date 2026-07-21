package com.flurry.sdk;

import java.util.Timer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class d2 extends l3 {
    private static Timer m = new Timer("ExecutorQueue Global Timer", true);
    Executor n;

    public d2(Executor executor, String str) {
        super(str);
        this.n = executor;
    }

    @Override // com.flurry.sdk.c5
    protected final synchronized boolean q(g4.b bVar) {
        try {
            if (bVar.a()) {
                bVar.run();
            } else {
                this.n.execute(bVar);
            }
        } catch (Exception unused) {
            return false;
        }
        return true;
    }
}
