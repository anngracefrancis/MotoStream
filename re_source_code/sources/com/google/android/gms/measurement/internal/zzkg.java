package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzgn;
import com.google.android.gms.internal.measurement.zzjj;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkg extends f7 {
    zzkg(zzkc zzkcVar) {
        super(zzkcVar);
    }

    static <Builder extends zzgn> Builder A(Builder builder, byte[] bArr) throws zzfo {
        com.google.android.gms.internal.measurement.zzeq zzeqVarC = com.google.android.gms.internal.measurement.zzeq.c();
        return zzeqVarC != null ? (Builder) builder.Y(bArr, zzeqVarC) : (Builder) builder.i0(bArr);
    }

    private static String E(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    static List<Long> F(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 << 6) + i3;
                if (i4 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i4)) {
                    j2 |= 1 << i3;
                }
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    static void I(zzbr.zzc.zza zzaVar, String str, Object obj) {
        List<zzbr.zze> listG = zzaVar.G();
        int i2 = 0;
        while (true) {
            if (i2 >= listG.size()) {
                i2 = -1;
                break;
            } else if (str.equals(listG.get(i2).B())) {
                break;
            } else {
                i2++;
            }
        }
        zzbr.zze.zza zzaVarC = zzbr.zze.T().C(str);
        if (obj instanceof Long) {
            zzaVarC.B(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzaVarC.E((String) obj);
        } else if (obj instanceof Double) {
            zzaVarC.A(((Double) obj).doubleValue());
        }
        if (i2 >= 0) {
            zzaVar.w(i2, zzaVarC);
        } else {
            zzaVar.C(zzaVarC);
        }
    }

    private static void L(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    private final void M(StringBuilder sb, int i2, zzbj.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        L(sb, i2);
        sb.append("filter {\n");
        if (zzcVar.H()) {
            P(sb, i2, "complement", Boolean.valueOf(zzcVar.I()));
        }
        P(sb, i2, "param_name", k().A(zzcVar.J()));
        int i3 = i2 + 1;
        zzbj.zzf zzfVarE = zzcVar.E();
        if (zzfVarE != null) {
            L(sb, i3);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzfVarE.B()) {
                P(sb, i3, "match_type", zzfVarE.C().name());
            }
            P(sb, i3, "expression", zzfVarE.E());
            if (zzfVarE.F()) {
                P(sb, i3, "case_sensitive", Boolean.valueOf(zzfVarE.G()));
            }
            if (zzfVarE.I() > 0) {
                L(sb, i3 + 1);
                sb.append("expression_list {\n");
                for (String str : zzfVarE.H()) {
                    L(sb, i3 + 2);
                    sb.append(str);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            L(sb, i3);
            sb.append("}\n");
        }
        N(sb, i3, "number_filter", zzcVar.G());
        L(sb, i2);
        sb.append("}\n");
    }

    private final void N(StringBuilder sb, int i2, String str, zzbj.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        L(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (zzdVar.B()) {
            P(sb, i2, "comparison_type", zzdVar.C().name());
        }
        if (zzdVar.D()) {
            P(sb, i2, "match_as_float", Boolean.valueOf(zzdVar.E()));
        }
        P(sb, i2, "comparison_value", zzdVar.G());
        P(sb, i2, "min_comparison_value", zzdVar.I());
        P(sb, i2, "max_comparison_value", zzdVar.K());
        L(sb, i2);
        sb.append("}\n");
    }

    private static void O(StringBuilder sb, int i2, String str, zzbr.zzi zziVar, String str2) {
        if (zziVar == null) {
            return;
        }
        L(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziVar.Q() != 0) {
            L(sb, 4);
            sb.append("results: ");
            int i3 = 0;
            for (Long l : zziVar.N()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (zziVar.H() != 0) {
            L(sb, 4);
            sb.append("status: ");
            int i5 = 0;
            for (Long l2 : zziVar.C()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zziVar.W() != 0) {
            L(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i7 = 0;
            for (zzbr.zzb zzbVar : zziVar.U()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(zzbVar.F() ? Integer.valueOf(zzbVar.G()) : null);
                sb.append(":");
                sb.append(zzbVar.H() ? Long.valueOf(zzbVar.I()) : null);
                i7 = i8;
            }
            sb.append("}\n");
        }
        if (zziVar.Z() != 0) {
            L(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i9 = 0;
            for (zzbr.zzj zzjVar : zziVar.X()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(zzjVar.I() ? Integer.valueOf(zzjVar.J()) : null);
                sb.append(": [");
                Iterator<Long> it = zzjVar.L().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i11 = i12;
                }
                sb.append("]");
                i9 = i10;
            }
            sb.append("}\n");
        }
        L(sb, 3);
        sb.append("}\n");
    }

    private static void P(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        L(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    static boolean S(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean T(List<Long> list, int i2) {
        if (i2 < (list.size() << 6)) {
            return ((1 << (i2 % 64)) & list.get(i2 / 64).longValue()) != 0;
        }
        return false;
    }

    static Object U(zzbr.zzc zzcVar, String str) {
        zzbr.zze zzeVarZ = z(zzcVar, str);
        if (zzeVarZ == null) {
            return null;
        }
        if (zzeVarZ.M()) {
            return zzeVarZ.N();
        }
        if (zzeVarZ.P()) {
            return Long.valueOf(zzeVarZ.Q());
        }
        if (zzeVarZ.R()) {
            return Double.valueOf(zzeVarZ.S());
        }
        return null;
    }

    static int w(zzbr.zzg.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i2 = 0; i2 < zzaVar.d0(); i2++) {
            if (str.equals(zzaVar.b0(i2).P())) {
                return i2;
            }
        }
        return -1;
    }

    static zzbr.zze z(zzbr.zzc zzcVar, String str) {
        for (zzbr.zze zzeVar : zzcVar.C()) {
            if (zzeVar.B().equals(str)) {
                return zzeVar;
            }
        }
        return null;
    }

    final String B(zzbj.zzb zzbVar) {
        if (zzbVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbVar.G()) {
            P(sb, 0, "filter_id", Integer.valueOf(zzbVar.H()));
        }
        P(sb, 0, "event_name", k().y(zzbVar.I()));
        String strE = E(zzbVar.N(), zzbVar.O(), zzbVar.Q());
        if (!strE.isEmpty()) {
            P(sb, 0, "filter_type", strE);
        }
        N(sb, 1, "event_count_filter", zzbVar.M());
        sb.append("  filters {\n");
        Iterator<zzbj.zzc> it = zzbVar.J().iterator();
        while (it.hasNext()) {
            M(sb, 2, it.next());
        }
        L(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    final String C(zzbj.zze zzeVar) {
        if (zzeVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzeVar.D()) {
            P(sb, 0, "filter_id", Integer.valueOf(zzeVar.E()));
        }
        P(sb, 0, "property_name", k().B(zzeVar.F()));
        String strE = E(zzeVar.H(), zzeVar.I(), zzeVar.K());
        if (!strE.isEmpty()) {
            P(sb, 0, "filter_type", strE);
        }
        M(sb, 1, zzeVar.G());
        sb.append("}\n");
        return sb.toString();
    }

    final String D(zzbr.zzf zzfVar) {
        List<zzbr.zze> listC;
        if (zzfVar == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzbr.zzg zzgVar : zzfVar.C()) {
            if (zzgVar != null) {
                L(sb, 1);
                sb.append("bundle {\n");
                if (zzgVar.Z()) {
                    P(sb, 1, "protocol_version", Integer.valueOf(zzgVar.B0()));
                }
                P(sb, 1, "platform", zzgVar.E2());
                if (zzgVar.N2()) {
                    P(sb, 1, "gmp_version", Long.valueOf(zzgVar.a0()));
                }
                if (zzgVar.b0()) {
                    P(sb, 1, "uploading_gmp_version", Long.valueOf(zzgVar.c0()));
                }
                if (zzgVar.P0()) {
                    P(sb, 1, "dynamite_version", Long.valueOf(zzgVar.Q0()));
                }
                if (zzgVar.v0()) {
                    P(sb, 1, "config_version", Long.valueOf(zzgVar.w0()));
                }
                P(sb, 1, "gmp_app_id", zzgVar.n0());
                P(sb, 1, "admob_app_id", zzgVar.O0());
                P(sb, 1, RateAndReviewsFragment.BundleCons.APP_ID, zzgVar.L2());
                P(sb, 1, "app_version", zzgVar.M2());
                if (zzgVar.s0()) {
                    P(sb, 1, "app_version_major", Integer.valueOf(zzgVar.t0()));
                }
                P(sb, 1, "firebase_instance_id", zzgVar.r0());
                if (zzgVar.h0()) {
                    P(sb, 1, "dev_cert_hash", Long.valueOf(zzgVar.j0()));
                }
                P(sb, 1, "app_store", zzgVar.K2());
                if (zzgVar.R1()) {
                    P(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgVar.S1()));
                }
                if (zzgVar.d2()) {
                    P(sb, 1, "start_timestamp_millis", Long.valueOf(zzgVar.e2()));
                }
                if (zzgVar.o2()) {
                    P(sb, 1, "end_timestamp_millis", Long.valueOf(zzgVar.p2()));
                }
                if (zzgVar.w2()) {
                    P(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgVar.x2()));
                }
                if (zzgVar.C2()) {
                    P(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgVar.D2()));
                }
                P(sb, 1, "app_instance_id", zzgVar.g0());
                P(sb, 1, "resettable_device_id", zzgVar.d0());
                P(sb, 1, "device_id", zzgVar.u0());
                P(sb, 1, "ds_id", zzgVar.z0());
                if (zzgVar.e0()) {
                    P(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgVar.f0()));
                }
                P(sb, 1, "os_version", zzgVar.F2());
                P(sb, 1, "device_model", zzgVar.G2());
                P(sb, 1, "user_default_language", zzgVar.H2());
                if (zzgVar.I2()) {
                    P(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgVar.J2()));
                }
                if (zzgVar.k0()) {
                    P(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgVar.l0()));
                }
                if (zzgVar.o0()) {
                    P(sb, 1, "service_upload", Boolean.valueOf(zzgVar.p0()));
                }
                P(sb, 1, "health_monitor", zzgVar.m0());
                if (zzgVar.x0() && zzgVar.y0() != 0) {
                    P(sb, 1, "android_id", Long.valueOf(zzgVar.y0()));
                }
                if (zzgVar.A0()) {
                    P(sb, 1, "retry_counter", Integer.valueOf(zzgVar.N0()));
                }
                List<zzbr.zzk> listV1 = zzgVar.v1();
                if (listV1 != null) {
                    for (zzbr.zzk zzkVar : listV1) {
                        if (zzkVar != null) {
                            L(sb, 2);
                            sb.append("user_property {\n");
                            P(sb, 2, "set_timestamp_millis", zzkVar.I() ? Long.valueOf(zzkVar.J()) : null);
                            P(sb, 2, "name", k().B(zzkVar.P()));
                            P(sb, 2, "string_value", zzkVar.S());
                            P(sb, 2, "int_value", zzkVar.T() ? Long.valueOf(zzkVar.U()) : null);
                            P(sb, 2, "double_value", zzkVar.V() ? Double.valueOf(zzkVar.W()) : null);
                            L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbr.zza> listQ0 = zzgVar.q0();
                String strL2 = zzgVar.L2();
                if (listQ0 != null) {
                    for (zzbr.zza zzaVar : listQ0) {
                        if (zzaVar != null) {
                            L(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzaVar.J()) {
                                P(sb, 2, "audience_id", Integer.valueOf(zzaVar.K()));
                            }
                            if (zzaVar.O()) {
                                P(sb, 2, "new_audience", Boolean.valueOf(zzaVar.P()));
                            }
                            O(sb, 2, "current_data", zzaVar.L(), strL2);
                            O(sb, 2, "previous_data", zzaVar.N(), strL2);
                            L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbr.zzc> listB1 = zzgVar.b1();
                if (listB1 != null) {
                    for (zzbr.zzc zzcVar : listB1) {
                        if (zzcVar != null) {
                            L(sb, 2);
                            sb.append("event {\n");
                            P(sb, 2, "name", k().y(zzcVar.U()));
                            if (zzcVar.V()) {
                                P(sb, 2, "timestamp_millis", Long.valueOf(zzcVar.W()));
                            }
                            if (zzcVar.X()) {
                                P(sb, 2, "previous_timestamp_millis", Long.valueOf(zzcVar.Z()));
                            }
                            if (zzcVar.a0()) {
                                P(sb, 2, "count", Integer.valueOf(zzcVar.b0()));
                            }
                            if (zzcVar.Q() != 0 && (listC = zzcVar.C()) != null) {
                                for (zzbr.zze zzeVar : listC) {
                                    if (zzeVar != null) {
                                        L(sb, 3);
                                        sb.append("param {\n");
                                        P(sb, 3, "name", k().A(zzeVar.B()));
                                        P(sb, 3, "string_value", zzeVar.N());
                                        P(sb, 3, "int_value", zzeVar.P() ? Long.valueOf(zzeVar.Q()) : null);
                                        P(sb, 3, "double_value", zzeVar.R() ? Double.valueOf(zzeVar.S()) : null);
                                        L(sb, 3);
                                        sb.append("}\n");
                                    }
                                }
                            }
                            L(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                L(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    final List<Long> H(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                h().K().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    h().K().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & ((1 << (num.intValue() % 64)) ^ (-1))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    final void J(zzbr.zze.zza zzaVar, Object obj) {
        Preconditions.k(obj);
        zzaVar.w().D().F();
        if (obj instanceof String) {
            zzaVar.E((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.B(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.A(((Double) obj).doubleValue());
        } else {
            h().H().b("Ignoring invalid (type) event param value", obj);
        }
    }

    final void K(zzbr.zzk.zza zzaVar, Object obj) {
        Preconditions.k(obj);
        zzaVar.w().D().G();
        if (obj instanceof String) {
            zzaVar.F((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.E(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.A(((Double) obj).doubleValue());
        } else {
            h().H().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final boolean Q(long j2, long j3) {
        return j2 == 0 || j3 <= 0 || Math.abs(j().a() - j2) > j3;
    }

    final boolean R(zzan zzanVar, zzm zzmVar) {
        Preconditions.k(zzanVar);
        Preconditions.k(zzmVar);
        if (zzjj.b() && n().r(zzap.U0)) {
            return (TextUtils.isEmpty(zzmVar.f18235g) && TextUtils.isEmpty(zzmVar.w)) ? false : true;
        }
        if (!TextUtils.isEmpty(zzmVar.f18235g) || !TextUtils.isEmpty(zzmVar.w)) {
            return true;
        }
        G();
        return false;
    }

    final byte[] V(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i2 = gZIPInputStream.read(bArr2);
                if (i2 <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i2);
            }
        } catch (IOException e2) {
            h().H().b("Failed to ungzip content", e2);
            throw e2;
        }
    }

    final byte[] W(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            h().H().b("Failed to gzip content", e2);
            throw e2;
        }
    }

    final List<Integer> X() {
        Map<String, String> mapC = zzap.c(this.f17811b.f());
        if (mapC == null || mapC.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = zzap.T.a(null).intValue();
        for (Map.Entry<String, String> entry : mapC.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i2 = Integer.parseInt(entry.getValue());
                    if (i2 != 0) {
                        arrayList.add(Integer.valueOf(i2));
                        if (arrayList.size() >= iIntValue) {
                            h().K().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    h().K().b("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ q7 o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzkg p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ c q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzfr r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    final long x(byte[] bArr) {
        Preconditions.k(bArr);
        l().d();
        MessageDigest messageDigestA0 = zzkk.A0();
        if (messageDigestA0 != null) {
            return zzkk.x(messageDigestA0.digest(bArr));
        }
        h().H().a("Failed to get MD5");
        return 0L;
    }

    final <T extends Parcelable> T y(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            h().H().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }
}
