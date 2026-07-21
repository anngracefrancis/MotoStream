package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.p.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: RolloutAssignmentList.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    private final List<j> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19175b;

    public k(int i2) {
        this.f19175b = i2;
    }

    public List<f0.e.d.AbstractC0226e> a() {
        List<j> listB = b();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listB.size(); i2++) {
            arrayList.add(listB.get(i2).h());
        }
        return arrayList;
    }

    public synchronized List<j> b() {
        return Collections.unmodifiableList(new ArrayList(this.a));
    }

    public synchronized boolean c(List<j> list) {
        this.a.clear();
        if (list.size() <= this.f19175b) {
            return this.a.addAll(list);
        }
        h.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f19175b);
        return this.a.addAll(list.subList(0, this.f19175b));
    }
}
