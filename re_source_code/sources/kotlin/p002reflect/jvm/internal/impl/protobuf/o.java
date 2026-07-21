package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: MessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public interface o extends p {

    /* JADX INFO: compiled from: MessageLite.java */
    public interface a extends Cloneable, p {
        a W(e eVar, f fVar) throws IOException;

        o c();
    }

    a d();

    int e();

    a f();

    q<? extends o> g();

    void h(CodedOutputStream codedOutputStream) throws IOException;
}
