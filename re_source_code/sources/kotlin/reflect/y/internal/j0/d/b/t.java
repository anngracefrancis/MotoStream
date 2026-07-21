package kotlin.reflect.y.internal.j0.d.b;

import cm.aptoide.pt.database.room.RoomInstalled;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.a0.b.d;
import kotlin.reflect.y.internal.j0.e.z.c;

/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23819b;

    /* JADX INFO: compiled from: MemberSignature.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final t a(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "desc");
            return new t(str + '#' + str2, null);
        }

        public final t b(d dVar) {
            m.f(dVar, RoomInstalled.SIGNATURE);
            if (dVar instanceof d.b) {
                return d(dVar.c(), dVar.b());
            }
            if (dVar instanceof d.a) {
                return a(dVar.c(), dVar.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final t c(c cVar, kotlin.f0.y.e.j0.e.a0.a.c cVar2) {
            m.f(cVar, "nameResolver");
            m.f(cVar2, RoomInstalled.SIGNATURE);
            return d(cVar.getString(cVar2.x()), cVar.getString(cVar2.w()));
        }

        public final t d(String str, String str2) {
            m.f(str, "name");
            m.f(str2, "desc");
            return new t(str + str2, null);
        }

        public final t e(t tVar, int i2) {
            m.f(tVar, RoomInstalled.SIGNATURE);
            return new t(tVar.a() + '@' + i2, null);
        }
    }

    private t(String str) {
        this.f23819b = str;
    }

    public /* synthetic */ t(String str, g gVar) {
        this(str);
    }

    public final String a() {
        return this.f23819b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && m.a(this.f23819b, ((t) obj).f23819b);
    }

    public int hashCode() {
        return this.f23819b.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f23819b + ')';
    }
}
