package com.squareup.moshi.x.reflect;

import cm.aptoide.pt.database.room.RoomNotification;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import com.squareup.moshi.w.c;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.squareup.moshi.x.a.a, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: KotlinJsonAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002 !BU\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006\u0012\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R'\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "constructor", "Lkotlin/reflect/KFunction;", "allBindings", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", HttpUrl.FRAGMENT_ENCODE_SET, "nonIgnoredBindings", "options", "Lcom/squareup/moshi/JsonReader$Options;", "(Lkotlin/reflect/KFunction;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonReader$Options;)V", "getAllBindings", "()Ljava/util/List;", "getConstructor", "()Lkotlin/reflect/KFunction;", "getNonIgnoredBindings", "getOptions", "()Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "toJson", HttpUrl.FRAGMENT_ENCODE_SET, "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "Binding", "IndexedParameterMap", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinJsonAdapter<T> extends f<T> {
    private final KFunction<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Binding<T, Object>> f20641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Binding<T, Object>> f20642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i.a f20643d;

    /* JADX INFO: renamed from: com.squareup.moshi.x.a.a$a, reason: from toString */
    /* JADX INFO: compiled from: KotlinJsonAdapter.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\rHÆ\u0003J[\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\u0013\u0010\"\u001a\u00028\u00022\u0006\u0010#\u001a\u00028\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\rHÖ\u0001J\u001b\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u00012\u0006\u0010#\u001a\u00028\u0002¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "K", "P", HttpUrl.FRAGMENT_ENCODE_SET, "jsonName", HttpUrl.FRAGMENT_ENCODE_SET, "adapter", "Lcom/squareup/moshi/JsonAdapter;", "property", "Lkotlin/reflect/KProperty1;", MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "Lkotlin/reflect/KParameter;", "propertyIndex", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KParameter;I)V", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "getJsonName", "()Ljava/lang/String;", "getParameter", "()Lkotlin/reflect/KParameter;", "getProperty", "()Lkotlin/reflect/KProperty1;", "getPropertyIndex", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "get", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "set", HttpUrl.FRAGMENT_ENCODE_SET, "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final /* data */ class Binding<K, P> {

        /* JADX INFO: renamed from: a, reason: from toString */
        private final String jsonName;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
        private final f<P> adapter;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
        private final KProperty1<K, P> property;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from toString */
        private final KParameter parameter;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from toString */
        private final int propertyIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public Binding(String str, f<P> fVar, KProperty1<K, ? extends P> kProperty1, KParameter kParameter, int i2) {
            m.f(str, "jsonName");
            m.f(fVar, "adapter");
            m.f(kProperty1, "property");
            this.jsonName = str;
            this.adapter = fVar;
            this.property = kProperty1;
            this.parameter = kParameter;
            this.propertyIndex = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Binding b(Binding binding, String str, f fVar, KProperty1 kProperty1, KParameter kParameter, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = binding.jsonName;
            }
            if ((i3 & 2) != 0) {
                fVar = binding.adapter;
            }
            f fVar2 = fVar;
            if ((i3 & 4) != 0) {
                kProperty1 = binding.property;
            }
            KProperty1 kProperty2 = kProperty1;
            if ((i3 & 8) != 0) {
                kParameter = binding.parameter;
            }
            KParameter kParameter2 = kParameter;
            if ((i3 & 16) != 0) {
                i2 = binding.propertyIndex;
            }
            return binding.a(str, fVar2, kProperty2, kParameter2, i2);
        }

        public final Binding<K, P> a(String str, f<P> fVar, KProperty1<K, ? extends P> kProperty1, KParameter kParameter, int i2) {
            m.f(str, "jsonName");
            m.f(fVar, "adapter");
            m.f(kProperty1, "property");
            return new Binding<>(str, fVar, kProperty1, kParameter, i2);
        }

        public final P c(K k2) {
            return this.property.get(k2);
        }

        public final f<P> d() {
            return this.adapter;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getJsonName() {
            return this.jsonName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Binding)) {
                return false;
            }
            Binding binding = (Binding) other;
            return m.a(this.jsonName, binding.jsonName) && m.a(this.adapter, binding.adapter) && m.a(this.property, binding.property) && m.a(this.parameter, binding.parameter) && this.propertyIndex == binding.propertyIndex;
        }

        public final KProperty1<K, P> f() {
            return this.property;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final int getPropertyIndex() {
            return this.propertyIndex;
        }

        public final void h(K k2, P p) {
            if (p != c.f20650b) {
                KProperty1<K, P> kProperty1 = this.property;
                m.d(kProperty1, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K of com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding, P of com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding>");
                ((KMutableProperty1) kProperty1).s(k2, p);
            }
        }

        public int hashCode() {
            int iHashCode = ((((this.jsonName.hashCode() * 31) + this.adapter.hashCode()) * 31) + this.property.hashCode()) * 31;
            KParameter kParameter = this.parameter;
            return ((iHashCode + (kParameter == null ? 0 : kParameter.hashCode())) * 31) + this.propertyIndex;
        }

        public String toString() {
            return "Binding(jsonName=" + this.jsonName + ", adapter=" + this.adapter + ", property=" + this.property + ", parameter=" + this.parameter + ", propertyIndex=" + this.propertyIndex + ')';
        }
    }

    /* JADX INFO: renamed from: com.squareup.moshi.x.a.a$b */
    /* JADX INFO: compiled from: KotlinJsonAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016R(\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$IndexedParameterMap;", "Lkotlin/collections/AbstractMutableMap;", "Lkotlin/reflect/KParameter;", HttpUrl.FRAGMENT_ENCODE_SET, "parameterKeys", HttpUrl.FRAGMENT_ENCODE_SET, "parameterValues", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/List;[Ljava/lang/Object;)V", "entries", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getEntries", "()Ljava/util/Set;", "[Ljava/lang/Object;", "containsKey", HttpUrl.FRAGMENT_ENCODE_SET, RoomNotification.KEY, "get", "put", "value", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends AbstractMutableMap<KParameter, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<KParameter> f20648f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Object[] f20649g;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends KParameter> list, Object[] objArr) {
            m.f(list, "parameterKeys");
            m.f(objArr, "parameterValues");
            this.f20648f = list;
            this.f20649g = objArr;
        }

        @Override // kotlin.collections.AbstractMutableMap
        public Set<Map.Entry<KParameter, Object>> a() {
            List<KParameter> list = this.f20648f;
            ArrayList arrayList = new ArrayList(v.u(list, 10));
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    u.t();
                }
                arrayList.add(new AbstractMap.SimpleEntry((KParameter) t, this.f20649g[i2]));
                i2 = i3;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : arrayList) {
                if (((AbstractMap.SimpleEntry) t2).getValue() != c.f20650b) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof KParameter) {
                return e((KParameter) obj);
            }
            return false;
        }

        public boolean e(KParameter kParameter) {
            m.f(kParameter, RoomNotification.KEY);
            return this.f20649g[kParameter.g()] != c.f20650b;
        }

        public Object f(KParameter kParameter) {
            m.f(kParameter, RoomNotification.KEY);
            Object obj = this.f20649g[kParameter.g()];
            if (obj != c.f20650b) {
                return obj;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof KParameter) {
                return f((KParameter) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof KParameter) ? obj2 : h((KParameter) obj, obj2);
        }

        public /* bridge */ Object h(KParameter kParameter, Object obj) {
            return super.getOrDefault(kParameter, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object put(KParameter kParameter, Object obj) {
            m.f(kParameter, RoomNotification.KEY);
            return null;
        }

        public /* bridge */ Object j(KParameter kParameter) {
            return super.remove(kParameter);
        }

        public /* bridge */ boolean k(KParameter kParameter, Object obj) {
            return super.remove(kParameter, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof KParameter) {
                return j((KParameter) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj instanceof KParameter) {
                return k((KParameter) obj, obj2);
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinJsonAdapter(KFunction<? extends T> kFunction, List<Binding<T, Object>> list, List<Binding<T, Object>> list2, i.a aVar) {
        m.f(kFunction, "constructor");
        m.f(list, "allBindings");
        m.f(list2, "nonIgnoredBindings");
        m.f(aVar, "options");
        this.a = kFunction;
        this.f20641b = list;
        this.f20642c = list2;
        this.f20643d = aVar;
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        m.f(iVar, "reader");
        int size = this.a.getParameters().size();
        int size2 = this.f20641b.size();
        Object[] objArr = new Object[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            objArr[i2] = c.f20650b;
        }
        iVar.b();
        while (iVar.f()) {
            int iH = iVar.H(this.f20643d);
            if (iH == -1) {
                iVar.N();
                iVar.Q();
            } else {
                Binding<T, Object> binding = this.f20642c.get(iH);
                int propertyIndex = binding.getPropertyIndex();
                if (objArr[propertyIndex] != c.f20650b) {
                    throw new JsonDataException("Multiple values for '" + binding.f().getM() + "' at " + iVar.g());
                }
                objArr[propertyIndex] = binding.d().fromJson(iVar);
                if (objArr[propertyIndex] == null && !binding.f().getReturnType().e()) {
                    JsonDataException jsonDataExceptionV = c.v(binding.f().getM(), binding.getJsonName(), iVar);
                    m.e(jsonDataExceptionV, "unexpectedNull(\n        …         reader\n        )");
                    throw jsonDataExceptionV;
                }
            }
        }
        iVar.d();
        boolean z = this.f20641b.size() == size;
        for (int i3 = 0; i3 < size; i3++) {
            if (objArr[i3] == c.f20650b) {
                if (this.a.getParameters().get(i3).k()) {
                    z = false;
                } else {
                    if (!this.a.getParameters().get(i3).getType().e()) {
                        String name = this.a.getParameters().get(i3).getName();
                        Binding<T, Object> binding2 = this.f20641b.get(i3);
                        JsonDataException jsonDataExceptionN = c.n(name, binding2 != null ? binding2.getJsonName() : null, iVar);
                        m.e(jsonDataExceptionN, "missingProperty(\n       …       reader\n          )");
                        throw jsonDataExceptionN;
                    }
                    objArr[i3] = null;
                }
            }
        }
        T tCall = z ? this.a.call(Arrays.copyOf(objArr, size2)) : this.a.callBy(new b(this.a.getParameters(), objArr));
        int size3 = this.f20641b.size();
        while (size < size3) {
            Binding binding3 = this.f20641b.get(size);
            m.c(binding3);
            binding3.h(tCall, objArr[size]);
            size++;
        }
        return tCall;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        m.f(oVar, "writer");
        if (t == null) {
            throw new NullPointerException("value == null");
        }
        oVar.b();
        for (Binding<T, Object> binding : this.f20641b) {
            if (binding != null) {
                oVar.l(binding.getJsonName());
                binding.d().toJson(oVar, binding.c(t));
            }
        }
        oVar.e();
    }

    public String toString() {
        return "KotlinJsonAdapter(" + this.a.getReturnType() + ')';
    }
}
