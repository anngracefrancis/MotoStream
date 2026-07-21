package com.flurry.sdk;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 extends l2 implements v6 {
    private PriorityQueue<String> o;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f10871h;

        a(List list) {
            this.f10871h = list;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            k2.this.o.addAll(this.f10871h);
            k2.this.v();
        }
    }

    public k2() {
        super("FrameLogTestHandler", i2.a(i2.b.CORE));
        this.o = null;
        this.o = new PriorityQueue<>(4, new s2());
    }

    private synchronized void t(String str, boolean z) {
        d1.j("FrameLogTestHandler", "File move to test folder for file: " + str + " fileMoved:" + z);
        d1.c(2, "FrameLogTestHandler", "Deleting file " + str + " deleted " + q2.b(str));
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() throws Throwable {
        d1.j("FrameLogTestHandler", " Starting processNextFile " + this.o.size());
        if (this.o.peek() == null) {
            d1.j("FrameLogTestHandler", "No file present to process.");
            return;
        }
        String strPoll = this.o.poll();
        if (q2.d(strPoll)) {
            File file = new File(strPoll);
            boolean zC = x6.c(file, new File(b2.a().toString() + File.separator + "fCompletedInApp", String.format(Locale.US, "completedInApp-%d", Long.valueOf(System.currentTimeMillis()))));
            if (zC) {
                zC = file.delete();
            }
            t(strPoll, zC);
        }
    }

    @Override // com.flurry.sdk.v6
    public final void a() {
    }

    @Override // com.flurry.sdk.v6
    public final g0.c d() {
        g0.c cVar = new g0.c();
        cVar.a(this.o.size());
        return cVar;
    }

    @Override // com.flurry.sdk.v6
    public final void e(List<String> list) {
        if (list.size() == 0) {
            d1.j("FrameLogTestHandler", "File List is null or empty");
            return;
        }
        d1.j("FrameLogTestHandler", "Number of files being added:" + list.toString());
        m(new a(list));
    }
}
