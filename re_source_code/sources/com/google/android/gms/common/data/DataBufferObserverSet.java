package com.google.android.gms.common.data;

import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> a = new HashSet<>();
}
