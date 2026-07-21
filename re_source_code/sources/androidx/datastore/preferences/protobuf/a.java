package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.a.AbstractC0032a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0032a<MessageType, BuilderType>> implements q0 {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractMessageLite.java */
    public static abstract class AbstractC0032a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0032a<MessageType, BuilderType>> implements q0.a {
        protected static <T> void j(Iterable<T> iterable, List<? super T> list) {
            a0.a(iterable);
            if (!(iterable instanceof f0)) {
                if (iterable instanceof z0) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    k(iterable, list);
                    return;
                }
            }
            List<?> listJ = ((f0) iterable).j();
            f0 f0Var = (f0) list;
            int size = list.size();
            for (Object obj : listJ) {
                if (obj == null) {
                    String str = "Element at index " + (f0Var.size() - size) + " is null.";
                    for (int size2 = f0Var.size() - 1; size2 >= size; size2--) {
                        f0Var.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof h) {
                    f0Var.a0((h) obj);
                } else {
                    f0Var.add((String) obj);
                }
            }
        }

        private static <T> void k(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t);
            }
        }

        protected static UninitializedMessageException n(q0 q0Var) {
            return new UninitializedMessageException(q0Var);
        }

        protected abstract BuilderType l(MessageType messagetype);

        @Override // androidx.datastore.preferences.protobuf.q0.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public BuilderType z(q0 q0Var) {
            if (b().getClass().isInstance(q0Var)) {
                return (BuilderType) l((a) q0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        AbstractC0032a.j(iterable, list);
    }

    private String l(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    public h h() {
        try {
            h.C0033h c0033hU = h.u(e());
            i(c0033hU.b());
            return c0033hU.a();
        } catch (IOException e2) {
            throw new RuntimeException(l("ByteString"), e2);
        }
    }

    int j() {
        throw new UnsupportedOperationException();
    }

    int k(f1 f1Var) {
        int iJ = j();
        if (iJ != -1) {
            return iJ;
        }
        int i2 = f1Var.i(this);
        n(i2);
        return i2;
    }

    UninitializedMessageException m() {
        return new UninitializedMessageException(this);
    }

    void n(int i2) {
        throw new UnsupportedOperationException();
    }

    public void o(OutputStream outputStream) throws IOException {
        CodedOutputStream codedOutputStreamF0 = CodedOutputStream.f0(outputStream, CodedOutputStream.I(e()));
        i(codedOutputStreamF0);
        codedOutputStreamF0.c0();
    }
}
