package com.google.firebase.u;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: GlobalLibraryVersionRegistrar.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<g> f20133b = new HashSet();

    e() {
    }

    public static e a() {
        e eVar = a;
        if (eVar == null) {
            synchronized (e.class) {
                eVar = a;
                if (eVar == null) {
                    eVar = new e();
                    a = eVar;
                }
            }
        }
        return eVar;
    }

    Set<g> b() {
        Set<g> setUnmodifiableSet;
        synchronized (this.f20133b) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f20133b);
        }
        return setUnmodifiableSet;
    }
}
