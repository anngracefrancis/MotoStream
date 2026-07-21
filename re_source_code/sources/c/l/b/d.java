package c.l.b;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: PreferencesMapCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final a a = new a(null);

    /* JADX INFO: compiled from: PreferencesMapCompat.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a(InputStream inputStream) throws IOException {
            m.f(inputStream, "input");
            try {
                f fVarQ = f.Q(inputStream);
                m.e(fVarQ, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return fVarQ;
            } catch (InvalidProtocolBufferException e2) {
                throw new CorruptionException("Unable to parse preferences proto.", e2);
            }
        }
    }
}
