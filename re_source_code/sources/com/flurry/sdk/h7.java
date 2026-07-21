package com.flurry.sdk;

import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class h7 extends d7<i7> {
    private q p;
    private i7 q;
    protected f7<p> r;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f10813h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ i7 f10814i;

        a(f7 f7Var, i7 i7Var) {
            this.f10813h = f7Var;
            this.f10814i = i7Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            this.f10813h.a(this.f10814i);
        }
    }

    final class b implements f7<p> {
        b() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(p pVar) {
            Bundle bundle;
            p pVar2 = pVar;
            int i2 = c.a[pVar2.a.ordinal()];
            if (i2 == 1) {
                h7.x(h7.this, true);
                return;
            }
            if (i2 == 2) {
                h7.x(h7.this, false);
            } else if (i2 == 3 && (bundle = pVar2.f10968b) != null && bundle.containsKey("trim_memory_level") && bundle.getInt("trim_memory_level") == 20) {
                h7.x(h7.this, false);
            }
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[p.a.values().length];
            a = iArr;
            try {
                iArr[p.a.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[p.a.APP_BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[p.a.TRIM_MEMORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h7(q qVar) {
        super("AppStateChangeProvider");
        this.q = null;
        this.r = new b();
        this.p = qVar;
        g7 g7Var = g7.UNKNOWN;
        this.q = new i7(g7Var, g7Var);
        this.p.v(this.r);
    }

    static /* synthetic */ void x(h7 h7Var, boolean z) {
        g7 g7Var = z ? g7.FOREGROUND : g7.BACKGROUND;
        g7 g7Var2 = h7Var.q.f10835b;
        if (g7Var2 != g7Var) {
            h7Var.q = new i7(g7Var2, g7Var);
            h7Var.a();
        }
    }

    private void z() {
        HashMap map = new HashMap();
        map.put("previous_state", this.q.a.name());
        map.put("current_state", this.q.f10835b.name());
        g0.a();
        g0.f("AppStateChangeProvider: app state change", map);
    }

    public final void a() {
        d1.c(2, "AppStateChangeProvider", "AppStateChangeRule: prev " + this.q.a + " stateData.currentState:" + this.q.f10835b);
        z();
        i7 i7Var = this.q;
        t(new i7(i7Var.a, i7Var.f10835b));
    }

    @Override // com.flurry.sdk.d7
    public final void v(f7<i7> f7Var) {
        super.v(f7Var);
        m(new a(f7Var, this.q));
    }

    public final g7 y() {
        i7 i7Var = this.q;
        return i7Var == null ? g7.UNKNOWN : i7Var.f10835b;
    }
}
