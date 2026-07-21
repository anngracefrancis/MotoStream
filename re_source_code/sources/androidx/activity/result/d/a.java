package androidx.activity.result.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: ActivityResultContract.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: androidx.activity.result.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityResultContract.java */
    public static final class C0008a<T> {

        @SuppressLint({"UnknownNullness"})
        private final T a;

        public C0008a(@SuppressLint({"UnknownNullness"}) T t) {
            this.a = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T a() {
            return this.a;
        }
    }

    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i2);

    public C0008a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i2) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O c(int i2, Intent intent);
}
