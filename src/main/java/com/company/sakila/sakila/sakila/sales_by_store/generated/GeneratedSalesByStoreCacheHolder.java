package com.company.sakila.sakila.sakila.sales_by_store.generated;

import com.company.sakila.sakila.sakila.sales_by_store.SalesByStore;
import com.company.sakila.sakila.sakila.sales_by_store.SalesByStoreEntityStoreSerializerImpl;
import com.company.sakila.sakila.sakila.sales_by_store.SalesByStoreManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.datastore.runtime.HasStatistics.Statistics;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStore;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreHolder;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfComparable;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfString;
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

import java.math.BigDecimal;
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
 * SalesByStoreManager}.
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
public final class GeneratedSalesByStoreCacheHolder implements EntityStoreHolder<SalesByStore> {
    
    private final EntityStore<SalesByStore> entityStore;
    private final OfString fieldStoreCache;
    private final OfString fieldManagerCache;
    private final OfComparable<BigDecimal> fieldTotalSalesCache;
    
    public GeneratedSalesByStoreCacheHolder(
            EntityStore<SalesByStore> entityStore,
            OfString fieldStoreCache,
            OfString fieldManagerCache,
            OfComparable<BigDecimal> fieldTotalSalesCache) {
        
        this.entityStore          = requireNonNull(entityStore);
        this.fieldStoreCache      = requireNonNull(fieldStoreCache);
        this.fieldManagerCache    = requireNonNull(fieldManagerCache);
        this.fieldTotalSalesCache = requireNonNull(fieldTotalSalesCache);
    }
    
    @Override
    public EntityStore<SalesByStore> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<SalesByStore> columnId) {
        if (columnId instanceof SalesByStore.Identifier) {
            final SalesByStore.Identifier _id = (SalesByStore.Identifier) columnId;
            switch (_id) {
                case STORE       : return (CACHE) fieldStoreCache;
                case MANAGER     : return (CACHE) fieldManagerCache;
                case TOTAL_SALES : return (CACHE) fieldTotalSalesCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = columnId.getColumnId();
            switch (_colName) {
                case "store"       : return (CACHE) fieldStoreCache;
                case "manager"     : return (CACHE) fieldManagerCache;
                case "total_sales" : return (CACHE) fieldTotalSalesCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<SalesByStore> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedSalesByStoreCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            SalesByStoreEntityStoreSerializerImpl::new,
            TableIdentifier.of("sakila", "sakila", "sales_by_store")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<SalesByStore> recycleAndPersist(PersistOperation<SalesByStore> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<SalesByStore> recycleAndRemove(RemoveOperation<SalesByStore> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<SalesByStore> recycleAndUpdate(UpdateOperation<SalesByStore> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<SalesByStore> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<SalesByStore>, FieldCache<?>>>of(
            Tuples.of(SalesByStore.STORE,      fieldStoreCache),
            Tuples.of(SalesByStore.MANAGER,    fieldManagerCache),
            Tuples.of(SalesByStore.TOTAL_SALES,fieldTotalSalesCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<SalesByStore>> columnIdentifiers = Stream.<HasIdentifier<SalesByStore>>of(
            SalesByStore.STORE,
            SalesByStore.MANAGER,
            SalesByStore.TOTAL_SALES
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
    
    public static CompletableFuture<GeneratedSalesByStoreCacheHolder> reload(CompletableFuture<EntityStore<SalesByStore>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfString> fieldStoreCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, SalesByStore.STORE, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldManagerCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, SalesByStore.MANAGER, 0);
        
        final CompletableFuture<FieldCache.OfComparable<BigDecimal>> fieldTotalSalesCacheFuture =
            DataStoreHolderUtil.buildComparableCache(entityStoreFuture, executor, SalesByStore.TOTAL_SALES, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedSalesByStoreCacheHolder(
                    entityStore,
                    fieldStoreCacheFuture.get(),
                    fieldManagerCacheFuture.get(),
                    fieldTotalSalesCacheFuture.get()
                );
            } catch (final ExecutionException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    
    @Override
    public void close() {
        entityStore.close();
        fieldStoreCache.close();
        fieldManagerCache.close();
        fieldTotalSalesCache.close();
    }
    
    @Override
    public Map<String, Map<Statistics, ?>> getStatistics() {
        return StatisticsUtil.getStatistics(    
            this,
            entityStore.identifier(),
            SalesByStore.Identifier.STORE,
            SalesByStore.Identifier.MANAGER,
            SalesByStore.Identifier.TOTAL_SALES
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}