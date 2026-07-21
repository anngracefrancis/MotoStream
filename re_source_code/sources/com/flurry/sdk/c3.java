package com.flurry.sdk;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c3 extends l2 implements x2 {
    private x2 o;
    volatile int p;
    protected Queue<u6> q;
    protected y2 r;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.g().length];
            a = iArr;
            try {
                iArr[c.f10669f - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.f10673j - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.f10670g - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.f10671h - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.f10672i - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    class b implements y2 {

        final class a extends f2 {

            /* JADX INFO: renamed from: com.flurry.sdk.c3$b$a$a, reason: collision with other inner class name */
            final class C0158a extends f2 {
                C0158a() {
                }

                @Override // com.flurry.sdk.f2
                public final void a() {
                    y2 y2Var = c3.this.r;
                    if (y2Var != null) {
                        y2Var.a();
                    }
                }
            }

            a() {
            }

            @Override // com.flurry.sdk.f2
            public final void a() {
                c3.this.v();
                c3.this.p = c.f10672i;
                c3.this.m(new C0158a());
            }
        }

        private b() {
        }

        @Override // com.flurry.sdk.y2
        public final void a() {
            c3.this.m(new a());
        }

        /* synthetic */ b(c3 c3Var, byte b2) {
            this();
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f10669f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f10670g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f10671h = 3;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f10672i = 4;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f10673j = 5;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ int[] f10674k = {1, 2, 3, 4, 5};

        public static int[] g() {
            return (int[]) f10674k.clone();
        }
    }

    c3(String str, x2 x2Var) {
        super(str, i2.a(i2.b.CORE));
        this.p = c.f10669f;
        this.o = x2Var;
        this.q = new ConcurrentLinkedQueue();
        this.p = c.f10670g;
    }

    protected abstract void b(u6 u6Var);

    public x2.a c(u6 u6Var) {
        x2.a aVar = x2.a.ERROR;
        x2 x2Var = this.o;
        return x2Var != null ? x2Var.c(u6Var) : aVar;
    }

    @Override // com.flurry.sdk.x2
    public final void g(y2 y2Var) {
        this.p = c.f10671h;
        this.r = y2Var;
        t();
        x2 x2Var = this.o;
        if (x2Var != null) {
            x2Var.g(new b(this, (byte) 0));
            return;
        }
        if (y2Var != null) {
            y2Var.a();
        }
        this.p = c.f10672i;
    }

    @Override // com.flurry.sdk.x2
    public final x2.a j(u6 u6Var) {
        x2.a aVar = x2.a.ERROR;
        int i2 = a.a[this.p - 1];
        if (i2 != 3 && i2 != 4) {
            if (i2 != 5) {
                return aVar;
            }
            x2.a aVar2 = x2.a.QUEUED;
            b(u6Var);
            return aVar2;
        }
        x2.a aVar3 = x2.a.DEFERRED;
        this.q.add(u6Var);
        d1.c(4, "StreamingCoreModule", "Adding frame to deferred queue:" + u6Var.d());
        return aVar3;
    }

    protected void t() {
    }

    protected final void v() {
        while (this.q.peek() != null) {
            u6 u6VarPoll = this.q.poll();
            d1.c(4, "StreamingCoreModule", "Processing deferred message status for module: " + u6VarPoll.d());
            b(u6VarPoll);
        }
    }

    public final void w(u6 u6Var) {
        x2 x2Var = this.o;
        if (x2Var != null) {
            d1.c(4, "StreamingCoreModule", "Enqueue message status for module: " + this.o + " is: " + x2Var.j(u6Var));
        }
    }
}
