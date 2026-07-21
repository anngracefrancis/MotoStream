package com.google.android.gms.common.server.response;

import android.os.Parcel;
import cm.aptoide.pt.database.room.RoomInstalled;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
public abstract class FastJsonResponse {

    @ShowFirstParty
    public interface FieldConverter<I, O> {
        I c(O o);
    }

    private static void f(StringBuilder sb, Field field, Object obj) {
        int i2 = field.f12108g;
        if (i2 == 11) {
            sb.append(field.m.cast(obj).toString());
        } else {
            if (i2 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(JsonUtils.a((String) obj));
            sb.append("\"");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <O, I> I g(Field<I, O> field, Object obj) {
        return ((Field) field).p != null ? field.c(obj) : obj;
    }

    @KeepForSdk
    public abstract Map<String, Field<?, ?>> a();

    @KeepForSdk
    protected Object b(Field field) {
        String str = field.f12112k;
        if (field.m == null) {
            return c(str);
        }
        Preconditions.p(c(str) == null, "Concrete field shouldn't be value object: %s", field.f12112k);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String strSubstring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(strSubstring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @KeepForSdk
    protected abstract Object c(String str);

    @KeepForSdk
    protected boolean d(Field field) {
        if (field.f12110i != 11) {
            return e(field.f12112k);
        }
        if (field.f12111j) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @KeepForSdk
    protected abstract boolean e(String str);

    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> mapA = a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapA.keySet()) {
            Field<?, ?> field = mapA.get(str);
            if (d(field)) {
                Object objG = g(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objG != null) {
                    switch (field.f12110i) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.a((byte[]) objG));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.b((byte[]) objG));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.a(sb, (HashMap) objG);
                            break;
                        default:
                            if (field.f12109h) {
                                ArrayList arrayList = (ArrayList) objG;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (i2 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i2);
                                    if (obj != null) {
                                        f(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                f(sb, field, objG);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    @VisibleForTesting
    @SafeParcelable.Class
    @ShowFirstParty
    @KeepForSdk
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zai CREATOR = new zai();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SafeParcelable.VersionField
        private final int f12107f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SafeParcelable.Field
        protected final int f12108g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SafeParcelable.Field
        protected final boolean f12109h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @SafeParcelable.Field
        protected final int f12110i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @SafeParcelable.Field
        protected final boolean f12111j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @SafeParcelable.Field
        protected final String f12112k;

        @SafeParcelable.Field
        protected final int l;
        protected final Class<? extends FastJsonResponse> m;

        @SafeParcelable.Field
        private final String n;
        private zak o;

        @SafeParcelable.Field
        private FieldConverter<I, O> p;

        @SafeParcelable.Constructor
        Field(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) zaa zaaVar) {
            this.f12107f = i2;
            this.f12108g = i3;
            this.f12109h = z;
            this.f12110i = i4;
            this.f12111j = z2;
            this.f12112k = str;
            this.l = i5;
            if (str2 == null) {
                this.m = null;
                this.n = null;
            } else {
                this.m = SafeParcelResponse.class;
                this.n = str2;
            }
            if (zaaVar == null) {
                this.p = null;
            } else {
                this.p = (FieldConverter<I, O>) zaaVar.z();
            }
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> W(String str, int i2, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i2, cls, null);
        }

        private final String X0() {
            String str = this.n;
            if (str == null) {
                return null;
            }
            return str;
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<Integer, Integer> Y(String str, int i2) {
            return new Field<>(0, false, 0, false, str, i2, null, null);
        }

        @KeepForSdk
        public static Field<String, String> e0(String str, int i2) {
            return new Field<>(7, false, 7, false, str, i2, null, null);
        }

        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> i0(String str, int i2) {
            return new Field<>(7, true, 7, true, str, i2, null, null);
        }

        private final zaa q1() {
            FieldConverter<I, O> fieldConverter = this.p;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.y(fieldConverter);
        }

        @VisibleForTesting
        @KeepForSdk
        public static Field<byte[], byte[]> y(String str, int i2) {
            return new Field<>(8, false, 8, false, str, i2, null, null);
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> z(String str, int i2, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i2, cls, null);
        }

        public final void M0(zak zakVar) {
            this.o = zakVar;
        }

        public final boolean a1() {
            return this.p != null;
        }

        public final I c(O o) {
            return this.p.c(o);
        }

        @KeepForSdk
        public int p0() {
            return this.l;
        }

        public final Map<String, Field<?, ?>> r1() {
            Preconditions.k(this.n);
            Preconditions.k(this.o);
            return this.o.W(this.n);
        }

        public String toString() {
            Objects.ToStringHelper toStringHelperA = Objects.c(this).a(RoomInstalled.VERSION_CODE, Integer.valueOf(this.f12107f)).a("typeIn", Integer.valueOf(this.f12108g)).a("typeInArray", Boolean.valueOf(this.f12109h)).a("typeOut", Integer.valueOf(this.f12110i)).a("typeOutArray", Boolean.valueOf(this.f12111j)).a("outputFieldName", this.f12112k).a("safeParcelFieldId", Integer.valueOf(this.l)).a("concreteTypeName", X0());
            Class<? extends FastJsonResponse> cls = this.m;
            if (cls != null) {
                toStringHelperA.a("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.p;
            if (fieldConverter != null) {
                toStringHelperA.a("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return toStringHelperA.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.l(parcel, 1, this.f12107f);
            SafeParcelWriter.l(parcel, 2, this.f12108g);
            SafeParcelWriter.c(parcel, 3, this.f12109h);
            SafeParcelWriter.l(parcel, 4, this.f12110i);
            SafeParcelWriter.c(parcel, 5, this.f12111j);
            SafeParcelWriter.u(parcel, 6, this.f12112k, false);
            SafeParcelWriter.l(parcel, 7, p0());
            SafeParcelWriter.u(parcel, 8, X0(), false);
            SafeParcelWriter.s(parcel, 9, q1(), i2, false);
            SafeParcelWriter.b(parcel, iA);
        }

        private Field(int i2, boolean z, int i3, boolean z2, String str, int i4, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            this.f12107f = 1;
            this.f12108g = i2;
            this.f12109h = z;
            this.f12110i = i3;
            this.f12111j = z2;
            this.f12112k = str;
            this.l = i4;
            this.m = cls;
            if (cls == null) {
                this.n = null;
            } else {
                this.n = cls.getCanonicalName();
            }
            this.p = fieldConverter;
        }
    }
}
