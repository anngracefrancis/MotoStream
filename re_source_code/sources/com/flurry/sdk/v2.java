package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class v2 extends c3 {
    protected List<f3> s;
    protected final Map<String, List<u6>> t;
    protected g0.a u;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u6 f11095h;

        a(u6 u6Var) {
            this.f11095h = u6Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            v2.z(v2.this, v2.y(v2.this, this.f11095h));
            v2.C(v2.this, this.f11095h);
        }
    }

    v2(x2 x2Var) {
        super("DropModule", x2Var);
        this.t = new HashMap();
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add(new e3());
        this.s.add(new d3());
        this.s.add(new g3());
        this.s.add(new h3());
        this.u = new g0.a();
    }

    private void A(f3.a aVar, u6 u6Var) {
        this.u.b(u6Var.a());
        if (aVar.a.equals(f3.b.DROP_STANDARD_EVENTS_COUNT_EXCEEDED)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("fl.drop.reason", aVar.a.q);
        map.put("fl.drop.frame.type", String.valueOf(u6Var.a()));
        g0.a();
        g0.d("Flurry.SDKReport.DropFrame", map);
    }

    private static void B(u6 u6Var, u6 u6Var2) {
        v3 v3Var = (v3) u6Var.f();
        v3 v3Var2 = (v3) u6Var2.f();
        v3Var2.f11098c = v3Var.f11098c;
        v3Var2.f11106k = v3Var2.f11104i - v3Var.f11104i;
        Map<String, String> map = v3Var.f11100e;
        Map<String, String> map2 = v3Var2.f11100e;
        if (map == null || map2 == null) {
            return;
        }
        Map<String, String> map3 = v3Var.f11101f;
        Map<String, String> map4 = v3Var2.f11101f;
        if (map3.get(c2.h("fl.parameter.limit.exceeded")) != null) {
            map4.putAll(map3);
            map2.clear();
            return;
        }
        if (!map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!map2.containsKey(entry.getKey())) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (map2.size() > 10) {
            map4.put(c2.h("fl.parameter.limit.exceeded.on.endevent"), c2.h(String.valueOf(map2.size())));
            map2.clear();
            map2.putAll(map);
        }
    }

    static /* synthetic */ void C(v2 v2Var, u6 u6Var) {
        if (E(u6Var)) {
            d1.c(4, "DropModule", "Resetting drop rules");
            Iterator<f3> it = v2Var.s.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            d1.c(4, "DropModule", "Reset start timed event record");
            v2Var.t.clear();
        }
    }

    private List<u6> D(u6 u6Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, List<u6>>> it = this.t.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<u6> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                v3 v3Var = (v3) it2.next().f();
                String str = v3Var.f11097b;
                int i2 = v3Var.f11098c;
                long jCurrentTimeMillis = System.currentTimeMillis();
                arrayList.add(u3.i(str, i2, v3Var.f11100e, v3Var.f11101f, jCurrentTimeMillis, jCurrentTimeMillis - v3Var.f11104i));
                this.u.a();
            }
        }
        arrayList.add(u6Var);
        return arrayList;
    }

    private static boolean E(u6 u6Var) {
        return u6Var.a().equals(s6.FLUSH_FRAME) && ((s5) u6Var.f()).f11050c.equals(j3.a.REASON_SESSION_FINALIZE.p);
    }

    static /* synthetic */ List y(v2 v2Var, u6 u6Var) {
        if (!(u6Var.a().equals(s6.ANALYTICS_EVENT) && ((v3) u6Var.f()).f11102g)) {
            if (E(u6Var)) {
                return v2Var.D(u6Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(u6Var);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        String str = ((v3) u6Var.f()).f11097b;
        List<u6> arrayList3 = v2Var.t.get(str);
        if (((v3) u6Var.f()).f11103h) {
            if (arrayList3 == null) {
                arrayList3 = new ArrayList<>();
            }
            arrayList3.add(u6Var);
            v2Var.t.put(str, arrayList3);
            arrayList2.add(u6Var);
            return arrayList2;
        }
        if (arrayList3 == null || arrayList3.isEmpty()) {
            v2Var.A(f3.f10746f, u6Var);
            return arrayList2;
        }
        B(arrayList3.remove(0), u6Var);
        arrayList2.add(u6Var);
        return arrayList2;
    }

    static /* synthetic */ void z(v2 v2Var, List list) {
        boolean z;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u6 u6Var = (u6) it.next();
            Iterator<f3> it2 = v2Var.s.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                f3.a aVarB = it2.next().b(u6Var);
                if (!aVarB.a.equals(f3.b.DO_NOT_DROP)) {
                    v2Var.A(aVarB, u6Var);
                    z = true;
                    break;
                } else {
                    u6 u6Var2 = aVarB.f10751b;
                    if (u6Var2 != null) {
                        v2Var.w(u6Var2);
                    }
                }
            }
            if (z) {
                d1.c(4, "DropModule", "Dropping Frame: " + u6Var.a() + ": " + u6Var.d());
            } else {
                d1.c(4, "DropModule", "Adding Frame:" + u6Var.d());
                v2Var.w(u6Var);
            }
        }
    }

    @Override // com.flurry.sdk.c3
    public final void b(u6 u6Var) {
        m(new a(u6Var));
    }

    public final g0.a x() {
        return this.u;
    }
}
