package com.company.sakila.sakila.sakila.inventory.generated;

import com.company.sakila.sakila.sakila.inventory.Inventory;
import com.company.sakila.sakila.sakila.inventory.InventoryEntityStoreSerializerImpl;
import com.company.sakila.sakila.sakila.inventory.InventoryManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.datastore.runtime.HasStatistics.Statistics;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStore;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreHolder;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfComparable;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfInt;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfShort;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache;
import com.speedment.enterprise.datastore.runtime.fieldcache.MultiFieldCache;
import com.speedment.enterprise.datastore.runtime.util.DataStoreHolderUtil;
import com.speedment.enterprise.datastore.runtime.util.StatisticsUtil;
import com.speedment.runtime.bulk.PersistOperation;
import com.speedment.runtime.bulk.RemoveOperation;
import com.speedment.runtime.bulk.UpdateOperation;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.ColumnLabel;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.StreamSupplierComponent;
import com.speedment.runtime.field.Field;
import com.speedment.runtime.field.trait.HasIdentifier;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * A holder class for the various caches that are used to speed up the {@link
 * InventoryManager}.
 * 
 * Generated by
 * com.speedment.enterprise.datastore.generator.internal.code.GeneratedEntityCacheHolderTranslator
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public final class GeneratedInventoryCacheHolder implements EntityStoreHolder<Inventory> {
    
    private final EntityStore<Inventory> entityStore;
    private final OfInt fieldInventoryIdCache;
    private final OfInt fieldFilmIdCache;
    private final OfShort fieldStoreIdCache;
    private final OfComparable<Timestamp> fieldLastUpdateCache;
    
    public GeneratedInventoryCacheHolder(
            EntityStore<Inventory> entityStore,
            OfInt fieldInventoryIdCache,
            OfInt fieldFilmIdCache,
            OfShort fieldStoreIdCache,
            OfComparable<Timestamp> fieldLastUpdateCache) {
        
        this.entityStore           = requireNonNull(entityStore);
        this.fieldInventoryIdCache = requireNonNull(fieldInventoryIdCache);
        this.fieldFilmIdCache      = requireNonNull(fieldFilmIdCache);
        this.fieldStoreIdCache     = requireNonNull(fieldStoreIdCache);
        this.fieldLastUpdateCache  = requireNonNull(fieldLastUpdateCache);
    }
    
    @Override
    public EntityStore<Inventory> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<Inventory> columnId) {
        if (columnId instanceof Inventory.Identifier) {
            final Inventory.Identifier _id = (Inventory.Identifier) columnId;
            switch (_id) {
                case INVENTORY_ID : return (CACHE) fieldInventoryIdCache;
                case FILM_ID      : return (CACHE) fieldFilmIdCache;
                case STORE_ID     : return (CACHE) fieldStoreIdCache;
                case LAST_UPDATE  : return (CACHE) fieldLastUpdateCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = columnId.getColumnId();
            switch (_colName) {
                case "inventory_id" : return (CACHE) fieldInventoryIdCache;
                case "film_id"      : return (CACHE) fieldFilmIdCache;
                case "store_id"     : return (CACHE) fieldStoreIdCache;
                case "last_update"  : return (CACHE) fieldLastUpdateCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<Inventory> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedInventoryCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            InventoryEntityStoreSerializerImpl::new,
            TableIdentifier.of("sakila", "sakila", "inventory")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<Inventory> recycleAndPersist(PersistOperation<Inventory> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<Inventory> recycleAndRemove(RemoveOperation<Inventory> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<Inventory> recycleAndUpdate(UpdateOperation<Inventory> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<Inventory> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<Inventory>, FieldCache<?>>>of(
            Tuples.of(Inventory.INVENTORY_ID,fieldInventoryIdCache),
            Tuples.of(Inventory.FILM_ID,     fieldFilmIdCache),
            Tuples.of(Inventory.STORE_ID,    fieldStoreIdCache),
            Tuples.of(Inventory.LAST_UPDATE, fieldLastUpdateCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<Inventory>> columnIdentifiers = Stream.<HasIdentifier<Inventory>>of(
            Inventory.INVENTORY_ID,
            Inventory.FILM_ID,
            Inventory.STORE_ID,
            Inventory.LAST_UPDATE
        )
            .map(HasIdentifier::identifier)
            .collect(toSet());
        return EntityStoreHolder.of(
            entityStore,
            fieldCaches,
            multiFieldCaches,
            columnIdentifiers
        );
    }
    
    public static CompletableFuture<GeneratedInventoryCacheHolder> reload(CompletableFuture<EntityStore<Inventory>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldInventoryIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Inventory.INVENTORY_ID, FieldCache.DISTINCT);
        
        final CompletableFuture<FieldCache.OfInt> fieldFilmIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Inventory.FILM_ID, 0);
        
        final CompletableFuture<FieldCache.OfShort> fieldStoreIdCacheFuture =
            DataStoreHolderUtil.buildShortCache(entityStoreFuture, executor, Inventory.STORE_ID, 0);
        
        final CompletableFuture<FieldCache.OfComparable<Timestamp>> fieldLastUpdateCacheFuture =
            DataStoreHolderUtil.buildComparableCache(entityStoreFuture, executor, Inventory.LAST_UPDATE, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedInventoryCacheHolder(
                    entityStore,
                    fieldInventoryIdCacheFuture.get(),
                    fieldFilmIdCacheFuture.get(),
                    fieldStoreIdCacheFuture.get(),
                    fieldLastUpdateCacheFuture.get()
                );
            } catch (final ExecutionException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    
    @Override
    public void close() {
        entityStore.close();
        fieldInventoryIdCache.close();
        fieldFilmIdCache.close();
        fieldStoreIdCache.close();
        fieldLastUpdateCache.close();
    }
    
    @Override
    public Map<String, Map<Statistics, ?>> getStatistics() {
        return StatisticsUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Inventory.Identifier.INVENTORY_ID,
            Inventory.Identifier.FILM_ID,
            Inventory.Identifier.STORE_ID,
            Inventory.Identifier.LAST_UPDATE
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}