package com.company.sakila.sakila.sakila.language.generated;

import com.company.sakila.sakila.sakila.language.Language;
import com.company.sakila.sakila.sakila.language.LanguageImpl;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.function.BiLongToIntFunction;
import com.speedment.common.function.LongToBooleanFunction;
import com.speedment.common.function.LongToByteFunction;
import com.speedment.common.function.LongToCharFunction;
import com.speedment.common.function.LongToFloatFunction;
import com.speedment.common.function.LongToShortFunction;
import com.speedment.enterprise.common.bytebuffercommon.ByteBufferUtil;
import com.speedment.enterprise.datastore.runtime.DataStoreHolder;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStoreComparator;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStoreCompareTo;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStorePredicate;
import com.speedment.enterprise.datastore.runtime.internal.throwable.Utf8Exception;
import com.speedment.enterprise.datastore.runtime.throwable.DeserializationException;
import com.speedment.enterprise.datastore.runtime.util.SerializerUtil;
import com.speedment.enterprise.datastore.runtime.util.Utf8Util;
import com.speedment.runtime.config.identifier.ColumnIdentifier;

import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 * Serializes and deserializes instances of Language.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedLanguageEntityStoreSerializerImpl implements EntityStoreSerializer<Language> {
    
    private final LongFunction<ByteBuffer> bufferFinder;
    private final LongToIntFunction offsetFinder;
    private final static int FIELD_LANGUAGE_ID = 0;
    private final static int FIELD_LAST_UPDATE = 2;
    private final static int ENDPOS_NAME = 10;
    private final static int VARSIZE_BEGINS = 14;
    
    protected GeneratedLanguageEntityStoreSerializerImpl(final LongFunction<ByteBuffer> bufferFinder, final LongToIntFunction offsetFinder) {
        this.bufferFinder = requireNonNull(bufferFinder);
        this.offsetFinder = requireNonNull(offsetFinder);
    }
    
    @Override
    public BiConsumer<ByteBuffer, Language> serializer() {
        return (buffer, entity) -> {
            int varSizePos = 0;
            buffer.putShort(FIELD_LANGUAGE_ID, entity.getLanguageId());
            buffer.putLong(FIELD_LAST_UPDATE, entity.getLastUpdate().getTime());
            varSizePos += ByteBufferUtil.putArrayAbsolute(buffer, VARSIZE_BEGINS + varSizePos, entity.getName().getBytes());
            buffer.putInt(ENDPOS_NAME, varSizePos);
            buffer.position(0);
            buffer.limit(VARSIZE_BEGINS + varSizePos);
        };
    }
    
    @Override
    public LongConsumer decorator(DataStoreHolder holder) {
        return DO_NOTHING;
    }
    
    @Override
    public LongFunction<Language> deserializer() {
        return ref -> {
            final ByteBuffer buffer = bufferFinder.apply(ref);
            final int offset = offsetFinder.applyAsInt(ref);
            final Language entity = new LanguageImpl();
            entity.setLanguageId(buffer.getShort(offset + FIELD_LANGUAGE_ID));
            try {
                entity.setName(Utf8Util.deserialize(buffer,
                    offset + VARSIZE_BEGINS + 0,
                    offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_NAME)
                ));
            } catch (final Utf8Exception ex) {
                final LongToIntFunction sizeOf = sizeOf();
                throw new DeserializationException(buffer, offset, sizeOf.applyAsInt(ref), ex);
            }
            entity.setLastUpdate(new Timestamp(buffer.getLong(offset + FIELD_LAST_UPDATE)));
            return entity;
        };
    }
    
    @Override
    public Class<?> deserializedType(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return short.class;
                case LAST_UPDATE : return Timestamp.class;
                case NAME        : return String.class;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return short.class;
                case "last_update" : return Timestamp.class;
                case "name"        : return String.class;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public <FK_ENTITY> LongUnaryOperator finder(final ColumnIdentifier<Language> colId, final ColumnIdentifier<FK_ENTITY> fkColId) {
        return finder(singletonList(colId), singletonList(fkColId));
    }
    
    @Override
    public <FK_ENTITY> LongUnaryOperator finder(final List<ColumnIdentifier<Language>> cols, final List<ColumnIdentifier<FK_ENTITY>> fkCols) {
        throw new UnsupportedOperationException("Language has no foreign references.");
    }
    
    @Override
    public LongUnaryOperator finder(final String fkName) {
        throw new UnsupportedOperationException("Language has no foreign references.");
    }
    
    @Override
    public LongPredicate isNull(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : 
                case LAST_UPDATE : 
                case NAME        : return ALWAYS_FALSE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : 
                case "last_update" : 
                case "name"        : return ALWAYS_FALSE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongPredicate isPresent(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : 
                case LAST_UPDATE : 
                case NAME        : return ALWAYS_TRUE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : 
                case "last_update" : 
                case "name"        : return ALWAYS_TRUE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToByteFunction byteDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type byte.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToShortFunction shortDeserializer(final ColumnIdentifier<Language> colId) {
        if ("language_id".equals(colId.getColumnId())) {
            return ref -> bufferFinder.apply(ref).getShort(offsetFinder.applyAsInt(ref) + FIELD_LANGUAGE_ID);
        }
        
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type short.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction intDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type int.", colId.getColumnId())
        );
    }
    
    @Override
    public LongUnaryOperator longDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type long.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToFloatFunction floatDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type float.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToDoubleFunction doubleDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type double.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToCharFunction charDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type char.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToBooleanFunction booleanDeserializer(final ColumnIdentifier<Language> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type boolean.", colId.getColumnId())
        );
    }
    
    @Override
    public LongFunction<?> objectDeserializer(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LAST_UPDATE : return ref -> new Timestamp(bufferFinder.apply(ref).getLong(offsetFinder.applyAsInt(ref) + FIELD_LAST_UPDATE));
                case NAME        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int offset = offsetFinder.applyAsInt(ref);
                    try {
                        return Utf8Util.deserialize(buffer,
                            offset + VARSIZE_BEGINS + 0,
                            offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_NAME)
                        );
                    } catch (final Utf8Exception ex) {
                        final LongToIntFunction sizeOf = sizeOf();
                        throw new DeserializationException(buffer, offset, sizeOf.applyAsInt(ref), ex);
                    }
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "last_update" : return ref -> new Timestamp(bufferFinder.apply(ref).getLong(offsetFinder.applyAsInt(ref) + FIELD_LAST_UPDATE));
                case "name"        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int offset = offsetFinder.applyAsInt(ref);
                    try {
                        return Utf8Util.deserialize(buffer,
                            offset + VARSIZE_BEGINS + 0,
                            offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_NAME)
                        );
                    } catch (final Utf8Exception ex) {
                        final LongToIntFunction sizeOf = sizeOf();
                        throw new DeserializationException(buffer, offset, sizeOf.applyAsInt(ref), ex);
                    }
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public BiLongToIntFunction comparator(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return (aRef, bRef) -> Short.compare(
                    bufferFinder.apply(aRef).getShort(offsetFinder.applyAsInt(aRef) + FIELD_LANGUAGE_ID),
                    bufferFinder.apply(bRef).getShort(offsetFinder.applyAsInt(bRef) + FIELD_LANGUAGE_ID)
                );
                case LAST_UPDATE : return (aRef, bRef) -> Long.compare(
                    bufferFinder.apply(aRef).getLong(offsetFinder.applyAsInt(aRef) + FIELD_LAST_UPDATE),
                    bufferFinder.apply(bRef).getLong(offsetFinder.applyAsInt(bRef) + FIELD_LAST_UPDATE)
                );
                case NAME        : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_NAME);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_NAME);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return (aRef, bRef) -> Short.compare(
                    bufferFinder.apply(aRef).getShort(offsetFinder.applyAsInt(aRef) + FIELD_LANGUAGE_ID),
                    bufferFinder.apply(bRef).getShort(offsetFinder.applyAsInt(bRef) + FIELD_LANGUAGE_ID)
                );
                case "last_update" : return (aRef, bRef) -> Long.compare(
                    bufferFinder.apply(aRef).getLong(offsetFinder.applyAsInt(aRef) + FIELD_LAST_UPDATE),
                    bufferFinder.apply(bRef).getLong(offsetFinder.applyAsInt(bRef) + FIELD_LAST_UPDATE)
                );
                case "name"        : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_NAME);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_NAME);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public BiLongToIntFunction comparatorNullsLast(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return (aRef, bRef) -> Short.compare(
                    bufferFinder.apply(aRef).getShort(offsetFinder.applyAsInt(aRef) + FIELD_LANGUAGE_ID),
                    bufferFinder.apply(bRef).getShort(offsetFinder.applyAsInt(bRef) + FIELD_LANGUAGE_ID)
                );
                case LAST_UPDATE : return (aRef, bRef) -> Long.compare(
                    bufferFinder.apply(aRef).getLong(offsetFinder.applyAsInt(aRef) + FIELD_LAST_UPDATE),
                    bufferFinder.apply(bRef).getLong(offsetFinder.applyAsInt(bRef) + FIELD_LAST_UPDATE)
                );
                case NAME        : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_NAME);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_NAME);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return (aRef, bRef) -> Short.compare(
                    bufferFinder.apply(aRef).getShort(offsetFinder.applyAsInt(aRef) + FIELD_LANGUAGE_ID),
                    bufferFinder.apply(bRef).getShort(offsetFinder.applyAsInt(bRef) + FIELD_LANGUAGE_ID)
                );
                case "last_update" : return (aRef, bRef) -> Long.compare(
                    bufferFinder.apply(aRef).getLong(offsetFinder.applyAsInt(aRef) + FIELD_LAST_UPDATE),
                    bufferFinder.apply(bRef).getLong(offsetFinder.applyAsInt(bRef) + FIELD_LAST_UPDATE)
                );
                case "name"        : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_NAME);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_NAME);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction compareToByte(final ColumnIdentifier<Language> colId, final byte value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type byte.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToShort(final ColumnIdentifier<Language> colId, final short value) {
        if ("language_id".equals(colId.getColumnId())) {
            {
                final short operand = value;
                return ref -> Short.compare(
                    bufferFinder.apply(ref).getShort(offsetFinder.applyAsInt(ref) + FIELD_LANGUAGE_ID),
                    operand
                );
            }
        }
        
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type short.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToInt(final ColumnIdentifier<Language> colId, final int value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type int.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToLong(final ColumnIdentifier<Language> colId, final long value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type long.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToFloat(final ColumnIdentifier<Language> colId, final float value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type float.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToDouble(final ColumnIdentifier<Language> colId, final double value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type double.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToBoolean(final ColumnIdentifier<Language> colId, final boolean value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type boolean.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToChar(final ColumnIdentifier<Language> colId, final char value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type char.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToObject(final ColumnIdentifier<Language> colId, final Object value) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LAST_UPDATE : {
                    final long operand = ((Timestamp) value).getTime();
                    return ref -> Long.compare(
                        bufferFinder.apply(ref).getLong(offsetFinder.applyAsInt(ref) + FIELD_LAST_UPDATE),
                        operand
                    );
                }
                case NAME        : {
                    final ByteBuffer tempBuffer = ByteBuffer.wrap(((String) value).getBytes());
                    final int tempSize = tempBuffer.capacity();
                    return ref -> {
                        final ByteBuffer buffer = bufferFinder.apply(ref);
                        final int offset = offsetFinder.applyAsInt(ref);
                        return ByteBufferUtil.compare(buffer,
                            offset + VARSIZE_BEGINS + 0,
                            offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_NAME),
                            tempBuffer, 0, tempSize
                        );
                    };
                }
                default : {
                    throw new UnsupportedOperationException(
                        String.format("The column '%s' is either unknown or not of type object.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "last_update" : {
                    final long operand = ((Timestamp) value).getTime();
                    return ref -> Long.compare(
                        bufferFinder.apply(ref).getLong(offsetFinder.applyAsInt(ref) + FIELD_LAST_UPDATE),
                        operand
                    );
                }
                case "name"        : {
                    final ByteBuffer tempBuffer = ByteBuffer.wrap(((String) value).getBytes());
                    final int tempSize = tempBuffer.capacity();
                    return ref -> {
                        final ByteBuffer buffer = bufferFinder.apply(ref);
                        final int offset = offsetFinder.applyAsInt(ref);
                        return ByteBufferUtil.compare(buffer,
                            offset + VARSIZE_BEGINS + 0,
                            offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_NAME),
                            tempBuffer, 0, tempSize
                        );
                    };
                }
                default : {
                    throw new UnsupportedOperationException(
                        String.format("The column '%s' is either unknown or not of type object.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction compareToNull(final ColumnIdentifier<Language> colId) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : 
                case LAST_UPDATE : return ALWAYS_LESS;
                case NAME        : return ref -> bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_NAME) < 0 ? 0 : -1;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : 
                case "last_update" : return ALWAYS_LESS;
                case "name"        : return ref -> bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_NAME) < 0 ? 0 : -1;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongPredicate newPredicate(final ColumnIdentifier<Language> colId, final EntityStorePredicate predicate) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LANGUAGE_ID;
                    return predicate.test(buffer, begins, begins + Short.BYTES);
                };
                case LAST_UPDATE : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LAST_UPDATE;
                    return predicate.test(buffer, begins, begins + 8);
                };
                case NAME        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return predicate.test(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LANGUAGE_ID;
                    return predicate.test(buffer, begins, begins + Short.BYTES);
                };
                case "last_update" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LAST_UPDATE;
                    return predicate.test(buffer, begins, begins + 8);
                };
                case "name"        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return predicate.test(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction newCompareTo(final ColumnIdentifier<Language> colId, final EntityStoreCompareTo compareTo) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LANGUAGE_ID;
                    return compareTo.compare(buffer, begins, begins + Short.BYTES);
                };
                case LAST_UPDATE : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LAST_UPDATE;
                    return compareTo.compare(buffer, begins, begins + 8);
                };
                case NAME        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return compareTo.compare(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LANGUAGE_ID;
                    return compareTo.compare(buffer, begins, begins + Short.BYTES);
                };
                case "last_update" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_LAST_UPDATE;
                    return compareTo.compare(buffer, begins, begins + 8);
                };
                case "name"        : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return compareTo.compare(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public BiLongToIntFunction newComparator(final ColumnIdentifier<Language> colId, final EntityStoreComparator comparator) {
        if (colId instanceof Language.Identifier) {
            final Language.Identifier _id = (Language.Identifier) colId;
            switch (_id) {
                case LANGUAGE_ID : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_LANGUAGE_ID;
                    final int bBegins = bRowOffset + FIELD_LANGUAGE_ID;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + Short.BYTES,
                        bBuffer, bBegins, bBegins + Short.BYTES
                    );
                };
                case LAST_UPDATE : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_LAST_UPDATE;
                    final int bBegins = bRowOffset + FIELD_LAST_UPDATE;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + 8,
                        bBuffer, bBegins, bBegins + 8
                    );
                };
                case NAME        : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    return comparator.compare(
                        aBuffer, aRowOffset + VARSIZE_BEGINS, aRowOffset + VARSIZE_BEGINS + aBuffer.getInt(aRowOffset + ENDPOS_NAME), 
                        bBuffer, bRowOffset + VARSIZE_BEGINS, bRowOffset + VARSIZE_BEGINS + bBuffer.getInt(bRowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "language_id" : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_LANGUAGE_ID;
                    final int bBegins = bRowOffset + FIELD_LANGUAGE_ID;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + Short.BYTES,
                        bBuffer, bBegins, bBegins + Short.BYTES
                    );
                };
                case "last_update" : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_LAST_UPDATE;
                    final int bBegins = bRowOffset + FIELD_LAST_UPDATE;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + 8,
                        bBuffer, bBegins, bBegins + 8
                    );
                };
                case "name"        : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    return comparator.compare(
                        aBuffer, aRowOffset + VARSIZE_BEGINS, aRowOffset + VARSIZE_BEGINS + aBuffer.getInt(aRowOffset + ENDPOS_NAME), 
                        bBuffer, bRowOffset + VARSIZE_BEGINS, bRowOffset + VARSIZE_BEGINS + bBuffer.getInt(bRowOffset + ENDPOS_NAME)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction sizeOf() {
        return ref -> VARSIZE_BEGINS + Math.abs(bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_NAME));
    }
}