package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class e3 implements f3 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set<Integer> f10717k = new HashSet();
    private final Set<Integer> l = new HashSet();
    private final Set<String> m = new HashSet();
    private final Set<Integer> n = new HashSet();
    private final Set<Integer> o = new HashSet();

    private static boolean c(v3 v3Var) {
        return v3Var.f11102g && !v3Var.f11103h;
    }

    @Override // com.flurry.sdk.f3
    public final void a() {
        this.f10717k.clear();
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
    }

    @Override // com.flurry.sdk.f3
    public final f3.a b(u6 u6Var) {
        if (u6Var.a().equals(s6.FLUSH_FRAME)) {
            return new f3.a(f3.b.DO_NOT_DROP, new w3(new x3(this.f10717k.size(), this.l.isEmpty())));
        }
        if (!u6Var.a().equals(s6.ANALYTICS_EVENT)) {
            return f3.a;
        }
        v3 v3Var = (v3) u6Var.f();
        String str = v3Var.f11097b;
        int i2 = v3Var.f11098c;
        this.f10717k.add(Integer.valueOf(i2));
        if (v3Var.f11099d != v3.a.CUSTOM) {
            if (this.o.size() < 1000 || c(v3Var)) {
                this.o.add(Integer.valueOf(i2));
                return f3.a;
            }
            this.l.add(Integer.valueOf(i2));
            return f3.f10745e;
        }
        if (TextUtils.isEmpty(str)) {
            this.l.add(Integer.valueOf(i2));
            return f3.f10743c;
        }
        if (c(v3Var) && !this.n.contains(Integer.valueOf(i2))) {
            this.l.add(Integer.valueOf(i2));
            return f3.f10746f;
        }
        if (this.n.size() >= 1000 && !c(v3Var)) {
            this.l.add(Integer.valueOf(i2));
            return f3.f10744d;
        }
        if (!this.m.contains(str) && this.m.size() >= 500) {
            this.l.add(Integer.valueOf(i2));
            return f3.f10742b;
        }
        this.m.add(str);
        this.n.add(Integer.valueOf(i2));
        return f3.a;
    }
}
