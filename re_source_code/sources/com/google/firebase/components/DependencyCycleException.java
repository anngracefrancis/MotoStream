package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DependencyCycleException extends DependencyException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<n<?>> f18868f;

    public DependencyCycleException(List<n<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f18868f = list;
    }
}
