package kotlin.jvm.internal;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.a0.d.u, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PackageReference implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f22948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22949g;

    public PackageReference(Class<?> cls, String str) {
        m.f(cls, "jClass");
        m.f(str, "moduleName");
        this.f22948f = cls;
        this.f22949g = str;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> a() {
        return this.f22948f;
    }

    public boolean equals(Object other) {
        return (other instanceof PackageReference) && m.a(a(), ((PackageReference) other).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
