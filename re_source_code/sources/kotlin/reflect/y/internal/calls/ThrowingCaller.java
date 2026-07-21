package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.j, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ThrowingCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", HttpUrl.FRAGMENT_ENCODE_SET, "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThrowingCaller implements Caller {
    public static final ThrowingCaller a = new ThrowingCaller();

    private ThrowingCaller() {
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public List<Type> a() {
        return u.j();
    }

    public Void b() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public Object call(Object[] args) {
        m.f(args, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) b();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public Type getReturnType() {
        Class cls = Void.TYPE;
        m.e(cls, "TYPE");
        return cls;
    }
}
