package com.google.gson.t.n;

import com.google.gson.o;
import com.google.gson.q;
import com.google.gson.r;

/* JADX INFO: compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.gson.t.c f20233f;

    public d(com.google.gson.t.c cVar) {
        this.f20233f = cVar;
    }

    q<?> a(com.google.gson.t.c cVar, com.google.gson.e eVar, com.google.gson.u.a<?> aVar, com.google.gson.s.b bVar) {
        q<?> lVar;
        Object objA = cVar.a(com.google.gson.u.a.get((Class) bVar.value())).a();
        if (objA instanceof q) {
            lVar = (q) objA;
        } else if (objA instanceof r) {
            lVar = ((r) objA).b(eVar, aVar);
        } else {
            boolean z = objA instanceof o;
            if (!z && !(objA instanceof com.google.gson.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (o) objA : null, objA instanceof com.google.gson.i ? (com.google.gson.i) objA : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        com.google.gson.s.b bVar = (com.google.gson.s.b) aVar.getRawType().getAnnotation(com.google.gson.s.b.class);
        if (bVar == null) {
            return null;
        }
        return (q<T>) a(this.f20233f, eVar, aVar, bVar);
    }
}
