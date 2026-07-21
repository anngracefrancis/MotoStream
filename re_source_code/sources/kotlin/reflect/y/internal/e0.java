package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {RoomInstalled.SIGNATURE, HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class e0 {

    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends Lambda implements Function1<Class<?>, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23041f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Class<?> cls) {
            m.e(cls, "it");
            return d.b(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        m.e(parameterTypes, "parameterTypes");
        sb.append(n.I(parameterTypes, HttpUrl.FRAGMENT_ENCODE_SET, "(", ")", 0, null, a.f23041f, 24, null));
        Class<?> returnType = method.getReturnType();
        m.e(returnType, "returnType");
        sb.append(d.b(returnType));
        return sb.toString();
    }
}
