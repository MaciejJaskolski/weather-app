/*
 * This file is generated by jOOQ.
 */
package app.generated.tables;


import app.generated.Indexes;
import app.generated.Keys;
import app.generated.Weather;
import app.generated.tables.records.PogodaRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Pogoda extends TableImpl<PogodaRecord> {

    private static final long serialVersionUID = 929507904;

    /**
     * The reference instance of <code>weather.pogoda</code>
     */
    public static final Pogoda POGODA = new Pogoda();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PogodaRecord> getRecordType() {
        return PogodaRecord.class;
    }

    /**
     * The column <code>weather.pogoda.id</code>.
     */
    public final TableField<PogodaRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>weather.pogoda.nazwamiasta</code>.
     */
    public final TableField<PogodaRecord, String> NAZWAMIASTA = createField("nazwamiasta", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>weather.pogoda.data</code>.
     */
    public final TableField<PogodaRecord, Date> DATA = createField("data", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>weather.pogoda.mintemperatura</code>.
     */
    public final TableField<PogodaRecord, Double> MINTEMPERATURA = createField("mintemperatura", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>weather.pogoda.maxtemperatura</code>.
     */
    public final TableField<PogodaRecord, Double> MAXTEMPERATURA = createField("maxtemperatura", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>weather.pogoda.cisnienie</code>.
     */
    public final TableField<PogodaRecord, Double> CISNIENIE = createField("cisnienie", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>weather.pogoda</code> table reference
     */
    public Pogoda() {
        this(DSL.name("pogoda"), null);
    }

    /**
     * Create an aliased <code>weather.pogoda</code> table reference
     */
    public Pogoda(String alias) {
        this(DSL.name(alias), POGODA);
    }

    /**
     * Create an aliased <code>weather.pogoda</code> table reference
     */
    public Pogoda(Name alias) {
        this(alias, POGODA);
    }

    private Pogoda(Name alias, Table<PogodaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Pogoda(Name alias, Table<PogodaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Weather.WEATHER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.POGODA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PogodaRecord> getPrimaryKey() {
        return Keys.KEY_POGODA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PogodaRecord>> getKeys() {
        return Arrays.<UniqueKey<PogodaRecord>>asList(Keys.KEY_POGODA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pogoda as(String alias) {
        return new Pogoda(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pogoda as(Name alias) {
        return new Pogoda(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Pogoda rename(String name) {
        return new Pogoda(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Pogoda rename(Name name) {
        return new Pogoda(name, null);
    }
}