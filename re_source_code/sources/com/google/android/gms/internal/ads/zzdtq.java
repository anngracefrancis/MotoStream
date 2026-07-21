package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtq<T> implements zzdti<Set<T>> {
    private static final zzdti<Set<Object>> a = zzdtj.a(Collections.emptySet());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<zzdtu<T>> f16172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<zzdtu<Collection<T>>> f16173c;

    private zzdtq(List<zzdtu<T>> list, List<zzdtu<Collection<T>>> list2) {
        this.f16172b = list;
        this.f16173c = list2;
    }

    public static <T> zzdts<T> a(int i2, int i3) {
        return new zzdts<>(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        int size = this.f16172b.size();
        ArrayList arrayList = new ArrayList(this.f16173c.size());
        int size2 = this.f16173c.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> collection = this.f16173c.get(i2).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetB = zzdtf.b(size);
        int size3 = this.f16172b.size();
        for (int i3 = 0; i3 < size3; i3++) {
            hashSetB.add(zzdto.a(this.f16172b.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            Iterator it = ((Collection) arrayList.get(i4)).iterator();
            while (it.hasNext()) {
                hashSetB.add(zzdto.a(it.next()));
            }
        }
        return Collections.unmodifiableSet(hashSetB);
    }
}
