package com.facebook.o0;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PersistedEvents.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10129f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<t, List<v>> f10130g;

    /* JADX INFO: compiled from: PersistedEvents.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: PersistedEvents.kt */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10131f = new a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HashMap<t, List<v>> f10132g;

        /* JADX INFO: compiled from: PersistedEvents.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(HashMap<t, List<v>> map) {
            kotlin.jvm.internal.m.f(map, "proxyEvents");
            this.f10132g = map;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new h0(this.f10132g);
        }
    }

    public h0() {
        this.f10130g = new HashMap<>();
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new b(this.f10130g);
    }

    public final void a(t tVar, List<v> list) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        kotlin.jvm.internal.m.f(list, "appEvents");
        if (!this.f10130g.containsKey(tVar)) {
            this.f10130g.put(tVar, kotlin.collections.c0.G0(list));
            return;
        }
        List<v> list2 = this.f10130g.get(tVar);
        if (list2 == null) {
            return;
        }
        list2.addAll(list);
    }

    public final Set<Map.Entry<t, List<v>>> b() {
        Set<Map.Entry<t, List<v>>> setEntrySet = this.f10130g.entrySet();
        kotlin.jvm.internal.m.e(setEntrySet, "events.entries");
        return setEntrySet;
    }

    public h0(HashMap<t, List<v>> map) {
        kotlin.jvm.internal.m.f(map, "appEventMap");
        HashMap<t, List<v>> map2 = new HashMap<>();
        this.f10130g = map2;
        map2.putAll(map);
    }
}
