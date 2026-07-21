package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t7 extends w7 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbj.zzb f17970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q7 f17971h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    t7(q7 q7Var, String str, int i2, zzbj.zzb zzbVar) {
        super(str, i2);
        this.f17971h = q7Var;
        this.f17970g = zzbVar;
    }

    @Override // com.google.android.gms.measurement.internal.w7
    final int a() {
        return this.f17970g.H();
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:108:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:113:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:116:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:120:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:123:0x0302  */
    /* JADX WARN: Code duplicated, block: B:129:0x0356 A[EDGE_INSN: B:129:0x0356->B:132:0x03a2 BREAK  A[LOOP:0: B:48:0x011c->B:53:0x014d]] */
    /* JADX WARN: Code duplicated, block: B:130:0x037c A[EDGE_INSN: B:130:0x037c->B:132:0x03a2 BREAK  A[LOOP:0: B:48:0x011c->B:53:0x014d]] */
    /* JADX WARN: Code duplicated, block: B:156:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x03a2 A[EDGE_INSN: B:175:0x03a2->B:132:0x03a2 BREAK  A[LOOP:0: B:48:0x011c->B:53:0x014d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x028c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x03a2 A[EDGE_INSN: B:178:0x03a2->B:132:0x03a2 BREAK  A[LOOP:0: B:48:0x011c->B:53:0x014d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0286 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0354 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x03a2 A[EDGE_INSN: B:185:0x03a2->B:132:0x03a2 BREAK  A[LOOP:0: B:48:0x011c->B:53:0x014d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x010f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0122  */
    /* JADX WARN: Code duplicated, block: B:53:0x014d A[LOOP:0: B:48:0x011c->B:53:0x014d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x0164  */
    /* JADX WARN: Code duplicated, block: B:63:0x0184  */
    /* JADX WARN: Code duplicated, block: B:64:0x018d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x020d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0233  */
    /* JADX WARN: Code duplicated, block: B:94:0x0266  */
    /* JADX WARN: Code duplicated, block: B:97:0x0278  */
    final boolean i(zzbr.zzc zzcVar, String str, List<zzbr.zze> list, long j2, h hVar, boolean z) {
        HashSet hashSet;
        Iterator<zzbj.zzc> it;
        c.e.a aVar;
        Iterator<zzbr.zze> it2;
        Iterator<zzbj.zzc> it3;
        zzbj.zzc next;
        boolean z2;
        String strJ;
        Object obj;
        Boolean boolC;
        Boolean boolB;
        String str2;
        Boolean boolE;
        zzbr.zze next2;
        Long lValueOf;
        Double dValueOf;
        zzbj.zzc next3;
        boolean zY = this.f17971h.n().y(this.a, zzap.w0);
        if (this.f17971h.n().y(this.a, zzap.x0) && zY && this.f17970g.Q()) {
            j2 = hVar.f17787e;
        }
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (this.f17971h.h().C(2)) {
            this.f17971h.h().P().d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f18009b), this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null, this.f17971h.k().y(this.f17970g.I()));
            this.f17971h.h().P().b("Filter definition", this.f17971h.p().B(this.f17970g));
        }
        if (!this.f17970g.G() || this.f17970g.H() > 256) {
            this.f17971h.h().K().c("Invalid event filter ID. appId, id", zzet.x(this.a), String.valueOf(this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null));
            return true;
        }
        boolean zN = this.f17970g.N();
        boolean zO = this.f17970g.O();
        boolean z3 = zN || zO || (zY && this.f17970g.Q());
        if (z && !z3) {
            this.f17971h.h().P().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f18009b), this.f17970g.G() ? Integer.valueOf(this.f17970g.H()) : null);
            return true;
        }
        zzbj.zzb zzbVar = this.f17970g;
        if (!zzbVar.L()) {
            hashSet = new HashSet();
            it = zzbVar.J().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = new c.e.a();
                    it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzbVar.J().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                next = it3.next();
                                if (next.H() || !next.I()) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                strJ = next.J();
                                if (strJ.isEmpty()) {
                                    obj = aVar.get(strJ);
                                    if (obj instanceof Long) {
                                        if (obj instanceof Double) {
                                            if (obj instanceof String) {
                                                if (obj == null) {
                                                    this.f17971h.h().K().c("Unknown param type. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                    break;
                                                }
                                                this.f17971h.h().P().c("Missing param for filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            if (next.D()) {
                                                if (next.F()) {
                                                    this.f17971h.h().K().c("No filter for String param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                    break;
                                                }
                                                str2 = (String) obj;
                                                if (zzkg.S(str2)) {
                                                    this.f17971h.h().K().c("Invalid param value for number filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                    break;
                                                }
                                                boolE = w7.e(str2, next.G());
                                            } else {
                                                boolE = w7.g((String) obj, next.E(), this.f17971h.h());
                                            }
                                            if (boolE != null) {
                                                break;
                                            }
                                            if (boolE.booleanValue() == z2) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (next.F()) {
                                                this.f17971h.h().K().c("No number filter for double param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                break;
                                            }
                                            boolB = w7.b(((Double) obj).doubleValue(), next.G());
                                            if (boolB != null) {
                                                break;
                                            }
                                            if (boolB.booleanValue() == z2) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (next.F()) {
                                            this.f17971h.h().K().c("No number filter for long param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                            break;
                                        }
                                        boolC = w7.c(((Long) obj).longValue(), next.G());
                                        if (boolC != null) {
                                            break;
                                        }
                                        if (boolC.booleanValue() == z2) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    }
                                } else {
                                    this.f17971h.h().K().b("Event has empty param name. event", this.f17971h.k().y(str));
                                    break;
                                }
                            }
                        } else {
                            next2 = it2.next();
                            if (!hashSet.contains(next2.B())) {
                                if (next2.P()) {
                                    if (next2.R()) {
                                        if (next2.M()) {
                                            this.f17971h.h().K().c("Unknown value for param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(next2.B()));
                                            break;
                                        }
                                        aVar.put(next2.B(), next2.N());
                                    } else {
                                        String strB = next2.B();
                                        if (next2.R()) {
                                            dValueOf = Double.valueOf(next2.S());
                                        } else {
                                            dValueOf = null;
                                        }
                                        aVar.put(strB, dValueOf);
                                    }
                                } else {
                                    String strB2 = next2.B();
                                    if (next2.P()) {
                                        lValueOf = Long.valueOf(next2.Q());
                                    } else {
                                        lValueOf = null;
                                    }
                                    aVar.put(strB2, lValueOf);
                                }
                            }
                        }
                    }
                } else {
                    next3 = it.next();
                    if (next3.J().isEmpty()) {
                        this.f17971h.h().K().b("null or empty param name in filter. event", this.f17971h.k().y(str));
                        break;
                    }
                    hashSet.add(next3.J());
                }
            }
        } else {
            Boolean boolC2 = w7.c(j2, zzbVar.M());
            if (boolC2 != null) {
                if (boolC2.booleanValue()) {
                    hashSet = new HashSet();
                    it = zzbVar.J().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            aVar = new c.e.a();
                            it2 = list.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    it3 = zzbVar.J().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            bool = Boolean.TRUE;
                                            break;
                                        }
                                        next = it3.next();
                                        if (next.H()) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        strJ = next.J();
                                        if (strJ.isEmpty()) {
                                            obj = aVar.get(strJ);
                                            if (obj instanceof Long) {
                                                if (obj instanceof Double) {
                                                    if (obj instanceof String) {
                                                        if (obj == null) {
                                                            this.f17971h.h().K().c("Unknown param type. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                            break;
                                                        }
                                                        this.f17971h.h().P().c("Missing param for filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    if (next.D()) {
                                                        if (next.F()) {
                                                            this.f17971h.h().K().c("No filter for String param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                            break;
                                                        }
                                                        str2 = (String) obj;
                                                        if (zzkg.S(str2)) {
                                                            this.f17971h.h().K().c("Invalid param value for number filter. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                            break;
                                                        }
                                                        boolE = w7.e(str2, next.G());
                                                    } else {
                                                        boolE = w7.g((String) obj, next.E(), this.f17971h.h());
                                                    }
                                                    if (boolE != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolE.booleanValue() == z2) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else if (next.F()) {
                                                    boolB = w7.b(((Double) obj).doubleValue(), next.G());
                                                    if (boolB != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolB.booleanValue() == z2) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else {
                                                    this.f17971h.h().K().c("No number filter for double param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                    break;
                                                }
                                            } else if (next.F()) {
                                                boolC = w7.c(((Long) obj).longValue(), next.G());
                                                if (boolC != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolC.booleanValue() == z2) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            } else {
                                                this.f17971h.h().K().c("No number filter for long param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(strJ));
                                                break;
                                            }
                                        } else {
                                            this.f17971h.h().K().b("Event has empty param name. event", this.f17971h.k().y(str));
                                            break;
                                        }
                                    }
                                } else {
                                    next2 = it2.next();
                                    if (!hashSet.contains(next2.B())) {
                                        if (next2.P()) {
                                            if (next2.R()) {
                                                if (next2.M()) {
                                                    this.f17971h.h().K().c("Unknown value for param. event, param", this.f17971h.k().y(str), this.f17971h.k().A(next2.B()));
                                                    break;
                                                }
                                                aVar.put(next2.B(), next2.N());
                                            } else {
                                                String strB3 = next2.B();
                                                if (next2.R()) {
                                                    dValueOf = Double.valueOf(next2.S());
                                                } else {
                                                    dValueOf = null;
                                                }
                                                aVar.put(strB3, dValueOf);
                                            }
                                        } else {
                                            String strB4 = next2.B();
                                            if (next2.P()) {
                                                lValueOf = Long.valueOf(next2.Q());
                                            } else {
                                                lValueOf = null;
                                            }
                                            aVar.put(strB4, lValueOf);
                                        }
                                    }
                                }
                            }
                        } else {
                            next3 = it.next();
                            if (next3.J().isEmpty()) {
                                this.f17971h.h().K().b("null or empty param name in filter. event", this.f17971h.k().y(str));
                                break;
                            }
                            hashSet.add(next3.J());
                        }
                    }
                } else {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.f17971h.h().P().b("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.f18010c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.f18011d = bool2;
        if (z3 && zzcVar.V()) {
            if (zO) {
                this.f18013f = Long.valueOf(zzcVar.W());
            } else {
                this.f18012e = Long.valueOf(zzcVar.W());
            }
        }
        return true;
    }
}
