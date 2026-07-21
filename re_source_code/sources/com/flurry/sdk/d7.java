package com.flurry.sdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d7<T> extends l2 {
    protected Set<f7<T>> o;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f10702h;

        a(f7 f7Var) {
            this.f10702h = f7Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            d7.this.o.add(this.f10702h);
        }
    }

    final class b extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f7 f10704h;

        b(f7 f7Var) {
            this.f10704h = f7Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            d7.this.o.remove(this.f10704h);
        }
    }

    final class c extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f10706h;

        final class a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ f7 f10708h;

            a(f7 f7Var) {
                this.f10708h = f7Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.flurry.sdk.f2
            public final void a() {
                this.f10708h.a(c.this.f10706h);
            }
        }

        c(Object obj) {
            this.f10706h = obj;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            Iterator<f7<T>> it = d7.this.o.iterator();
            while (it.hasNext()) {
                d7.this.m(new a(it.next()));
            }
        }
    }

    protected d7(String str) {
        super(str, i2.a(i2.b.PROVIDER));
        this.o = null;
        this.o = new HashSet();
    }

    public void t(T t) {
        m(new c(t));
    }

    public void u() {
    }

    public void v(f7<T> f7Var) {
        if (f7Var == null) {
            return;
        }
        m(new a(f7Var));
    }

    public void w(f7<T> f7Var) {
        m(new b(f7Var));
    }
}
