package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@SafeParcelable.Class
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zan();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f12130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final ArrayList<zal> f12131h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12132i;

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.f12129f = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zalVar = arrayList.get(i3);
            String str2 = zalVar.f12134g;
            HashMap map2 = new HashMap();
            int size2 = zalVar.f12135h.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zamVar = zalVar.f12135h.get(i4);
                map2.put(zamVar.f12137g, zamVar.f12138h);
            }
            map.put(str2, map2);
        }
        this.f12130g = map;
        this.f12132i = (String) Preconditions.k(str);
        y();
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> W(String str) {
        return this.f12130g.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f12130g.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f12130g.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12129f);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f12130g.keySet()) {
            arrayList.add(new zal(str, this.f12130g.get(str)));
        }
        SafeParcelWriter.y(parcel, 2, arrayList, false);
        SafeParcelWriter.u(parcel, 3, this.f12132i, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final void y() {
        Iterator<String> it = this.f12130g.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f12130g.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).M0(this);
            }
        }
    }

    public final String z() {
        return this.f12132i;
    }
}
