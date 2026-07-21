package com.flurry.sdk;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class b3 extends c3 {
    protected static s6[] s = {s6.SESSION_INFO, s6.APP_INFO, s6.REPORTED_ID, s6.DEVICE_PROPERTIES, s6.NOTIFICATION, s6.REFERRER, s6.LAUNCH_OPTIONS, s6.CONSENT, s6.APP_STATE, s6.NETWORK, s6.LOCALE, s6.TIMEZONE, s6.APP_ORIENTATION, s6.DYNAMIC_SESSION_INFO, s6.LOCATION, s6.USER_ID, s6.BIRTHDATE, s6.GENDER};
    protected static s6[] t = {s6.ORIGIN_ATTRIBUTE};
    private EnumMap<s6, u6> u;
    private EnumMap<s6, List<u6>> v;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u6 f10637h;

        a(u6 u6Var) {
            this.f10637h = u6Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            b3.this.w(this.f10637h);
            b3.y(b3.this, this.f10637h);
            if (s6.FLUSH_FRAME.equals(this.f10637h.a())) {
                Iterator it = b3.this.u.entrySet().iterator();
                while (it.hasNext()) {
                    u6 u6Var = (u6) ((Map.Entry) it.next()).getValue();
                    if (u6Var != null) {
                        b3.this.w(u6Var);
                    }
                }
                Iterator it2 = b3.this.v.entrySet().iterator();
                while (it2.hasNext()) {
                    List list = (List) ((Map.Entry) it2.next()).getValue();
                    if (list != null && list.size() != 0) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            b3.this.w((u6) list.get(i2));
                        }
                    }
                }
            }
        }
    }

    b3(x2 x2Var) {
        super("StickyModule", x2Var);
        this.u = new EnumMap<>(s6.class);
        this.v = new EnumMap<>(s6.class);
        for (s6 s6Var : s) {
            this.u.put(s6Var, (u6) null);
        }
        for (s6 s6Var2 : t) {
            this.v.put(s6Var2, (List<u6>) null);
        }
    }

    static /* synthetic */ void y(b3 b3Var, u6 u6Var) {
        s6 s6VarA = u6Var.a();
        List<u6> arrayList = new ArrayList<>();
        if (b3Var.u.containsKey(s6VarA)) {
            b3Var.u.put(s6VarA, u6Var);
        }
        if (b3Var.v.containsKey(s6VarA)) {
            if (b3Var.v.get(s6VarA) != null) {
                arrayList = b3Var.v.get(s6VarA);
            }
            arrayList.add(u6Var);
            b3Var.v.put(s6VarA, arrayList);
        }
    }

    @Override // com.flurry.sdk.c3
    public final void b(u6 u6Var) {
        m(new a(u6Var));
    }
}
