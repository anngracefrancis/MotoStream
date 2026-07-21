package androidx.datastore.core;

import kotlin.p003y.Continuation;
import kotlin.u;

/* JADX INFO: compiled from: DataMigration.kt */
/* JADX INFO: loaded from: classes.dex */
public interface c<T> {
    Object a(Continuation<? super u> continuation);

    Object b(T t, Continuation<? super Boolean> continuation);

    Object c(T t, Continuation<? super T> continuation);
}
