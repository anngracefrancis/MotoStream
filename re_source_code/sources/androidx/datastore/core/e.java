package androidx.datastore.core;

import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlinx.coroutines.p005z2.Flow;

/* JADX INFO: compiled from: DataStore.kt */
/* JADX INFO: loaded from: classes.dex */
public interface e<T> {
    Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    Flow<T> b();
}
