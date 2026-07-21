package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzakh {
    private final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbai f13934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzayp<zzajw> f13935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzayp<zzajw> f13936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzala f13937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13938h;

    public zzakh(Context context, zzbai zzbaiVar, String str) {
        this.a = new Object();
        this.f13938h = 1;
        this.f13933c = str;
        this.f13932b = context.getApplicationContext();
        this.f13934d = zzbaiVar;
        this.f13935e = new zzakv();
        this.f13936f = new zzakv();
    }

    protected final zzala c(final zzdh zzdhVar) {
        final zzala zzalaVar = new zzala(this.f13936f);
        zzbbm.a.execute(new Runnable(this, zzdhVar, zzalaVar) { // from class: com.google.android.gms.internal.ads.i1

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzakh f12727f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzdh f12728g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final zzala f12729h;

            {
                this.f12727f = this;
                this.f12728g = zzdhVar;
                this.f12729h = zzalaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12727f.g(this.f12728g, this.f12729h);
            }
        });
        zzalaVar.d(new s1(this, zzalaVar), new t1(this, zzalaVar));
        return zzalaVar;
    }

    final /* synthetic */ void e(zzajw zzajwVar) {
        if (zzajwVar.l()) {
            this.f13938h = 1;
        }
    }

    final /* synthetic */ void f(zzala zzalaVar, zzajw zzajwVar) {
        synchronized (this.a) {
            if (zzalaVar.a() != -1 && zzalaVar.a() != 1) {
                zzalaVar.b();
                Executor executor = zzbbm.a;
                zzajwVar.getClass();
                executor.execute(n1.a(zzajwVar));
                zzawz.m("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }

    final /* synthetic */ void g(zzdh zzdhVar, final zzala zzalaVar) {
        try {
            Context context = this.f13932b;
            zzbai zzbaiVar = this.f13934d;
            final zzajw zzajjVar = ((Boolean) zzyt.e().c(zzacu.Q0)).booleanValue() ? new zzajj(context, zzbaiVar) : new zzajy(context, zzbaiVar, zzdhVar, null);
            zzajjVar.q(new zzajx(this, zzalaVar, zzajjVar) { // from class: com.google.android.gms.internal.ads.l1
                private final zzakh a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final zzala f12904b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final zzajw f12905c;

                {
                    this.a = this;
                    this.f12904b = zzalaVar;
                    this.f12905c = zzajjVar;
                }

                @Override // com.google.android.gms.internal.ads.zzajx
                public final void a() {
                    final zzakh zzakhVar = this.a;
                    final zzala zzalaVar2 = this.f12904b;
                    final zzajw zzajwVar = this.f12905c;
                    zzaxi.a.postDelayed(new Runnable(zzakhVar, zzalaVar2, zzajwVar) { // from class: com.google.android.gms.internal.ads.m1

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        private final zzakh f12947f;

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        private final zzala f12948g;

                        /* JADX INFO: renamed from: h, reason: collision with root package name */
                        private final zzajw f12949h;

                        {
                            this.f12947f = zzakhVar;
                            this.f12948g = zzalaVar2;
                            this.f12949h = zzajwVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12947f.f(this.f12948g, this.f12949h);
                        }
                    }, u1.f13376b);
                }
            });
            zzajjVar.f("/jsLoaded", new o1(this, zzalaVar, zzajjVar));
            zzazk zzazkVar = new zzazk();
            p1 p1Var = new p1(this, zzdhVar, zzajjVar, zzazkVar);
            zzazkVar.b(p1Var);
            zzajjVar.f("/requestReload", p1Var);
            if (this.f13933c.endsWith(".js")) {
                zzajjVar.o0(this.f13933c);
            } else if (this.f13933c.startsWith("<html>")) {
                zzajjVar.u0(this.f13933c);
            } else {
                zzajjVar.T(this.f13933c);
            }
            zzaxi.a.postDelayed(new q1(this, zzalaVar, zzajjVar), u1.a);
        } catch (Throwable th) {
            zzbad.c("Error creating webview.", th);
            zzk.zzlk().e(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalaVar.b();
        }
    }

    public final zzakw h(zzdh zzdhVar) {
        synchronized (this.a) {
            synchronized (this.a) {
                if (this.f13937g != null && this.f13938h == 0) {
                    if (((Boolean) zzyt.e().c(zzacu.f13805i)).booleanValue()) {
                        this.f13937g.d(new zzbbv(this) { // from class: com.google.android.gms.internal.ads.j1
                            private final zzakh a;

                            {
                                this.a = this;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbbv
                            public final void a(Object obj) {
                                this.a.e((zzajw) obj);
                            }
                        }, k1.a);
                    }
                }
            }
            zzala zzalaVar = this.f13937g;
            if (zzalaVar != null && zzalaVar.a() != -1) {
                int i2 = this.f13938h;
                if (i2 == 0) {
                    return this.f13937g.g();
                }
                if (i2 == 1) {
                    this.f13938h = 2;
                    c(null);
                    return this.f13937g.g();
                }
                if (i2 == 2) {
                    return this.f13937g.g();
                }
                return this.f13937g.g();
            }
            this.f13938h = 2;
            zzala zzalaVarC = c(null);
            this.f13937g = zzalaVarC;
            return zzalaVarC.g();
        }
    }

    public zzakh(Context context, zzbai zzbaiVar, String str, zzayp<zzajw> zzaypVar, zzayp<zzajw> zzaypVar2) {
        this(context, zzbaiVar, str);
        this.f13935e = zzaypVar;
        this.f13936f = zzaypVar2;
    }
}
