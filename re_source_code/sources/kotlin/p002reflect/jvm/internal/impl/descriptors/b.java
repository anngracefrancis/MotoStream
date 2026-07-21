package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

/* JADX INFO: compiled from: CallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends kotlin.p002reflect.jvm.internal.impl.descriptors.a, c0 {

    /* JADX INFO: compiled from: CallableMemberDescriptor.java */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean g() {
            return this != FAKE_OVERRIDE;
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    b a();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    Collection<? extends b> e();

    a i();

    b k0(m mVar, d0 d0Var, u uVar, a aVar, boolean z);

    void x0(Collection<? extends b> collection);
}
