package kotlin.reflect.y.internal.j0.j.b;

import kotlin.Pair;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.z.g;

/* JADX INFO: compiled from: ContractDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface j {
    public static final a a = a.a;

    /* JADX INFO: compiled from: ContractDeserializer.kt */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final j f24581b = new C0391a();

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.j.b.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ContractDeserializer.kt */
        public static final class C0391a implements j {
            C0391a() {
            }

            @Override // kotlin.reflect.y.internal.j0.j.b.j
            public Pair a(i iVar, y yVar, g gVar, d0 d0Var) {
                m.f(iVar, "proto");
                m.f(yVar, "ownerFunction");
                m.f(gVar, "typeTable");
                m.f(d0Var, "typeDeserializer");
                return null;
            }
        }

        private a() {
        }

        public final j a() {
            return f24581b;
        }
    }

    Pair<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> a(i iVar, y yVar, g gVar, d0 d0Var);
}
