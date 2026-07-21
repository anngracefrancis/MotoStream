package kotlin.reflect.y.internal.j0.m;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.jvm.internal.m;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n<K, V, T extends V> extends a.AbstractC0401a<K, V, T> implements ReadOnlyProperty<a<K, V>, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(KClass<? extends K> kClass, int i2) {
        super(kClass, i2);
        m.f(kClass, RoomNotification.KEY);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public T a(a<K, V> aVar, KProperty<?> kProperty) {
        m.f(aVar, "thisRef");
        m.f(kProperty, "property");
        return c(aVar);
    }
}
