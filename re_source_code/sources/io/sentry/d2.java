package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ISpan.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d2 {
    @ApiStatus.Experimental
    o5 a();

    boolean b();

    @ApiStatus.Internal
    boolean c(f4 f4Var);

    void d(j5 j5Var);

    @ApiStatus.Internal
    d2 f(String str, String str2, f4 f4Var, h2 h2Var);

    void g();

    String getDescription();

    j5 getStatus();

    void h(String str, Number number, v2 v2Var);

    void j(String str);

    f5 m();

    @ApiStatus.Internal
    f4 n();

    void o(j5 j5Var, f4 f4Var);

    @ApiStatus.Internal
    f4 q();
}
