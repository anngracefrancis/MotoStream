package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.a0.d.m0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: TypeParameterReference.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "variance", "Lkotlin/reflect/KVariance;", "isReified", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "setUpperBounds", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypeParameterReference implements KTypeParameter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22947f = new a(null);

    /* JADX INFO: renamed from: kotlin.a0.d.m0$a */
    /* JADX INFO: compiled from: TypeParameterReference.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: kotlin.a0.d.m0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TypeParameterReference.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class C0312a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(KTypeParameter kTypeParameter) {
            m.f(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i2 = C0312a.a[kTypeParameter.n().ordinal()];
            if (i2 == 2) {
                sb.append("in ");
            } else if (i2 == 3) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String string = sb.toString();
            m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
