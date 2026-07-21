package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.p003y.Continuation;
import kotlin.u;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface j<T> {
    T a();

    Object b(T t, OutputStream outputStream, Continuation<? super u> continuation);

    Object c(InputStream inputStream, Continuation<? super T> continuation);
}
