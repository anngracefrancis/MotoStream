package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class b implements Comparator<Scope> {
    b() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Scope scope, Scope scope2) {
        return scope.y().compareTo(scope2.y());
    }
}
