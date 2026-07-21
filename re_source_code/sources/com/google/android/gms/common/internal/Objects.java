package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class Objects {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public static final class ToStringHelper {
        private final List a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f11993b;

        /* synthetic */ ToStringHelper(Object obj, zzah zzahVar) {
            Preconditions.k(obj);
            this.f11993b = obj;
            this.a = new ArrayList();
        }

        @KeepForSdk
        public ToStringHelper a(String str, Object obj) {
            List list = this.a;
            Preconditions.k(str);
            list.add(str + "=" + String.valueOf(obj));
            return this;
        }

        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f11993b.getClass().getSimpleName());
            sb.append('{');
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) this.a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @KeepForSdk
    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @KeepForSdk
    public static ToStringHelper c(Object obj) {
        return new ToStringHelper(obj, null);
    }
}
