package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Parcel f12124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f12125h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final zak f12126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f12127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12128k;
    private int l;

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zak zakVar) {
        this.f12123f = i2;
        this.f12124g = (Parcel) Preconditions.k(parcel);
        this.f12126i = zakVar;
        if (zakVar == null) {
            this.f12127j = null;
        } else {
            this.f12127j = zakVar.z();
        }
        this.f12128k = 2;
    }

    private static void h(StringBuilder sb, int i2, Object obj) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void i(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().p0(), entry);
        }
        sb.append('{');
        int iL = SafeParcelReader.L(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.v(iC));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.a1()) {
                    switch (field.f12110i) {
                        case 0:
                            j(sb, field, FastJsonResponse.g(field, Integer.valueOf(SafeParcelReader.E(parcel, iC))));
                            break;
                        case 1:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.c(parcel, iC)));
                            break;
                        case 2:
                            j(sb, field, FastJsonResponse.g(field, Long.valueOf(SafeParcelReader.G(parcel, iC))));
                            break;
                        case 3:
                            j(sb, field, FastJsonResponse.g(field, Float.valueOf(SafeParcelReader.A(parcel, iC))));
                            break;
                        case 4:
                            j(sb, field, FastJsonResponse.g(field, Double.valueOf(SafeParcelReader.y(parcel, iC))));
                            break;
                        case 5:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.a(parcel, iC)));
                            break;
                        case 6:
                            j(sb, field, FastJsonResponse.g(field, Boolean.valueOf(SafeParcelReader.w(parcel, iC))));
                            break;
                        case 7:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.p(parcel, iC)));
                            break;
                        case 8:
                        case 9:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.g(parcel, iC)));
                            break;
                        case 10:
                            Bundle bundleF = SafeParcelReader.f(parcel, iC);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, bundleF.getString(str2));
                            }
                            j(sb, field, FastJsonResponse.g(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i2 = field.f12110i;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i2);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.f12111j) {
                    sb.append("[");
                    switch (field.f12110i) {
                        case 0:
                            ArrayUtils.e(sb, SafeParcelReader.j(parcel, iC));
                            break;
                        case 1:
                            ArrayUtils.g(sb, SafeParcelReader.d(parcel, iC));
                            break;
                        case 2:
                            ArrayUtils.f(sb, SafeParcelReader.l(parcel, iC));
                            break;
                        case 3:
                            ArrayUtils.d(sb, SafeParcelReader.i(parcel, iC));
                            break;
                        case 4:
                            ArrayUtils.c(sb, SafeParcelReader.h(parcel, iC));
                            break;
                        case 5:
                            ArrayUtils.g(sb, SafeParcelReader.b(parcel, iC));
                            break;
                        case 6:
                            ArrayUtils.h(sb, SafeParcelReader.e(parcel, iC));
                            break;
                        case 7:
                            ArrayUtils.i(sb, SafeParcelReader.q(parcel, iC));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrN = SafeParcelReader.n(parcel, iC);
                            int length = parcelArrN.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                if (i3 > 0) {
                                    sb.append(",");
                                }
                                parcelArrN[i3].setDataPosition(0);
                                i(sb, field.r1(), parcelArrN[i3]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.f12110i) {
                        case 0:
                            sb.append(SafeParcelReader.E(parcel, iC));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, iC));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.G(parcel, iC));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.A(parcel, iC));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.y(parcel, iC));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, iC));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.w(parcel, iC));
                            break;
                        case 7:
                            String strP = SafeParcelReader.p(parcel, iC);
                            sb.append("\"");
                            sb.append(JsonUtils.a(strP));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = SafeParcelReader.g(parcel, iC);
                            sb.append("\"");
                            sb.append(Base64Utils.a(bArrG));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = SafeParcelReader.g(parcel, iC);
                            sb.append("\"");
                            sb.append(Base64Utils.b(bArrG2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = SafeParcelReader.f(parcel, iC);
                            Set<String> setKeySet = bundleF2.keySet();
                            setKeySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : setKeySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(JsonUtils.a(bundleF2.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel parcelM = SafeParcelReader.m(parcel, iC);
                            parcelM.setDataPosition(0);
                            i(sb, field.r1(), parcelM);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == iL) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(iL);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void j(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (!field.f12109h) {
            h(sb, field.f12108g, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            h(sb, field.f12108g, arrayList.get(i2));
        }
        sb.append("]");
    }

    private final Parcel k() {
        int i2 = this.f12128k;
        if (i2 != 0) {
            if (i2 == 1) {
            }
            return this.f12124g;
        }
        this.l = SafeParcelWriter.a(this.f12124g);
        SafeParcelWriter.b(this.f12124g, this.l);
        this.f12128k = 2;
        return this.f12124g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zak zakVar = this.f12126i;
        if (zakVar == null) {
            return null;
        }
        return zakVar.W(this.f12127j);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean e(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        Preconditions.l(this.f12126i, "Cannot convert to JSON on client side.");
        Parcel parcelK = k();
        parcelK.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        i(sb, this.f12126i.W(this.f12127j), parcelK);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        zak zakVar;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12123f);
        SafeParcelWriter.r(parcel, 2, k(), false);
        int i3 = this.f12125h;
        if (i3 == 0) {
            zakVar = null;
        } else {
            if (i3 != 1 && i3 != 2) {
                int i4 = this.f12125h;
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
            zakVar = this.f12126i;
        }
        SafeParcelWriter.s(parcel, 3, zakVar, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
