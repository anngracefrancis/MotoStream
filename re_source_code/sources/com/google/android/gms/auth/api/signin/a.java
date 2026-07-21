package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Comparator f11522f = new a();

    private a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).y().compareTo(((Scope) obj2).y());
    }
}
