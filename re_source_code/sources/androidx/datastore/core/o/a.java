package androidx.datastore.core.o;

import androidx.datastore.core.CorruptionException;
import kotlin.p003y.Continuation;

/* JADX INFO: compiled from: NoOpCorruptionHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements androidx.datastore.core.a<T> {
    @Override // androidx.datastore.core.a
    public Object a(CorruptionException corruptionException, Continuation<? super T> continuation) throws CorruptionException {
        throw corruptionException;
    }
}
