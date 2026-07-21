package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes.dex */
class x {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f9213b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((u) message.obj).c();
            return true;
        }
    }

    x() {
    }

    synchronized void a(u<?> uVar) {
        if (this.a) {
            this.f9213b.obtainMessage(1, uVar).sendToTarget();
        } else {
            this.a = true;
            uVar.c();
            this.a = false;
        }
    }
}
