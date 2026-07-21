package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u7 {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<Integer> f17982b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Integer, r7> f17983c = new c.e.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ q7 f17984d;

    u7(q7 q7Var, String str) {
        this.f17984d = q7Var;
        this.a = str;
    }

    private final r7 a(int i2) {
        if (this.f17983c.containsKey(Integer.valueOf(i2))) {
            return this.f17983c.get(Integer.valueOf(i2));
        }
        r7 r7Var = new r7(this.f17984d, this.a, null);
        this.f17983c.put(Integer.valueOf(i2), r7Var);
        return r7Var;
    }

    private final boolean c(int i2, int i3) {
        if (this.f17983c.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        return this.f17983c.get(Integer.valueOf(i2)).f17939c.get(i3);
    }

    /* JADX WARN: Code duplicated, block: B:145:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:150:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:169:0x0463  */
    /* JADX WARN: Code duplicated, block: B:171:0x0480  */
    /* JADX WARN: Code duplicated, block: B:172:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:173:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:175:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:176:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:179:0x0542  */
    /* JADX WARN: Code duplicated, block: B:181:0x0550  */
    /* JADX WARN: Code duplicated, block: B:186:0x0566  */
    /* JADX WARN: Code duplicated, block: B:192:0x05ab A[LOOP:9: B:190:0x05a5->B:192:0x05ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:308:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x03a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0596 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x0580 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0250  */
    final List<zzbr.zza> b(List<zzbr.zzc> list, List<zzbr.zzk> list2, Long l) throws Throwable {
        boolean z;
        Iterator<zzbr.zzc> it;
        q7 q7Var;
        String str;
        boolean zY;
        h hVarD;
        zzbr.zzc zzcVar;
        h hVar;
        long j2;
        Map<Integer, List<zzbj.zzb>> mapV0;
        Iterator<Integer> it2;
        int iIntValue;
        Iterator<zzbj.zzb> it3;
        boolean zI;
        Object obj;
        Long l2;
        ArrayList arrayList;
        Map<Integer, zzbr.zzi> aVar;
        boolean z2;
        if (!this.f17984d.n().y(this.a, zzap.w0) && !this.f17984d.n().y(this.a, zzap.x0)) {
            z = false;
            break;
        }
        Iterator<zzbr.zzc> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(it4.next().U())) {
                z = true;
                break;
            }
        }
        boolean zY2 = this.f17984d.n().y(this.a, zzap.w0);
        boolean zY3 = this.f17984d.n().y(this.a, zzap.x0);
        if (z && zY3) {
            c cVarQ = this.f17984d.q();
            String str2 = this.a;
            cVarQ.t();
            cVarQ.d();
            Preconditions.g(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                cVarQ.x().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e2) {
                cVarQ.h().H().c("Error resetting session-scoped event counts. appId", zzet.x(str2), e2);
            }
        }
        Map<Integer, zzbr.zzi> mapU0 = this.f17984d.q().u0(this.a);
        if (mapU0 != null && !mapU0.isEmpty()) {
            HashSet hashSet = new HashSet(mapU0.keySet());
            if (zY2 && z) {
                q7 q7Var2 = this.f17984d;
                String str3 = this.a;
                Preconditions.g(str3);
                Preconditions.k(mapU0);
                aVar = new c.e.a<>();
                if (!mapU0.isEmpty()) {
                    Map<Integer, List<Integer>> mapT0 = q7Var2.q().t0(str3);
                    Iterator<Integer> it5 = mapU0.keySet().iterator();
                    while (it5.hasNext()) {
                        int iIntValue2 = it5.next().intValue();
                        zzbr.zzi zziVar = mapU0.get(Integer.valueOf(iIntValue2));
                        List<Integer> list3 = mapT0.get(Integer.valueOf(iIntValue2));
                        if (list3 == null || list3.isEmpty()) {
                            aVar.put(Integer.valueOf(iIntValue2), zziVar);
                        } else {
                            List<Long> listH = q7Var2.p().H(zziVar.N(), list3);
                            if (!listH.isEmpty()) {
                                zzbr.zzi.zza zzaVarE = zziVar.v().C().E(listH);
                                zzaVarE.w().B(q7Var2.p().H(zziVar.C(), list3));
                                for (int i2 = 0; i2 < zziVar.W(); i2++) {
                                    if (list3.contains(Integer.valueOf(zziVar.B(i2).G()))) {
                                        zzaVarE.A(i2);
                                    }
                                }
                                for (int i3 = 0; i3 < zziVar.Z(); i3++) {
                                    if (list3.contains(Integer.valueOf(zziVar.I(i3).J()))) {
                                        zzaVarE.D(i3);
                                    }
                                }
                                aVar.put(Integer.valueOf(iIntValue2), (zzbr.zzi) ((zzfd) zzaVarE.y()));
                            }
                        }
                    }
                }
            } else {
                aVar = mapU0;
            }
            Iterator it6 = hashSet.iterator();
            while (it6.hasNext()) {
                int iIntValue3 = ((Integer) it6.next()).intValue();
                zzbr.zzi zziVar2 = aVar.get(Integer.valueOf(iIntValue3));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                c.e.a aVar2 = new c.e.a();
                if (zziVar2 != null && zziVar2.W() != 0) {
                    for (zzbr.zzb zzbVar : zziVar2.U()) {
                        if (zzbVar.F()) {
                            aVar2.put(Integer.valueOf(zzbVar.G()), zzbVar.H() ? Long.valueOf(zzbVar.I()) : null);
                        }
                    }
                }
                if (zziVar2 != null) {
                    for (int i4 = 0; i4 < (zziVar2.H() << 6); i4++) {
                        if (zzkg.T(zziVar2.C(), i4)) {
                            this.f17984d.h().P().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue3), Integer.valueOf(i4));
                            bitSet2.set(i4);
                            if (zzkg.T(zziVar2.N(), i4)) {
                                bitSet.set(i4);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            aVar2.remove(Integer.valueOf(i4));
                        }
                    }
                }
                if (zY2) {
                    zziVar2 = mapU0.get(Integer.valueOf(iIntValue3));
                }
                a(iIntValue3).e(zziVar2, bitSet, bitSet2, aVar2);
            }
        }
        String str4 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            c.e.a aVar3 = new c.e.a();
            Iterator<zzbr.zzc> it7 = list.iterator();
            zzbr.zzc zzcVar2 = null;
            Long l3 = null;
            long jLongValue = 0;
            while (it7.hasNext()) {
                zzbr.zzc next = it7.next();
                String strU = next.U();
                List<zzbr.zze> listC = next.C();
                this.f17984d.p();
                Long l4 = (Long) zzkg.U(next, "_eid");
                boolean z3 = l4 != null;
                if (z3 && strU.equals("_ep")) {
                    this.f17984d.p();
                    strU = (String) zzkg.U(next, "_en");
                    if (TextUtils.isEmpty(strU)) {
                        this.f17984d.h().H().b("Extra parameter without an event name. eventId", l4);
                    } else {
                        if (zzcVar2 == null || l3 == null || l4.longValue() != l3.longValue()) {
                            Pair<zzbr.zzc, Long> pairB = this.f17984d.q().B(this.a, l4);
                            if (pairB == null || (obj = pairB.first) == null) {
                                this.f17984d.h().H().c("Extra parameter without existing main event. eventName, eventId", strU, l4);
                            } else {
                                zzcVar2 = (zzbr.zzc) obj;
                                jLongValue = ((Long) pairB.second).longValue();
                                this.f17984d.p();
                                l3 = (Long) zzkg.U(zzcVar2, "_eid");
                            }
                        }
                        zzbr.zzc zzcVar3 = zzcVar2;
                        jLongValue--;
                        if (jLongValue <= 0) {
                            c cVarQ2 = this.f17984d.q();
                            String str5 = this.a;
                            cVarQ2.d();
                            cVarQ2.h().P().b("Clearing complex main event info. appId", str5);
                            try {
                                SQLiteDatabase sQLiteDatabaseX = cVarQ2.x();
                                it = it7;
                                l2 = l3;
                                try {
                                    String[] strArr = new String[1];
                                    try {
                                        strArr[0] = str5;
                                        sQLiteDatabaseX.execSQL("delete from main_event_params where app_id=?", strArr);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        cVarQ2.h().H().b("Error clearing complex main event", e);
                                    }
                                } catch (SQLiteException e4) {
                                    e = e4;
                                    cVarQ2.h().H().b("Error clearing complex main event", e);
                                    arrayList = new ArrayList();
                                    for (zzbr.zze zzeVar : zzcVar3.C()) {
                                        this.f17984d.p();
                                        if (zzkg.z(next, zzeVar.B()) == null) {
                                            arrayList.add(zzeVar);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        this.f17984d.h().K().b("No unique parameters in main event. eventName", strU);
                                    } else {
                                        arrayList.addAll(listC);
                                        listC = arrayList;
                                    }
                                    zzcVar2 = zzcVar3;
                                    l3 = l2;
                                    q7Var = this.f17984d;
                                    str = this.a;
                                    zY = q7Var.n().y(str, zzap.x0);
                                    hVarD = q7Var.q().D(str, next.U());
                                    if (hVarD == null) {
                                        zzcVar = zzcVar2;
                                        q7Var.h().K().c("Event aggregate wasn't created during raw event logging. appId, event", zzet.x(str), q7Var.k().y(strU));
                                        if (zY) {
                                            hVar = new h(str, next.U(), 1L, 1L, 1L, next.W(), 0L, null, null, null, null);
                                        } else {
                                            hVar = new h(str, next.U(), 1L, 1L, next.W(), 0L, null, null, null, null);
                                        }
                                    } else {
                                        zzcVar = zzcVar2;
                                        if (zY) {
                                            hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e + 1, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                                        } else {
                                            hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                                        }
                                    }
                                    this.f17984d.q().N(hVar);
                                    j2 = hVar.f17785c;
                                    mapV0 = (Map) aVar3.get(strU);
                                    if (mapV0 == null) {
                                        mapV0 = this.f17984d.q().v0(this.a, strU);
                                        if (mapV0 == null) {
                                            mapV0 = new c.e.a<>();
                                        }
                                        aVar3.put(strU, mapV0);
                                    }
                                    it2 = mapV0.keySet().iterator();
                                    while (it2.hasNext()) {
                                        iIntValue = it2.next().intValue();
                                        aVar3 = aVar3;
                                        l3 = l3;
                                        if (this.f17982b.contains(Integer.valueOf(iIntValue))) {
                                            this.f17984d.h().P().b("Skipping failed audience ID", Integer.valueOf(iIntValue));
                                        } else {
                                            it3 = mapV0.get(Integer.valueOf(iIntValue)).iterator();
                                            zI = true;
                                            while (it3.hasNext()) {
                                                zzbj.zzb next2 = it3.next();
                                                Iterator<zzbj.zzb> it8 = it3;
                                                t7 t7Var = new t7(this.f17984d, this.a, iIntValue, next2);
                                                zI = t7Var.i(next, strU, listC, j2, hVar, c(iIntValue, next2.H()));
                                                a(iIntValue).f(t7Var);
                                                it3 = it8;
                                                mapV0 = mapV0;
                                                jLongValue = jLongValue;
                                            }
                                            Map<Integer, List<zzbj.zzb>> map = mapV0;
                                            long j3 = jLongValue;
                                            if (!zI) {
                                                this.f17982b.add(Integer.valueOf(iIntValue));
                                            }
                                            mapV0 = map;
                                            jLongValue = j3;
                                        }
                                    }
                                    it7 = it;
                                    zzcVar2 = zzcVar;
                                }
                            } catch (SQLiteException e5) {
                                e = e5;
                                it = it7;
                                l2 = l3;
                            }
                        } else {
                            it = it7;
                            l2 = l3;
                            this.f17984d.q().X(this.a, l4, jLongValue, zzcVar3);
                        }
                        arrayList = new ArrayList();
                        while (r7.hasNext()) {
                            this.f17984d.p();
                            if (zzkg.z(next, zzeVar.B()) == null) {
                                arrayList.add(zzeVar);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            arrayList.addAll(listC);
                            listC = arrayList;
                        } else {
                            this.f17984d.h().K().b("No unique parameters in main event. eventName", strU);
                        }
                        zzcVar2 = zzcVar3;
                        l3 = l2;
                    }
                    it7 = it7;
                } else {
                    it = it7;
                    if (z3) {
                        this.f17984d.p();
                        Object objU = zzkg.U(next, "_epc");
                        long jLongValue2 = ((Long) (objU != null ? objU : 0L)).longValue();
                        if (jLongValue2 <= 0) {
                            this.f17984d.h().K().b("Complex event with zero extra param count. eventName", strU);
                        } else {
                            this.f17984d.q().X(this.a, l4, jLongValue2, next);
                        }
                        jLongValue = jLongValue2;
                        zzcVar2 = next;
                        l3 = l4;
                    }
                    q7Var = this.f17984d;
                    str = this.a;
                    zY = q7Var.n().y(str, zzap.x0);
                    hVarD = q7Var.q().D(str, next.U());
                    if (hVarD == null) {
                        zzcVar = zzcVar2;
                        q7Var.h().K().c("Event aggregate wasn't created during raw event logging. appId, event", zzet.x(str), q7Var.k().y(strU));
                        if (zY) {
                            hVar = new h(str, next.U(), 1L, 1L, 1L, next.W(), 0L, null, null, null, null);
                        } else {
                            hVar = new h(str, next.U(), 1L, 1L, next.W(), 0L, null, null, null, null);
                        }
                    } else {
                        zzcVar = zzcVar2;
                        if (zY) {
                            hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e + 1, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                        } else {
                            hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                        }
                    }
                    this.f17984d.q().N(hVar);
                    j2 = hVar.f17785c;
                    mapV0 = (Map) aVar3.get(strU);
                    if (mapV0 == null) {
                        mapV0 = this.f17984d.q().v0(this.a, strU);
                        if (mapV0 == null) {
                            mapV0 = new c.e.a<>();
                        }
                        aVar3.put(strU, mapV0);
                    }
                    it2 = mapV0.keySet().iterator();
                    while (it2.hasNext()) {
                        iIntValue = it2.next().intValue();
                        aVar3 = aVar3;
                        l3 = l3;
                        if (this.f17982b.contains(Integer.valueOf(iIntValue))) {
                            this.f17984d.h().P().b("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        } else {
                            it3 = mapV0.get(Integer.valueOf(iIntValue)).iterator();
                            zI = true;
                            while (it3.hasNext()) {
                                zzbj.zzb next3 = it3.next();
                                Iterator<zzbj.zzb> it9 = it3;
                                t7 t7Var2 = new t7(this.f17984d, this.a, iIntValue, next3);
                                zI = t7Var2.i(next, strU, listC, j2, hVar, c(iIntValue, next3.H()));
                                a(iIntValue).f(t7Var2);
                                it3 = it9;
                                mapV0 = mapV0;
                                jLongValue = jLongValue;
                            }
                            Map<Integer, List<zzbj.zzb>> map2 = mapV0;
                            long j4 = jLongValue;
                            if (!zI) {
                                this.f17982b.add(Integer.valueOf(iIntValue));
                            }
                            mapV0 = map2;
                            jLongValue = j4;
                        }
                    }
                    it7 = it;
                    zzcVar2 = zzcVar;
                }
                q7Var = this.f17984d;
                str = this.a;
                zY = q7Var.n().y(str, zzap.x0);
                hVarD = q7Var.q().D(str, next.U());
                if (hVarD == null) {
                    zzcVar = zzcVar2;
                    q7Var.h().K().c("Event aggregate wasn't created during raw event logging. appId, event", zzet.x(str), q7Var.k().y(strU));
                    if (zY) {
                        hVar = new h(str, next.U(), 1L, 1L, 1L, next.W(), 0L, null, null, null, null);
                    } else {
                        hVar = new h(str, next.U(), 1L, 1L, next.W(), 0L, null, null, null, null);
                    }
                } else {
                    zzcVar = zzcVar2;
                    if (zY) {
                        hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e + 1, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                    } else {
                        hVar = new h(hVarD.a, hVarD.f17784b, hVarD.f17785c + 1, hVarD.f17786d + 1, hVarD.f17787e, hVarD.f17788f, hVarD.f17789g, hVarD.f17790h, hVarD.f17791i, hVarD.f17792j, hVarD.f17793k);
                    }
                }
                this.f17984d.q().N(hVar);
                j2 = hVar.f17785c;
                mapV0 = (Map) aVar3.get(strU);
                if (mapV0 == null) {
                    mapV0 = this.f17984d.q().v0(this.a, strU);
                    if (mapV0 == null) {
                        mapV0 = new c.e.a<>();
                    }
                    aVar3.put(strU, mapV0);
                }
                it2 = mapV0.keySet().iterator();
                while (it2.hasNext()) {
                    iIntValue = it2.next().intValue();
                    aVar3 = aVar3;
                    l3 = l3;
                    if (this.f17982b.contains(Integer.valueOf(iIntValue))) {
                        this.f17984d.h().P().b("Skipping failed audience ID", Integer.valueOf(iIntValue));
                    } else {
                        it3 = mapV0.get(Integer.valueOf(iIntValue)).iterator();
                        zI = true;
                        while (it3.hasNext()) {
                            zzbj.zzb next4 = it3.next();
                            Iterator<zzbj.zzb> it10 = it3;
                            t7 t7Var3 = new t7(this.f17984d, this.a, iIntValue, next4);
                            zI = t7Var3.i(next, strU, listC, j2, hVar, c(iIntValue, next4.H()));
                            a(iIntValue).f(t7Var3);
                            it3 = it10;
                            mapV0 = mapV0;
                            jLongValue = jLongValue;
                        }
                        Map<Integer, List<zzbj.zzb>> map3 = mapV0;
                        long j5 = jLongValue;
                        if (!zI) {
                            this.f17982b.add(Integer.valueOf(iIntValue));
                        }
                        mapV0 = map3;
                        jLongValue = j5;
                    }
                }
                it7 = it;
                zzcVar2 = zzcVar;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!list2.isEmpty()) {
            c.e.a aVar4 = new c.e.a();
            for (zzbr.zzk zzkVar : list2) {
                arrayList2.add(zzkVar.P());
                String strP = zzkVar.P();
                Map<Integer, List<zzbj.zze>> mapY0 = (Map) aVar4.get(strP);
                if (mapY0 == null) {
                    mapY0 = this.f17984d.q().y0(this.a, strP);
                    if (mapY0 == null) {
                        mapY0 = new c.e.a<>();
                    }
                    aVar4.put(strP, mapY0);
                }
                Iterator<Integer> it11 = mapY0.keySet().iterator();
                while (it11.hasNext()) {
                    int iIntValue4 = it11.next().intValue();
                    if (this.f17982b.contains(Integer.valueOf(iIntValue4))) {
                        this.f17984d.h().P().b(str4, Integer.valueOf(iIntValue4));
                        break;
                    }
                    Iterator<zzbj.zze> it12 = mapY0.get(Integer.valueOf(iIntValue4)).iterator();
                    boolean zI2 = true;
                    while (true) {
                        if (!it12.hasNext()) {
                            str4 = str4;
                            break;
                        }
                        zzbj.zze next5 = it12.next();
                        if (this.f17984d.h().C(2)) {
                            this.f17984d.h().P().d("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue4), next5.D() ? Integer.valueOf(next5.E()) : null, this.f17984d.k().B(next5.F()));
                            this.f17984d.h().P().b("Filter definition", this.f17984d.p().C(next5));
                        }
                        if (!next5.D() || next5.E() > 256) {
                            this.f17984d.h().K().c("Invalid property filter ID. appId, id", zzet.x(this.a), String.valueOf(next5.D() ? Integer.valueOf(next5.E()) : null));
                            zI2 = false;
                            break;
                        }
                        v7 v7Var = new v7(this.f17984d, this.a, iIntValue4, next5);
                        zI2 = v7Var.i(l, zzkVar, c(iIntValue4, next5.E()));
                        a(iIntValue4).f(v7Var);
                        str4 = str4;
                    }
                    if (!zI2) {
                        this.f17982b.add(Integer.valueOf(iIntValue4));
                    }
                    str4 = str4;
                }
            }
        }
        boolean zY4 = this.f17984d.n().y(this.a, zzap.C0);
        Map<Integer, List<Integer>> aVar5 = new c.e.a<>();
        if (zY4) {
            aVar5 = this.f17984d.q().l0(this.a, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> setKeySet = this.f17983c.keySet();
        setKeySet.removeAll(this.f17982b);
        Iterator<Integer> it13 = setKeySet.iterator();
        while (it13.hasNext()) {
            int iIntValue5 = it13.next().intValue();
            zzbr.zza zzaVarA = this.f17983c.get(Integer.valueOf(iIntValue5)).a(iIntValue5, z, aVar5.get(Integer.valueOf(iIntValue5)));
            arrayList3.add(zzaVarA);
            c cVarQ3 = this.f17984d.q();
            String str6 = this.a;
            zzbr.zzi zziVarL = zzaVarA.L();
            cVarQ3.t();
            cVarQ3.d();
            Preconditions.g(str6);
            Preconditions.k(zziVarL);
            byte[] bArrJ = zziVarL.j();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(RateAndReviewsFragment.BundleCons.APP_ID, str6);
            contentValues2.put("audience_id", Integer.valueOf(iIntValue5));
            contentValues2.put("current_results", bArrJ);
            try {
                try {
                    if (cVarQ3.x().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        cVarQ3.h().H().b("Failed to insert filter results (got -1). appId", zzet.x(str6));
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    cVarQ3.h().H().c("Error storing filter results. appId", zzet.x(str6), e);
                }
            } catch (SQLiteException e7) {
                e = e7;
            }
        }
        return arrayList3;
    }
}
