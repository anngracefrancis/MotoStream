package cm.aptoide.pt;

import cm.aptoide.analytics.implementation.EventsPersistence;
import cm.aptoide.pt.database.RoomEventMapper;
import cm.aptoide.pt.database.room.AptoideDatabase;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesEventsPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> aptoideDatabaseProvider;
    private final Provider<RoomEventMapper> mapperProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesEventsPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomEventMapper> provider2) {
        this.module = applicationModule;
        this.aptoideDatabaseProvider = provider;
        this.mapperProvider = provider2;
    }

    public static ApplicationModule_ProvidesEventsPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<RoomEventMapper> provider2) {
        return new ApplicationModule_ProvidesEventsPersistenceFactory(applicationModule, provider, provider2);
    }

    public static EventsPersistence providesEventsPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase, RoomEventMapper roomEventMapper) {
        return (EventsPersistence) f.b.b.c(applicationModule.providesEventsPersistence(aptoideDatabase, roomEventMapper));
    }

    @Override // javax.inject.Provider
    public EventsPersistence get() {
        return providesEventsPersistence(this.module, this.aptoideDatabaseProvider.get(), this.mapperProvider.get());
    }
}
