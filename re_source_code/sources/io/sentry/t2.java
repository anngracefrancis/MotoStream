package io.sentry;

import io.sentry.protocol.DebugImage;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: MainEventProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class t2 implements k1, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x4 f22710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a5 f22711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m4 f22712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile o1 f22713i = null;

    public t2(x4 x4Var) {
        x4 x4Var2 = (x4) io.sentry.util.q.c(x4Var, "The SentryOptions is required.");
        this.f22710f = x4Var2;
        z4 z4Var = new z4(x4Var2);
        this.f22712h = new m4(z4Var);
        this.f22711g = new a5(z4Var, x4Var2);
    }

    private void A(c4 c4Var) {
        if (c4Var.L() == null) {
            c4Var.a0(this.f22710f.getSdkVersion());
        }
    }

    private void B(c4 c4Var) {
        if (c4Var.M() == null) {
            c4Var.b0(this.f22710f.getServerName());
        }
        if (this.f22710f.isAttachServerName() && c4Var.M() == null) {
            a();
            if (this.f22713i != null) {
                c4Var.b0(this.f22713i.b());
            }
        }
    }

    private void D(c4 c4Var) {
        if (c4Var.N() == null) {
            c4Var.d0(new HashMap(this.f22710f.getTags()));
            return;
        }
        for (Map.Entry<String, String> entry : this.f22710f.getTags().entrySet()) {
            if (!c4Var.N().containsKey(entry.getKey())) {
                c4Var.c0(entry.getKey(), entry.getValue());
            }
        }
    }

    private void H(l4 l4Var, n1 n1Var) {
        if (l4Var.s0() == null) {
            ArrayList arrayList = null;
            List<io.sentry.protocol.p> listO0 = l4Var.o0();
            if (listO0 != null && !listO0.isEmpty()) {
                for (io.sentry.protocol.p pVar : listO0) {
                    if (pVar.g() != null && pVar.h() != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(pVar.h());
                    }
                }
            }
            if (this.f22710f.isAttachThreads() || io.sentry.util.m.d(n1Var, io.sentry.hints.b.class)) {
                Object objC = io.sentry.util.m.c(n1Var);
                l4Var.C0(this.f22711g.b(arrayList, objC instanceof io.sentry.hints.b ? ((io.sentry.hints.b) objC).d() : false));
            } else if (this.f22710f.isAttachStacktrace()) {
                if ((listO0 == null || listO0.isEmpty()) && !c(n1Var)) {
                    l4Var.C0(this.f22711g.a());
                }
            }
        }
    }

    private boolean I(c4 c4Var, n1 n1Var) {
        if (io.sentry.util.m.q(n1Var)) {
            return true;
        }
        this.f22710f.getLogger().c(s4.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", c4Var.G());
        return false;
    }

    private void a() {
        if (this.f22713i == null) {
            synchronized (this) {
                if (this.f22713i == null) {
                    this.f22713i = o1.c();
                }
            }
        }
    }

    private boolean c(n1 n1Var) {
        return io.sentry.util.m.d(n1Var, io.sentry.hints.f.class);
    }

    private void d(c4 c4Var) {
        if (this.f22710f.isSendDefaultPii()) {
            if (c4Var.Q() == null) {
                io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
                a0Var.o("{{auto}}");
                c4Var.e0(a0Var);
            } else if (c4Var.Q().l() == null) {
                c4Var.Q().o("{{auto}}");
            }
        }
    }

    private void f(c4 c4Var) {
        z(c4Var);
        m(c4Var);
        B(c4Var);
        l(c4Var);
        A(c4Var);
        D(c4Var);
        d(c4Var);
    }

    private void j(c4 c4Var) {
        y(c4Var);
    }

    private void k(c4 c4Var) {
        ArrayList arrayList = new ArrayList();
        if (this.f22710f.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(this.f22710f.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : this.f22710f.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        io.sentry.protocol.d dVarD = c4Var.D();
        if (dVarD == null) {
            dVarD = new io.sentry.protocol.d();
        }
        if (dVarD.c() == null) {
            dVarD.d(arrayList);
        } else {
            dVarD.c().addAll(arrayList);
        }
        c4Var.S(dVarD);
    }

    private void l(c4 c4Var) {
        if (c4Var.E() == null) {
            c4Var.T(this.f22710f.getDist());
        }
    }

    private void m(c4 c4Var) {
        if (c4Var.F() == null) {
            c4Var.U(this.f22710f.getEnvironment());
        }
    }

    private void p(l4 l4Var) {
        Throwable thP = l4Var.P();
        if (thP != null) {
            l4Var.x0(this.f22712h.c(thP));
        }
    }

    private void x(l4 l4Var) {
        Map<String, String> mapA = this.f22710f.getModulesLoader().a();
        if (mapA == null) {
            return;
        }
        Map<String, String> mapR0 = l4Var.r0();
        if (mapR0 == null) {
            l4Var.B0(mapA);
        } else {
            mapR0.putAll(mapA);
        }
    }

    private void y(c4 c4Var) {
        if (c4Var.I() == null) {
            c4Var.X("java");
        }
    }

    private void z(c4 c4Var) {
        if (c4Var.J() == null) {
            c4Var.Y(this.f22710f.getRelease());
        }
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        j(l4Var);
        p(l4Var);
        k(l4Var);
        x(l4Var);
        if (I(l4Var, n1Var)) {
            f(l4Var);
            H(l4Var, n1Var);
        }
        return l4Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f22713i != null) {
            this.f22713i.a();
        }
    }

    @Override // io.sentry.k1
    public io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        j(xVar);
        k(xVar);
        if (I(xVar, n1Var)) {
            f(xVar);
        }
        return xVar;
    }
}
