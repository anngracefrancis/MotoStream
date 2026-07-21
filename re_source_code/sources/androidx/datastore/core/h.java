package androidx.datastore.core;

import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;

/* JADX INFO: compiled from: InitializerApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface h<T> {
    Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);
}
