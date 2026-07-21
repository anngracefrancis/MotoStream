package kotlinx.coroutines.internal;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000bH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/ClassValueCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cache", "kotlinx/coroutines/internal/ClassValueCtorCache$cache$1", "Lkotlinx/coroutines/internal/ClassValueCtorCache$cache$1;", "get", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/Ctor;", RoomNotification.KEY, "Ljava/lang/Class;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@IgnoreJRERequirement
final class ClassValueCtorCache extends CtorCache {
    public static final ClassValueCtorCache a = new ClassValueCtorCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f25793b = new a();

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.d$a */
    /* JADX INFO: compiled from: ExceptionsConstructor.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00040\u0001J(\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0002`\u00042\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"kotlinx/coroutines/internal/ClassValueCtorCache$cache$1", "Ljava/lang/ClassValue;", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/Ctor;", "computeValue", "type", "Ljava/lang/Class;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ClassValue<Function1<? super Throwable, ? extends Throwable>> {
        a() {
        }
    }

    private ClassValueCtorCache() {
    }

    @Override // kotlinx.coroutines.internal.CtorCache
    public Function1<Throwable, Throwable> a(Class<? extends Throwable> cls) {
        return (Function1) f25793b.get(cls);
    }
}
