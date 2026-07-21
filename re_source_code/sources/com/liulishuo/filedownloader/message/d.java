package com.liulishuo.filedownloader.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final List<a> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.InterfaceC0246b f20489b;

    /* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
    public class a {
        private final List<Integer> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f20490b;

        /* JADX INFO: renamed from: com.liulishuo.filedownloader.message.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
        class RunnableC0247a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MessageSnapshot f20492f;

            RunnableC0247a(MessageSnapshot messageSnapshot) {
                this.f20492f = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f20489b.H(this.f20492f);
                a.this.a.remove(Integer.valueOf(this.f20492f.e()));
            }
        }

        public a(int i2) {
            this.f20490b = e.h.a.k0.b.a(1, "Flow-" + i2);
        }

        public void b(int i2) {
            this.a.add(Integer.valueOf(i2));
        }

        public void c(MessageSnapshot messageSnapshot) {
            this.f20490b.execute(new RunnableC0247a(messageSnapshot));
        }
    }

    d(int i2, b.InterfaceC0246b interfaceC0246b) {
        this.f20489b = interfaceC0246b;
        for (int i3 = 0; i3 < i2; i3++) {
            this.a.add(new a(i3));
        }
    }

    public void b(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.a) {
                int iE = messageSnapshot.e();
                for (a aVar2 : this.a) {
                    if (aVar2.a.contains(Integer.valueOf(iE))) {
                        aVar = aVar2;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    for (a aVar3 : this.a) {
                        if (aVar3.a.size() <= 0) {
                            aVar = aVar3;
                            break;
                        } else if (size == 0 || aVar3.a.size() < size) {
                            size = aVar3.a.size();
                            aVar = aVar3;
                        }
                    }
                }
                aVar.b(iE);
            }
            aVar.c(messageSnapshot);
        } catch (Throwable th) {
            aVar.c(messageSnapshot);
            throw th;
        }
    }
}
